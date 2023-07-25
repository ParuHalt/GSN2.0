package modules;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionHook;

public class Testclass extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e) {

        if(!e.getChannelType().equals(ChannelType.PRIVATE) && e.getMessage().getContentDisplay().equals("!testclass") && e.getMember().hasPermission(Permission.ADMINISTRATOR)) {

            EmbedBuilder eb = new EmbedBuilder();

            eb.setImage("https://images-ext-2.discordapp.net/external/MQjdG7jblpG_PRBM7lPKlz7U9YCMMWEoNL4llp3P054/https/c.tenor.com/RY8NBEy3XUQAAAAi/rickroll-transparent.gif");

            e.getChannel().sendMessageEmbeds(eb.build()).queue();

        }

    }

    public void onButtonInteraction(ButtonInteractionEvent e) {

        if(e.getComponentId().equals("gsn.testbutton1")) {

            InteractionHook ih = e.reply("Emoji: " + Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Hessen:992482069261340752>")).setEphemeral(true).complete();

        }

        if(e.getComponentId().equals("gsn.testbutton2")) {

            e.reply("Emoji: <:50pxDeutschland_Lage_von_Hessen:992482069261340752>").setEphemeral(false).queue();

        }

        if(e.getComponentId().equals("gsn.testbutton3")) {

            e.getChannel().sendMessage("Emoji: <:50pxDeutschland_Lage_von_Hessen:992482069261340752>").queue();

        }

    }

}
