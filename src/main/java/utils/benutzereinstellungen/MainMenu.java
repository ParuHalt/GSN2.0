package utils.benutzereinstellungen;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

public class MainMenu extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {

            if (event.getMessage().getContentStripped().startsWith("!mainmenu")) {
                event.getChannel().sendMessage("Wähle dein alter!:").setActionRow(sendAgeRoles()).queue();
            }
        }
    }

    private static SelectMenu sendAgeRoles() {
        return SelectMenu.create("age")
                .setPlaceholder("Age auswählen blyat!")
                .addOption("under 18", "under18", "Klicke um diese Option zu wählen!", Emoji.fromMarkdown("\uD83D\uDC51"))
                .addOption("18 - 20", "18-20", "Klicke um diese Option zu wählen!", Emoji.fromMarkdown("\uD83D\uDC65"))
                .addOption("21 - 25", "21-25", "Klicke um diese Option zu wählen!", Emoji.fromMarkdown("\uD83D\uDCC5"))
                .addOption("26 - 30", "26-30", "Klicke um diese Option zu wählen!", Emoji.fromMarkdown("\uD83C\uDF89"))
                .addOption("over 30", "over30", "Klicke um diese Option zu wählen!", Emoji.fromMarkdown("\uD83C\uDF89"))
                .addOption("Reset Button", "resetage", "Du hast dich verklickt? Hier kannst du die rollen Zurücksetzen!")
                .setRequiredRange(1, 1)
                .build();
    }
}