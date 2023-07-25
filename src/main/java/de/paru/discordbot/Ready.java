package de.paru.discordbot;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import static de.paru.discordbot.DiscordBot.JDA;

public class Ready extends ListenerAdapter {

    public void onReady(ReadyEvent e) {

        Guild guild = JDA.getGuildById("984470784972042271");

        if (guild != null) {

            //Umfrage
            guild.upsertCommand("umfrage", "|📊-Erstelle eine Umfrage")
                    .addOption(OptionType.STRING, "question", "Frage", true)
                    .addOption(OptionType.INTEGER, "time", "Zeit in Min", true)
                    .queue();


            guild.upsertCommand("clear", "🔨〢Lösche mehrere Nachrichten aus einem Kanal")
                    .addOption(OptionType.INTEGER, "amount", "Zahl angeben")
                    .queue();

        }

        System.out.println("Und ich bin ready!");

    }

}
