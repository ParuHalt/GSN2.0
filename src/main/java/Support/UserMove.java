package Support;


import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class UserMove extends ListenerAdapter {



    @Override
    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event) {

        VoiceChannel vc1 = event.getGuild().getVoiceChannelById("984900635046600785");
        VoiceChannel vc2 = event.getGuild().getVoiceChannelById("985477377104691210");
        VoiceChannel vc3 = event.getGuild().getVoiceChannelById("985477342635896874");
        VoiceChannel vc4 = event.getGuild().getVoiceChannelById("986942316763836416");
        switch (event.getValues().get(0)) {

            case "im":


                if (event.getMember().getRoles().contains(event.getGuild().getRoleById("984900635046600785"))) {
                    if (!vc1.getMembers().isEmpty()) {
                        event.getGuild().moveVoiceMember(event.getMember(), vc1).queue();
                    }
                }else if (!vc1.getMembers().isEmpty()) {

                    event.getGuild().moveVoiceMember(event.getMember(), vc1).queue();

                } else if (!vc1.getMembers().isEmpty()) {

                    event.getGuild().moveVoiceMember(event.getMember(), vc3).queue();

                } else if (!vc1.getMembers().isEmpty()) {

                    event.getGuild().moveVoiceMember(event.getMember(), vc4).queue();
                }


                event.reply("Erfolgreich(Wird noch verbessert)").setEphemeral(true).queue();

                break;

            case "us":

                try {


                    Member m = VoicePing.User.get(0);

                    if (vc1.getMembers().isEmpty()) {

                        System.out.println(vc1.getMembers().size());
                        System.out.println("test");
                        event.getGuild().moveVoiceMember(m, vc1).queue();
                        VoicePing.User.remove(0);

                    } else if (vc2.getMembers().isEmpty()) {

                        System.out.println("lal");
                        event.getGuild().moveVoiceMember(m, vc2).queue();
                        VoicePing.User.remove(0);
                        ;

                    } else if (vc3.getMembers().isEmpty()) {

                        System.out.println("suu");
                        event.getGuild().moveVoiceMember(m, vc3).queue();
                        VoicePing.User.remove(0);
                        ;

                    } else if (vc4.getMembers().isEmpty()) {

                        System.out.println("yeill");
                        event.getGuild().moveVoiceMember(m, vc4).queue();
                        VoicePing.User.remove(0);
                        ;

                    } else {
                        event.reply("keine Channel sind verfügbar").setEphemeral(true).queue();
                    }

                    event.reply("Erfolgreich(Wird noch verbessert)").setEphemeral(true).queue();


                }catch (IndexOutOfBoundsException e){

                }

                break;

            case "uim":

                try {

                    Member member = VoicePing.User.get(0);

                    if (event.getMember().getRoles().contains(event.getGuild().getRoleById("984900635046600785"))) {
                        if (vc1.getMembers().isEmpty()) {

                            event.getGuild().moveVoiceMember(member, vc1).queue();
                            VoicePing.User.remove(0);
                            event.getGuild().moveVoiceMember(event.getMember(), vc1).queue();

                        }

                    } else if (vc1.getMembers().isEmpty()) {

                        event.getGuild().moveVoiceMember(member, vc1).queue();
                        VoicePing.User.remove(0);
                        event.getGuild().moveVoiceMember(event.getMember(), vc1).queue();

                    } else if (vc1.getMembers().isEmpty()) {
                        event.getGuild().moveVoiceMember(member, vc3).queue();
                        VoicePing.User.remove(0);
                        event.getGuild().moveVoiceMember(event.getMember(), vc3).queue();

                    } else if (vc1.getMembers().isEmpty()) {

                        event.getGuild().moveVoiceMember(member, vc4).queue();
                        VoicePing.User.remove(0);
                        event.getGuild().moveVoiceMember(event.getMember(), vc4).queue();
                    }

                    event.reply("Erfolgreich(Wird noch verbessert)").setEphemeral(true).queue();


                }catch (IndexOutOfBoundsException e){

                }

            default:
                break;

        }
    }
}
