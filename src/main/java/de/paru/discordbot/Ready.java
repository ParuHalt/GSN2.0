package de.paru.discordbot;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ready extends ListenerAdapter {

    public void onReady(ReadyEvent e) {

        System.out.println("Und ich bin ready!");

    }

}
