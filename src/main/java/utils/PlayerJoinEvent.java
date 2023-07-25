package utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class PlayerJoinEvent extends ListenerAdapter {
    static int mcount = 0;

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        EmbedBuilder banner = new EmbedBuilder();
        EmbedBuilder eb = new EmbedBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = new Date();

        banner.setImage("https://media.discordapp.net/attachments/818211419974664214/988044645382639626/Willkommen.png");
        banner.setColor(0x4b3488);

        eb.setDescription("**Wilkommen** auf unseren Server " +event.getMember().getAsMention()+ ".\n" + " > Ließ dir am besten die Nachricht über dieser hier durch, um dich auf dem Server besser zurechtzufinden.");
        eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");
        eb.setThumbnail("https://images-ext-2.discordapp.net/external/TODxS2KKOzgJKMUsaqY-8udZKx4jcyBCxxyXuyk8tDY/%3Fsize%3D96%26quality%3Dlossless/https/cdn.discordapp.com/emojis/989253972453896192.gif");
        eb.setFooter(" | Have fun (╯°□°）╯︵ ┻━┻ | " + formatter.format(date), event.getMember().getEffectiveAvatarUrl());
        eb.setColor(0x4b3488);

        event.getGuild().getTextChannelById("985215300565864519").sendMessageEmbeds(banner.build(), eb.build()).complete().delete().queueAfter(10L,TimeUnit.MINUTES);

        for (Member m : event.getGuild().getMembers()) {
            if (!m.getUser().isBot()) {
                mcount++;
            }
        }
        Timer t1 = new Timer();
        t1.schedule(new TimerTask() {
            @Override
            public void run() {
                event.getGuild().getVoiceChannelById("1045745860924948600").getManager().setName("│👥-Mitglieder: " + mcount).queue();
            }
        }, 1000);
    }
}
