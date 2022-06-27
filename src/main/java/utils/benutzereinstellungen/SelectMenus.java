package utils.benutzereinstellungen;

import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

public class SelectMenus extends ListenerAdapter {


    public void onSelect(SelectMenuInteractionEvent event) {

    }


    private static SelectMenu sendServerInformations() {
        return SelectMenu.create("info")
                .setPlaceholder("Wähle deine Rollen aus!").build();

    }
}
