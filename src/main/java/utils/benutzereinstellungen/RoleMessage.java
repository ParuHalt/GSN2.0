package utils.benutzereinstellungen;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

public class RoleMessage {

    public SelectMenu.Builder selectMenu;
    EmbedBuilder embed;
    String resetString;

    public RoleMessage(SelectMenu.Builder selectMenu, EmbedBuilder embed, String resetString) {

        this.selectMenu = selectMenu;
        this.embed = embed;
        this.resetString = resetString;

    }

}
