package utils.benutzereinstellungen;

import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AgeRoles extends ListenerAdapter {

    public void onSelectMenuInteraction(SelectMenuInteractionEvent event) {

        if (event.getComponent().getId().equals("age")) {

            for (int i = 0; i < event.getValues().size(); i++) {

                switch (event.getValues().get(i)) {

                    case "under18":
                        event.getUser().openPrivateChannel().queue( privateChannel -> {
                            privateChannel.sendMessage("Der aktuelle Owner ist: **" + event.getGuild().getOwner().getUser().getName() + "**").queue();
                        });
                        break;

                    case "18-20":
                        event.getUser().openPrivateChannel().queue(privateChannel -> {
                            privateChannel.sendMessage("Der Server hat akutell **" + event.getGuild().getMemberCount() + "** Member").queue();
                        });
                        break;

                    case "21-25":
                        event.getUser().openPrivateChannel().queue( privateChannel -> {
                            privateChannel.sendMessage("Der Server wurde am **" + "Pimmel" + "** erstellt").queue();
                        });
                        break;

                    case "26-30":
                        event.getUser().openPrivateChannel().queue( privateChannel -> {
                            privateChannel.sendMessage("Der Server hat aktuell **" + event.getGuild().getBoostCount() + "** Booster").queue();
                        });
                        break;

                    case "over30":
                        event.reply("Dein alter wurde gesetzt :)").setEphemeral(true).queue();
                        event.getUser().openPrivateChannel().queue( privateChannel -> {
                            privateChannel.sendMessage("Bla Bla").queue();
                        });
                        break;

                    case "restage":
                        event.getUser().openPrivateChannel().queue( privateChannel -> {
                            privateChannel.sendMessage("Bla Bla Reset").queue();
                        });
                        break;

                    default:
                        break;
                }
            }

            event.reply("Dir wurden alle Infos Privat geschickt").setEphemeral(true).queue();

        }
    }
}
