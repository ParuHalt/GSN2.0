package SelfMadeEmbeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class WillAuchChannel extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().equals("!willauchchannelembed") && event.getMember().hasPermission(Permission.ADMINISTRATOR)) {

            EmbedBuilder image = new EmbedBuilder();
            EmbedBuilder eb = new EmbedBuilder();
            EmbedBuilder eb1 = new EmbedBuilder();
            EmbedBuilder eb2 = new EmbedBuilder();

            image.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044644753485824/will_auch_channel.png");
            image.setColor(0x4b3488);

            eb.setColor(0x4b3488);
            eb.setTitle("Du möchtest deinen eigenen Channel?");
            eb.setDescription("Kein Problem.\n" + "> Hier unterscheiden sich lediglich die **Temporären** von den **Permanenten** Channeln.");
            eb.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");

            eb1.setColor(0x4b3488);
            eb1.setTitle("Temporäre Channel:");
            eb1.setDescription("> Temporäre Channel können von **jedem erstellt**, **selbst eingestellt** und genutzt werden.");
            eb1.addField("Wie erstelle ich einen temporären Channel?", "> Dazu müsst ihr euch in den Voice Channel **\uD835\uDDD6\uD835\uDDFF\uD835\uDDF2\uD835\uDDEE\uD835\uDE01\uD835\uDDF2 \uD835\uDDD6\uD835\uDDF5\uD835\uDDEE\uD835\uDDFB\uD835\uDDFB\uD835\uDDF2\uD835\uDDF9** verbinden.\n" +
                    "\n" + "Sobald ihr den Channel betreten habt, **erstellt ein Bot automatisch einen Channel** in derselben **Kategorie** und moved euch in den Channel.\n" +
                    "\n" + "> Wie schon erwähnt habt ihr in dem Channel **alle Berechtigungen** um ihn zu Bearbeiten.\n" +
                    "*(Dann könnt ihr Sachen wie: Userlimmit, Channelname, etc... ändern)*\n" +
                    "\n" + "> Der Channel wird automatisch **gelöscht** sobald kein **User** mehr darin ist.", false);
            eb1.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");

            eb2.setColor(0x4b3488);
            eb2.setTitle("Permanente Channel:");
            eb2.setDescription("> Permanente Channel können ab **Level 10** angefragt werden.");
            eb2.addField("Wie läuft sowas ab?", "> Permanente Channel können im **\uD835\uDDE9\uD835\uDDFC\uD835\uDDF6\uD835\uDDF0\uD835\uDDF2 \uD835\uDDE6\uD835\uDE02\uD835\uDDFD\uD835\uDDFD\uD835\uDDFC\uD835\uDDFF\uD835\uDE01** beantragt werden.\n" +
                    ":information_source: **► Teammitglieder** ab dem Rang **<@&984886823232893019>** können permanente Channel erstellen.\n" +
                    "\n" + "> Im **Support** Gespräch könnt ihr zusammen mit dem Ersteller euren **eigenen Channel** erstellen.\n" +
                    "Hier könnt ihr Absprachen treffen wie, ob der Channel für alle sichtbar sein soll oder ob ein Freund auch move Rechte bekommen soll etc.\n" +
                    "\n" + "> Insofern ihr einen \"**Privaten**\" Permanenten Channel erstellt, könnt ihr Leute aus ⏳ **\uD835\uDDEA\uD835\uDDEE\uD835\uDDF6\uD835\uDE01 \uD835\uDFF0 \uD835\uDDE0\uD835\uDDFC\uD835\uDE03\uD835\uDDF2** selbständig in euren Channel **moven**.", false);
            eb2.addField("Kann jeder einen Permanenten Channel bekommen?", "> Permanente Channel sollte denen vorbehalten sein, die sie auch **benötigen**.\n" +
                    "d. h. **Streamer**, **Streamer Communitys** oder auch kleine Gruppierungen **ab 3 Leuten**.\n" +
                    "\n" + "> Wir möchten das Permanente Channel auch **genutzt** werden.\n" +
                    "d. h. sollte ein Channel über **1 Woche** nicht genutzt werden, wird dieser **gelöscht**.\n" +
                    "*(Kann aber auch wiedererlangt werden, insofern **Bedarf** besteht.)* \n" +
                    "\n" + "> Wir möchten als **Server Team** einfach nur sicher gehen, das für **alle** genug Channel vorhanden sind und jeder zufrieden ist.\n" +
                    "\n" + "**Falls Fragen aufgekommen sind, könnt ihr diese gern im Support stellen.** :wink:", false);
            eb2.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

            event.getChannel().sendMessageEmbeds(image.build(), eb.build(), eb1.build(), eb2.build()).queue();
        }
    }
}
