package Support;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import org.jetbrains.annotations.NotNull;

public class EmbedEdit extends ListenerAdapter {
    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {
        if (event.getModalId().equals("edit")) {

            String name = event.getValue("title").getAsString();
            String desc = event.getValue("description").getAsString();


            EmbedBuilder image = new EmbedBuilder();
            EmbedBuilder eb = new EmbedBuilder();
            image.setImage("https://cdn.discordapp.com/attachments/985493341212909570/1033088329073307669/Support_Anfrage.png");
            image.setColor(0x96e6ff);
            eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

            eb.addField(name, desc, true);
            eb.setColor(0x96e6ff);


            VoicePing.builders.add(eb);

            for (Object s : VoicePing.builders.get(0).getFields().stream().toArray()){

                System.out.println(s.toString());
            }
            event.replyEmbeds(image.build(), eb.build()).addActionRows(VoicePing.buttons(), ActionRow.of(VoicePing.selectMenu())).queue();

        }
    }
}
