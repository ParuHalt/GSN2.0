package modules;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class EmbedCommand extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentStripped().toLowerCase(Locale.ROOT).startsWith("!penis")) {
            ArrayList<String> messages = new ArrayList<String>(Arrays.asList(event.getMessage().getContentStripped().split(" ")));
            messages.remove(0);

            EmbedBuilder builder = new EmbedBuilder();
            builder.setDescription(String.join(" ", messages));
            builder.setColor(Color.RED);


            event.getMessage().delete().queue();
            event.getChannel().sendMessageEmbeds(builder.build()).queue();
        }

    }
}
