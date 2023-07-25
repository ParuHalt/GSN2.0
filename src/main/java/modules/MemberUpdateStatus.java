package modules;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/*public class MemberUpdateStatus extends ListenerAdapter {

    static String VCID = "1045745977488842863";

    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {

        Guild guild = event.getGuild();

        System.out.println(event.getMember().getOnlineStatus() == OnlineStatus.ONLINE);
        System.out.println(event.getMember().getUser().getAsTag());
        int x = 0;
        for (Member m : event.getGuild().getMembers()) {
            if (!m.getUser().isBot() && m.getOnlineStatus().equals(OnlineStatus.ONLINE)) {
                event.getGuild().getVoiceChannelById(VCID).getManager().setName(("│🟢" + x++ + "⛔" + x++ + "🌙"+ x++ + "⚫" + x++)).queueAfter(5L, TimeUnit.MINUTES);
                if (!m.getUser().isBot() && m.getOnlineStatus().equals(OnlineStatus.DO_NOT_DISTURB)) {
                    event.getGuild().getVoiceChannelById(VCID).getManager().setName(("│🟢" + x++ + "⛔" + x++ + "🌙" + x++ + "⚫" + x++)).queueAfter(5L, TimeUnit.MINUTES);
                    if (!m.getUser().isBot() && m.getOnlineStatus().equals(OnlineStatus.IDLE)) {
                        event.getGuild().getVoiceChannelById(VCID).getManager().setName(("│🟢" + x++ + "⛔" + x++ + "🌙" + x++ + "⚫" + x++)).queueAfter(5L, TimeUnit.MINUTES);
                        if (!m.getUser().isBot() && m.getOnlineStatus().equals(OnlineStatus.OFFLINE)) {
                            event.getGuild().getVoiceChannelById(VCID).getManager().setName(("│🟢" + x++ + "⛔" + x++ + "🌙" + x++ + "⚫" + x++)).queueAfter(5L, TimeUnit.MINUTES);


                        }

                    }
                }
            }
        }
    }
}*/

