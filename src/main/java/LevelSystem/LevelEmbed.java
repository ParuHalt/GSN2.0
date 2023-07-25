package LevelSystem;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class LevelEmbed extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().equals("!levelembed") && event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.getMessage().delete().queue();

            EmbedBuilder image = new EmbedBuilder();
            EmbedBuilder eb = new EmbedBuilder();
            EmbedBuilder eb1 = new EmbedBuilder();

            image.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044645575557120/Level_Bot.png");
            image.setColor(0x4b3488);

            eb.setTitle("Willkommen im Channel #│📈-\uD835\uDDDF\uD835\uDDF2\uD835\uDE03\uD835\uDDF2\uD835\uDDF9-\uD835\uDDD5\uD835\uDDFC\uD835\uDE01");
            eb.setColor(0x4b3488);
            eb.setDescription("Hier findest du alle nützlichen Befehle.");
            eb.addField("Lederboard:", "> **/Leaderboard**\n" +
                    "Hier kannst du sehen, wer das höchste Level auf dem Server hat.", true);
            eb.addField("Level Information eines Users:", "> **/Rank <@User>**\n" +
                    "Alternativ kannst du auch **Rechtsklick** auf den User machen und dir unter **Apps > Show Rank** sein/ihr Level anzeigen lassen.", true);
            eb.addField("Zeige dir alle Ränge an:", "> **/Rewards**\n" +
                    "Sooo viele Farben...", true);
            eb.addField("Vorteile für Booster", "Insofern ihr den Rang <@&984897728029003866> habt, bekommt ihr automatisch einen **2x Multiplikator.**", false);
            eb.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");

            eb1.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");
            eb1.setColor(0x4b3488);
            eb1.setTitle("Was bringen dir bestimmte Level?");
            eb1.addField("Level 5+", "✅ Berechtigung für <#985559482778132580>\n" +
                    "✅ Berechtigung um <#1045749085963030558> zu starten!", true);
            eb1.addField("Level +10", "✅ Berechtigung für <#985559482778132580>", true);
            eb1.addField("Level +15", "✅ Berechtigung für Teamler Bewerbungen. (comming soon...)", true);

            Button leaderborad = Button.primary("lb", "Leaderborad").withEmoji(Emoji.fromFormatted("📊"));

            event.getChannel().sendMessageEmbeds(image.build(), eb.build(), eb1.build()).setActionRow(leaderborad).queue();

            }

        if (event.getChannel().getId().equals("1130821106488574092")) {
            event.getMessage().delete().queueAfter(10L, TimeUnit.MINUTES);


        }
    }
}

