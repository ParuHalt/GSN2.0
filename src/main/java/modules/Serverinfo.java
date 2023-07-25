package modules;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Serverinfo extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentStripped().startsWith("!serverinfo")) {
            event.getChannel().sendMessageEmbeds(serverInfo(event.getGuild()).build()).queue();
        }

    }
    private EmbedBuilder serverInfo(Guild guild) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        OffsetDateTime date = guild.getTimeCreated();
        String formatted = df.format(date);


        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(0x4b3488);
        builder.setTitle(guild.getName());
        builder.setDescription("Allgemeine Informationen über " + guild.getName());
        builder.addField("Member:", String.valueOf(guild.getMemberCount()), true);
        builder.addBlankField(true);
        builder.addField("Erstellt:", formatted,true);
        builder.addField("Gründer:", guild.getOwner().getUser().getName(), true);
        builder.addField("Booster:", String.valueOf(guild.getBoostCount()), true);
        builder.addField("Booster Level:", String.valueOf(guild.getBoostTier()), true);

        builder.setThumbnail(guild.getIconUrl());

        return builder;

    }
}

