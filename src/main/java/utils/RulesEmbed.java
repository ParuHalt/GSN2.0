package utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class RulesEmbed extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
        if (event.getMessage().getContentStripped().startsWith("!rules")) {

            EmbedBuilder banner = new EmbedBuilder();
            EmbedBuilder eb = new EmbedBuilder();
            EmbedBuilder footer = new EmbedBuilder();

            banner.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044646229889115/Regeln.png");
            banner.setColor(0x4b3488);

            eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");
            eb.setColor(0x4b3488);
            eb.setDescription("Um das Miteinander auf unserem Discord so angenehm wie möglich zu gestalten, bitten wir dich, die folgenden Regeln zu lesen, zu verstehen und zu akzeptieren.");
            eb.addField("Die Missachtung dieser Regeln kann von einem Kick bis zu einem Bann auf unserem Discord führen.", "**§1** Jegliche Aktivitäten mit folgenden Inhalten werden bei uns **nicht geduldet** und sofort **entfernt**:", false);
            eb.addField("_ _", "> <a:bc:990255819406843914> pornografische oder anstößige Inhalte außerhalb des NSFW Channels\n" +
                    "> <a:bc:990255819406843914> illegale und/oder rassistische Inhalte und Aufforderungen zu diesen Handlungen\n" +
                    "> <a:bc:990255819406843914> Anleitungen oder Erörterungen zum Ausführen illegaler Handlungen (z.B. illegale Downloads)\n" +
                    "> <a:bc:990255819406843914> verleumderische oder belästigende Inhalte\n " + " > <a:bluecheckmark:990255819406843914> Software oder Dienste für den Vertrieb unerwünschter E-Mail-Nachrichten (Spam)\n" +
                    "> <a:bc:990255819406843914> Links auf Seiten, die eine Vergütung für das Aufrufen deiner Seite zahlen (Referer-IDs, etc...)\n" +
                    "> <a:bc:990255819406843914> Inhalte, die gegen geltendes deutsches Recht verstoßen\n" +
                    "> <a:bc:990255819406843914> kommerzielle und/oder reine Werbepostings\n" +
                    "> <a:bc:990255819406843914> Beleidigungen, Aggressivität und Hetze\n" +
                    "> <a:bc:990255819406843914> Serverwerbung\n" +
                    "> <a:bc:990255819406843914> Spam\n" +
                    "> <a:bc:990255819406843914> Multyaccounts", false);

            eb.addField("_ _", "**§2** Solltet ihr im Besitz eines <@&984888018026524702> oder <@&984887864712122438> Rangs sein, so nimmt sich das Stream Nation Team jederzeit das Recht euch bei grobem Fehlverhalten des Ranges zu verweisen.", false);

            footer.setTitle("Soweit alles verstanden ?");
            footer.setDescription("> Klicke auf den Button, um uns zu verstehen zu geben, dass du diese Regeln gelesen hast und befolgen wirst.");
            footer.addField("_ _", "<a:yeh:990256005550055444><a:bannana:990254815407915018> **Viel Spaß wünscht euch das Stream Nation Team.** <a:hakcan:990255300877643846><a:rickroll:990255795226681365>", false);
            footer.setColor(0x52d557);

            Button getVerifyUser = Button.success("getVerifyUser", "Ja, ich habe alles verstanden").withEmoji(Emoji.fromMarkdown("<a:somiteinander:816926638247510036>"));

            event.getTextChannel().sendMessageEmbeds(banner.build(), eb.build(), footer.build()).setActionRow(getVerifyUser).queue();
        }

    }
}


    public void onButtonInteraction(ButtonInteractionEvent event) {

        if (event.getButton().getId().equals("getVerifyUser")) {

            Button gotoBenutzereinstellungen = Button.link("https://discord.com/channels/984470784972042271/984470785441812542/990269978701881454", "(Coming soon)").withEmoji(Emoji.fromMarkdown("<a:mauscursor:817016897837072454>"));

            EmbedBuilder replyembed = new EmbedBuilder();
            EmbedBuilder bannerreply = new EmbedBuilder();

            bannerreply.setImage("https://cdn.discordapp.com/attachments/990240111042113536/990992836193288242/plus_Verifiziert.png");
            bannerreply.setColor(0x52d557);

            replyembed.setThumbnail("https://cdn.discordapp.com/emojis/990356659656331284.gif?size=96&quality=lossless");
            replyembed.setColor(0x52d557);
            replyembed.setTitle("Du bist jetzt verifiziert");
            replyembed.addField("Du kannst dich auf dem Server jetzt frei bewegen.", "> Wenn du möchtest, kannst du jetzt noch dein Profil anpassen, um beispielsweise deine aktuellen Lieblingsspiele hinzuzufügen, um gegebenenfalls andere Mitspieler für deine Games zu finden und noch viel mehr.", false);
            replyembed.addField("_ _", "Klicke auf den Button, um zu den Benutzereinstellungen zu gelangen.", false);
            replyembed.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

            Role getUser = event.getGuild().getRoleById("984818161314590770");
            event.getGuild().addRoleToMember(event.getMember(), getUser).queue();

            event.replyEmbeds(bannerreply.build(), replyembed.build()).addActionRow(gotoBenutzereinstellungen).setEphemeral(true).queue();


        }

    }

}
