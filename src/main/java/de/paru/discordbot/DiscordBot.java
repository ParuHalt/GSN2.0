package de.paru.discordbot;

import commands.ServerInfo;
import commands.StopCommand;
import commands.ViewCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import utils.*;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    public static void main(String[] args) throws LoginException, IllegalArgumentException  {


        String token = "OTg3NjY1MDEyMjI1MDg1NDUw.Gs7-Cj.xpWoOValS-XHN3h3lG0ppHuIijz9djeY40CZ4o";


        JDABuilder builder = JDABuilder.createDefault(token);

        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.streaming("[GER] Stream Nation", "https://www.twitch.tv/parulive"));
        builder.addEventListeners(new ViewCommand());
        builder.addEventListeners(new StopCommand());
        builder.addEventListeners(new PlayerJoinEvent());
        builder.addEventListeners(new ReadMeEmbed());
        builder.addEventListeners(new RulesEmbed());
        builder.addEventListeners(new ServerInfo());

        builder.enableCache(CacheFlag.ACTIVITY);
        builder.enableCache(CacheFlag.ONLINE_STATUS);
        builder.enableCache(CacheFlag.CLIENT_STATUS);


        builder.setChunkingFilter(ChunkingFilter.ALL);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGES);

        JDA bot = builder.build();
        System.out.println("Mashalla ich bin da!");
    }
}
