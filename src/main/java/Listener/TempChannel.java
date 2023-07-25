package Listener;

/*public class TempChannel extends ListenerAdapter {
    List<AudioChannel> tempChannels = new ArrayList<>();
    List<TextChannel> textChannels = new ArrayList<>();
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {

        if (event.getMember().getUser().isBot()) return;

        Guild guild = event.getGuild();
        if (event.getChannelJoined().getIdLong() == 988793238716571668L) {


            VoiceChannel voiceChannel = guild.createVoiceChannel("│⌛ " + event.getMember().getEffectiveName(), guild.getCategoryById("988793237097553962"))
                    .syncPermissionOverrides()
                    .addPermissionOverride(event.getMember(), EnumSet.of(Permission.VIEW_CHANNEL), null)
                    //.addPermissionOverride(guild.getPublicRole(), null), EnumSet.of(Permission.VIEW_CHANNEL)
                    .syncPermissionOverrides()
                    .setUserlimit(10)
                    .complete();

            tempChannels.add(voiceChannel);

            guild.moveVoiceMember(event.getMember(), voiceChannel).queue();


        }
    }
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {

        if (tempChannels.contains(event.getChannelLeft()) && event.getChannelLeft().getMembers().size() == 0) {
            AudioChannel audioChannel = event.getChannelLeft();
            if (audioChannel.getMembers().isEmpty()) {
                tempChannels.remove(event.getChannelLeft());
                audioChannel.delete().queue();

            }
        }
    }
}*/
