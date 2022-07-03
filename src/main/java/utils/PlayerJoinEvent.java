package utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerJoinEvent extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        EmbedBuilder banner = new EmbedBuilder();
        EmbedBuilder eb = new EmbedBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = new Date();

        banner.setImage("https://media.discordapp.net/attachments/818211419974664214/988044645382639626/Willkommen.png");
        banner.setColor(0x4b3488);

        eb.setDescription("**Wilkommen** auf unseren Server " +event.getMember().getAsMention()+ ".\n" + " > Ließ dir am besten ganz in Ruhe den Channel" +
                " <#985215300565864519> durch, um dich auf unseren " +
                "Discord besser zurechtzufinden.");
        eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");
        eb.setThumbnail("https://images-ext-2.discordapp.net/external/TODxS2KKOzgJKMUsaqY-8udZKx4jcyBCxxyXuyk8tDY/%3Fsize%3D96%26quality%3Dlossless/https/cdn.discordapp.com/emojis/989253972453896192.gif");
        eb.setFooter(" | Have fun (╯°□°）╯︵ ┻━┻ | " + formatter.format(date), event.getMember().getEffectiveAvatarUrl());
        eb.setColor(0x4b3488);

        Button gotoReadMe = Button.link("https://discord.com/channels/984470784972042271/985215300565864519/990262141179277382", "Hier kommst du zu dem Channel ReadMe").withEmoji(Emoji.fromFormatted("<a:greencheckmark:990255860821413909>"));
        event.getGuild().getTextChannelById("984821448533225522").sendMessageEmbeds(banner.build(), eb.build()).setActionRow(gotoReadMe).queue();
    }

}

