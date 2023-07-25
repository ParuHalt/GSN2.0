package modules;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Clear extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("clear") && event.getMember().hasPermission(Permission.ADMINISTRATOR)) {

            try {

                int amount = event.getOption("amount").getAsInt();

                event.getChannel().asTextChannel().deleteMessages(event.getChannel().getHistory().retrievePast(amount).complete()).queue();

                EmbedBuilder image = new EmbedBuilder();
                EmbedBuilder eb = new EmbedBuilder();

                image.setImage("https://cdn.discordapp.com/attachments/987815549880926218/1130811987660656711/Erfolgreich.png");
                image.setColor(0x52d557);

                eb.setTitle("Erfolgreich");
                eb.setDescription("Erfolgreich " + "`" + amount + "`" + " Nachrichten gelöscht!");
                eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");
                eb.setColor(0x52d557);

                event.replyEmbeds(image.build(), eb.build()).setEphemeral(true).queue();

            } catch (IllegalArgumentException e) {

                EmbedBuilder image = new EmbedBuilder();
                EmbedBuilder eb = new EmbedBuilder();

                image.setImage("https://cdn.discordapp.com/attachments/987815549880926218/1033043169216045149/Fehlermeldung.png");
                image.setColor(0xff3232);

                eb.setTitle("Fehler");
                eb.setDescription("Du kannst maximal `100` Nachrichten löschen!");
                eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");
                eb.setColor(0xff3232);

                event.replyEmbeds(image.build(), eb.build()).setEphemeral(true).queue();

            }
        }
    }
}

