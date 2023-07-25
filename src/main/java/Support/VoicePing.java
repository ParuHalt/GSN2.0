package Support;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VoicePing extends ListenerAdapter {

    static List<EmbedBuilder> builders = new ArrayList<>();

    static List<Member> User = new ArrayList<>();

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        if (event.getChannelJoined().getIdLong() == 984901476067475546L) {

            System.out.println(event.getMember().getEffectiveName());
            User.add(event.getMember());

            Button accept = Button.primary("accept", "Support Annehmen").withEmoji(Emoji.fromFormatted("<a:CG:990356659656331284>"));


            EmbedBuilder image = new EmbedBuilder();
            EmbedBuilder eb = new EmbedBuilder();

            image.setImage("https://cdn.discordapp.com/attachments/985493341212909570/1033088329073307669/Support_Anfrage.png");
            image.setColor(0x96e6ff);

            eb.setTitle("User ist im Support");
            eb.setImage("https://cdn.discordapp.com/attachments/987815549880926218/1033036314364354841/Footer_Banner.png");
            eb.setColor(0x96e6ff);

            event.getGuild().getTextChannelById("985493341212909570").sendMessageEmbeds(image.build(), eb.build()).setActionRow(accept).queue();




            /* /*if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level2.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level3.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level4.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level5.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level6.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level7.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level8.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level9.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level10.add(s);
                            }

                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level11.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level12.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level13.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level14.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                Level15.add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            }
                            if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);
                            } if (s.getRoles().contains(event.getGuild().getRoleById(""))) {
                                .add(s);*/



            /*eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("📕〢<@&1028106057668644904> " + "**" + HeadAdmin.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : HeadAdmin.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            HeadAdmin.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("🔥〢<@&1026565436768276611> " + "**" + Admin.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : Admin.stream().toList()){
                            Admin.remove(s);
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("📛〢<@&1026565802108911636> " + "**" + Moderator.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : Moderator.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            Moderator.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("📛〢<@&1026565914772115506> " + "**" + TModerator.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : TModerator.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            TModerator.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("💼〢<@&1029483340300042371> " + "**" + TeamManager.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : TeamManager.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            TeamManager.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("🚑〢<@&1026565694478876713> " + "**" +  Supporter.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : Supporter.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            Supporter.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("🚓〢<@&1026565550383575070> " + "**" + TSupporter.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : TSupporter.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            TSupporter.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("💻〢<@&1028664820679069716> " + "**" + CodingSupporter.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : CodingSupporter.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            CodingSupporter.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("📟〢<@&1018919273487401090> " + "**" + Entwickler.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : Entwickler.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            Entwickler.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("🎓〢<@&1026881544264105984> " + "**" + Azubi.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : Azubi.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            Azubi.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("🔨〢<@&1023166830740766732> " + "**" + Servertechniker.size() + "**" );
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : Servertechniker.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            Servertechniker.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("🎉〢<@&1028386010129772695> " + "**" + EventManager.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : EventManager.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            EventManager.remove(s);
                        }

                        eb.getDescriptionBuilder().append("\n");
                        eb.appendDescription("🎨〢<@&1023166281442131988> " + "**" + Designer.size() + "**");
                        eb.getDescriptionBuilder().append("\n");
                        for (Member s : Designer.stream().toList()){
                            eb.appendDescription("●" + s.getAsMention() + "\n");
                            Designer.remove(s);
                        }
                        eb.getDescriptionBuilder().append("\n");*/

            //  event.replyEmbeds(image1.build(), eb1.build()).setEphemeral(true).queue();

        }

    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("accept")) {

            EmbedBuilder image = new EmbedBuilder();
            EmbedBuilder eb = new EmbedBuilder();
            image.setImage("https://cdn.discordapp.com/attachments/985493341212909570/1033088329073307669/Support_Anfrage.png");
            image.setColor(0x96e6ff);

            eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");
            eb.setColor(0x96e6ff);


            event.editMessageEmbeds(image.build(), eb.build()).setActionRows(buttons() ,ActionRow.of(selectMenu())).queue();

        } else if (event.getButton().getId().equals("pingadmin")) {

            if (builders.isEmpty()){
                System.out.println("nichts drinne");
            }else {

                builders.get(0);

                MessageEmbed e = builders.get(0).build();

                event.getMessage().delete().queue();
                EmbedBuilder image = new EmbedBuilder();

                image.setImage("https://cdn.discordapp.com/attachments/985493341212909570/1033088329073307669/Support_Anfrage.png");
                image.setColor(0x96e6ff);

                event.getChannel().sendMessage("<@&984886655926280292>").setEmbeds(image.build(),e ).setActionRows(buttons(), ActionRow.of(selectMenu())).queue();

            }
        }

        else if (event.getButton().getId().equals("pingmod")) {


            if (builders.isEmpty()){
                System.out.println("nichts drinne");
            }else {

                builders.get(0);

                MessageEmbed e = builders.get(0).build();

                event.getMessage().delete().queue();
                EmbedBuilder image = new EmbedBuilder();

                image.setImage("https://cdn.discordapp.com/attachments/985493341212909570/1033088329073307669/Support_Anfrage.png");
                image.setColor(0x96e6ff);

                event.getChannel().sendMessage("<@&984886823232893019>").setEmbeds(image.build(),e ).setActionRows(buttons(), ActionRow.of(selectMenu())).queue();

            }

        }
        else if (event.getButton().getId().equals("edit")) {

            event.getMessage().delete().queue();

            TextInput title = TextInput.create("title", "Titel", TextInputStyle.SHORT)
                    .setMinLength(5)
                    .setMaxLength(25)
                    .setPlaceholder("Gib hier den Titel ein!")
                    .setRequired(true)
                    .build();

            TextInput description = TextInput.create("description", "Beschreibung", TextInputStyle.PARAGRAPH)
                    .setMinLength(5)
                    .setMaxLength(500)
                    .setPlaceholder("Gib hier deine Beschreibung ein")
                    .setRequired(true)
                    .build();

            Modal modal = Modal.create("edit", "Edit")
                    .addActionRows(ActionRow.of(title), ActionRow.of(description)).build();

            event.replyModal(modal).queue();


        }
        else if (event.getButton().getId().equals("close")) {

            if (builders.isEmpty()){
                System.out.println("nichts drinne");
            }else {

                builders.get(0);

                MessageEmbed e = builders.get(0).build();

                event.getMessage().delete().queue();
                EmbedBuilder image = new EmbedBuilder();

                image.setImage("https://cdn.discordapp.com/attachments/985493341212909570/1033088329073307669/Support_Anfrage.png");
                image.setColor(0x96e6ff);


                ActionRow s = ActionRow.of(
                        Button.secondary("edit", "Edit").asDisabled(),
                        Button.success("pingadmin", "Ping Admin").asDisabled(),
                        Button.success("pingmod", "Ping Mod").asDisabled(),
                        Button.danger("close", "Schließen").asDisabled()
                );

                event.getChannel().sendMessageEmbeds(image.build(),e ).setActionRows((s), ActionRow.of(selectMenu().asDisabled())).queue();

                builders.remove(0);
            }

        }
    }

    public static ActionRow buttons(){
        return  ActionRow.of(
                Button.secondary("edit", "Edit"),
                Button.success("pingadmin", "Ping Admin"),
                Button.success("pingmod", "Ping Mod"),
                Button.danger("close", "Schließen")
        );
    }

    public static SelectMenu selectMenu(){
        return SelectMenu.create("control")
                .addOption("User Move","us", "Drücke hier, um diese Option auszuwählen!", Emoji.fromFormatted("<:User_2:1033094377553276990>"))
                .addOption("User Ich Move", "uim", "Drücke hier, um diese Option auszuwählen!", Emoji.fromFormatted("<:User_3:1033094390660468777>"))
                .build();
    }
}
