package utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ReadMeEmbed extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {

            if (event.getMessage().getContentStripped().equals("!readme")) {

                EmbedBuilder banner = new EmbedBuilder();
                EmbedBuilder eb = new EmbedBuilder();
                EmbedBuilder footer = new EmbedBuilder();

                banner.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044645768507402/PNG.png");
                banner.setColor(0x4b3488);

                eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");
                eb.setColor(0x4b3488);
                eb.setTitle("**Willkommen** auf dem Server [GER] Stream Nation");
                eb.setDescription("Was kannst du auf diesem Discord machen und wofür gibt es ihn überhaupt?");
                eb.addField("Unser Discord:", "> Auf diesem Discord kannst du mit deiner eigenen Community oder auch mit anderen Streamer Communitys abhängen, ihr könnt euch gemeinsam aufbauen oder einfach miteinander chillig zocken.", false);
                eb.addField("Du bist relativ neu in der Szene und hast viele Fragen?", "> Dann ist der Channel <#984901308530163793> vielleicht ganz nützlich für dich, um dich mit anderen auszutauschen oder Neulingen zu helfen und sie zu supporten.", true);
                eb.addField("Du suchst einfach nur Leute zum Zocken?", "> Dann kannst du dich in dem Channel <#984899271151214592> auf die Suche nach Teammates begeben.", true);
                eb.addField("Du möchtest deine Streams oder Youtube Videos teilen?", "> Dann schau dich mal in dem Channel <#985559482778132580> um.", true);
                eb.addField("Du möchtest deinen eigenen Channel auf unserem Discord?", "> Dann schau dich mal in dem Channel <#985522271064039514> um. In deinem eigenen Channel kannst du dich wie Zuhause fühlen.", true);
                eb.addField("Dir geht jemand gehörig auf den Sack?", "> Dann schau dich einfach im Channel <#984900352379863101> um.", true);
                eb.addField("_ _", "\n" + "\n" + "*\"Sei freundlich zu anderen, dann sind sie es auch zu dir\"*", false);

                footer.setColor(0x52d557);
                footer.setTitle("Soweit alles verstanden?");
                footer.setDescription("> Dann klicke auf den Button, um zu den <#984470785441812542> zu gelangen.");

                Button getUser = Button.success("getUser", "Ja, ich habe alles verstanden").withEmoji(Emoji.fromFormatted("<a:tanzendekuh:782165263512633375>"));

                event.getTextChannel().sendMessageEmbeds(banner.build(), eb.build(), footer.build()).setActionRow(getUser).queue();

            }

        }

    }

    public void onButtonInteraction(ButtonInteractionEvent event) {

        if (event.getButton().getId().equals("getUser")) {

            InteractionHook ih = event.deferReply(true).complete();

            Button gotoRules = Button.link("https://discord.com/channels/984470784972042271/984470785441812542/990269978701881454", "Hier kommst du zu den Regeln").withEmoji(Emoji.fromFormatted("<a:mauscursor:817016897837072454>"));


            EmbedBuilder replyembed = new EmbedBuilder();
            EmbedBuilder bannerreply = new EmbedBuilder();

            bannerreply.setImage("https://cdn.discordapp.com/attachments/990240111042113536/990992845961846784/plus_User.png");
            bannerreply.setColor(0x52d557);

            replyembed.setThumbnail("https://cdn.discordapp.com/emojis/990356659656331284.gif?size=96&quality=lossless");
            replyembed.setColor(0x52d557);
            replyembed.setTitle("Du hast jetzt die Rechte, um in dir die Regeln anzuschauen.");
            replyembed.setDescription("Klicke auf den Button, um zu den Regeln zu gelangen.");
            replyembed.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

            ih.editOriginalEmbeds(bannerreply.build(), replyembed.build()).setActionRows(ActionRow.of(gotoRules)).queueAfter(500, TimeUnit.MILLISECONDS);

            Role getUser = event.getGuild().getRoleById("984472157012770887");
            event.getGuild().addRoleToMember(event.getMember(), getUser).queue();

        }

    }
}
