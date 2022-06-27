package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ViewCommand extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        Member user = event.getMember();
        if (event.getAuthor().isBot()) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase("!profile")) {
            if (!event.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {
                user.getUser().openPrivateChannel().complete().sendMessage("Dazu hast du keine Rechte!").queue();
                return;
            }

            User user1 = event.getAuthor();
            List<User> mentionedUser = event.getMessage().getMentions().getUsers();
            if (mentionedUser.size() > 0) {
                User userTarget = mentionedUser.get(0);
                event.getGuild().retrieveMember(userTarget).queue(member -> {

                    EmbedBuilder builder = new EmbedBuilder();
                    builder.setTitle(userTarget.getName() + " | Profile");
                    builder.addField("Name", userTarget.getAsTag(), false);
                    builder.addField("ID", userTarget.getId(), false);
                    builder.addField("Rolle", member.getRoles().get(0).getAsMention(), true);
                    builder.addField("Account Created", userTarget.getTimeCreated().format(DateTimeFormatter.RFC_1123_DATE_TIME), false);
                    builder.addField("Guild Joined", member.getTimeJoined().format(DateTimeFormatter.RFC_1123_DATE_TIME), false);
                    builder.addField("OnlineStatus", member.getOnlineStatus().toString(), false);
                    builder.addField("Boost Status", String.valueOf(member.isBoosting()), false);
                    builder.addField("Client", member.getActiveClients().toString(), true);
                    builder.addField("Gemeinsame Server", user1.getMutualGuilds().toString(), false);
                    builder.setColor(0x4b3488);
                    builder.setThumbnail(userTarget.getAvatarUrl());
                    event.getChannel().sendMessageEmbeds(builder.build()).queue();
                    builder.clear();
                    event.getMessage().delete().queue();


                });
            }
        }


    }
}

