package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class StopCommand extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equals("!stop")) {
            if(event.getAuthor().getId().equals("261177656249155585")) {
                event.getAuthor().openPrivateChannel().complete().sendMessage("Der Bot wird neugestartet!").queue();
                System.exit(1);


            }
        }
    }
}
