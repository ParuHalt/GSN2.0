package modules;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.TimeFormat;
import net.mst.utilities.json.Json;
import net.mst.utilities.json.JsonObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Umfrage extends ListenerAdapter{
    static String question;
    static String LOGCHANNELID = "1045767828478885908";
    static int Time;
    static EmbedBuilder eb3 = new EmbedBuilder();
    static List<Message> messageid = new ArrayList<>();
    static Json settings = Json.ofPath("./Poll.json");

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("umfrage") && event.getMember().getRoles().equals("986725256762916864")) {

            question = event.getOption("question").getAsString();

            Time = event.getOption("time").getAsInt();

            EmbedBuilder image1 = new EmbedBuilder();
            EmbedBuilder eb1 = new EmbedBuilder();

            image1.setImage("https://cdn.discordapp.com/attachments/818211419974664214/1045770974047502426/Umfrage.png");
            image1.setColor(Color.CYAN);

            eb1.setColor(Color.CYAN);
            eb1.setTitle("│\uD83D\uDCCA Neue Umfrage");
            eb1.addField("Frage", "● " + question, true);
            eb1.addField("Time", ("● " + Time) + " Minuten", true);
            eb1.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

            Message msg = event.getChannel().sendMessage("@here").setEmbeds(image1.build(), eb1.build()).setActionRow(
                    Button.success("check", "Ja 0").withEmoji(Emoji.fromFormatted("<:Check:1045770920565932143>")),
                    Button.secondary("slash", "Vielleicht 0").withEmoji(Emoji.fromFormatted("<:Slash:1045770874793508934>")),
                    Button.danger("wrong", "Nein 0").withEmoji(Emoji.fromFormatted("<:Wrong:1045770851087290378>"))
            ).complete();

            messageid.add(msg);

            event.reply("Du hast erfolgreich eine Umfrage erstellt!").setEphemeral(true).queue();

            startTimer(event.getChannel().asTextChannel(), event.getGuild().getTextChannelById(LOGCHANNELID), event.getGuild());
        }
    }


    static int check;
    static int slash;
    static int wrong;

    public void onButtonInteraction(ButtonInteractionEvent event) {

        if (event.getButton().getId().equals("check")) {

            if (json(event.getMember()) == true){

                String Buttonplus = event.getButton().getLabel().substring(3);

                int bp = Integer.valueOf(Buttonplus);
                check = bp + 1;

                event.editButton(Button.success("check", "Ja " + check).withEmoji(Emoji.fromFormatted("<:Check:1045770920565932143>"))).queue();

            } else {
                EmbedBuilder image = new EmbedBuilder();
                EmbedBuilder eb = new EmbedBuilder();

                image.setImage("https://cdn.discordapp.com/attachments/987815549880926218/1033043169216045149/Fehlermeldung.png");
                image.setColor(0xff3232);

                eb.setTitle("Fehlermeldung");
                eb.setDescription("Du hast schon abgestimmt!");
                eb.setColor(0xff3232);
                eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

                event.replyEmbeds(image.build(), eb.build()).setEphemeral(true).queue();
            }
        }
        if (event.getButton().getId().equals("wrong")) {
            if (json(event.getMember()) == true){

                String Buttonplus = event.getButton().getLabel().substring(5);

                int bp = Integer.valueOf(Buttonplus);
                wrong = bp + 1;


                event.editButton(Button.danger("wrong", "Nein " + wrong).withEmoji(Emoji.fromFormatted("<:Wrong:1045770851087290378>"))).queue();

            } else {
                EmbedBuilder image = new EmbedBuilder();
                EmbedBuilder eb = new EmbedBuilder();

                image.setImage("https://cdn.discordapp.com/attachments/987815549880926218/1033043169216045149/Fehlermeldung.png");
                image.setColor(0xff3232);

                eb.setTitle("Fehlermeldung");
                eb.setDescription("Du hast schon abgestimmt!");
                eb.setColor(0xff3232);
                eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

                event.replyEmbeds(image.build(), eb.build()).setEphemeral(true).queue();
            }

        }
        if (event.getButton().getId().equals("slash")){
            if (json(event.getMember()) == true){

                String Buttonplus = event.getButton().getLabel().substring(11);

                int bp = Integer.valueOf(Buttonplus);
                slash = bp + 1;

                event.editButton(Button.secondary("slash", "Vielleicht " + slash).withEmoji(Emoji.fromFormatted("<:Slash:1045770874793508934>"))).queue();

            } else {
                EmbedBuilder image = new EmbedBuilder();
                EmbedBuilder eb = new EmbedBuilder();

                image.setImage("https://cdn.discordapp.com/attachments/987815549880926218/1033043169216045149/Fehlermeldung.png");
                image.setColor(0xff3232);

                eb.setTitle("Fehlermeldung");
                eb.setDescription("Du hast schon abgestimmt!");
                eb.setColor(0xff3232);
                eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

                event.replyEmbeds(image.build(), eb.build()).setEphemeral(true).queue();
            }

        }

    }

    public boolean json(Member member) throws NullPointerException {
        if (settings.getRoot().containsKey(member.getId())) {

            return false;

        } else {

            settings.setValue(member.getId(), new JsonObject().setValue("Username", member.getEffectiveName()));
            settings.save();

            return true;
        }
    }

    public void startTimer(TextChannel textChannel, TextChannel textChannel1, Guild guild) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                try {
                    EmbedBuilder image = new EmbedBuilder();
                    EmbedBuilder eb = new EmbedBuilder();

                    image.setImage("https://cdn.discordapp.com/attachments/818211419974664214/1045770974047502426/Umfrage.png");
                    image.setColor(Color.CYAN);

                    eb.setColor(Color.CYAN);
                    eb.setTitle("|\uD83D\uDCCA Neue Umfrage");
                    eb.addField("Frage", "● " + question, true);
                    eb.addField("Dauer:",  "<:Wrong:1045770851087290378>`BEENDET`", true);
                    eb.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

                    String mid = messageid.get(0).getId();

                    textChannel.editMessageEmbedsById(mid, image.build(), eb.build()).setActionRow(
                            Button.success("check", "Ja " + check).withEmoji(Emoji.fromFormatted("<:Check:1045770920565932143>")).asDisabled(),
                            Button.secondary("slash", "Vielleicht " + slash).withEmoji(Emoji.fromFormatted("<:Slash:1045770874793508934>")).asDisabled(),
                            Button.danger("wrong", "Nein " + wrong).withEmoji(Emoji.fromFormatted("<:Wrong:1045770851087290378>")).asDisabled()
                    ).queue();
                    messageid.remove(0);

                    eb3.setDescription("Teilnehmer:\n");

                    for (String a : settings.getRoot().getKeys().stream().toList()) {

                        eb3.appendDescription(("●" + guild.getMemberById(a).getAsMention() + " " + "(" + guild.getMemberById(a).getId()) + ")\n");

                        settings.getRoot().getKeys().remove(a);
                        settings.save();
                    }
                    eb3.setTitle("Umfrage-Log");
                    eb3.setColor(Color.GREEN);
                    eb3.addField("Informationen", "Frage: " + "**" + question + "**" + "\n" +
                            "Zeit: " + "**" + Time + "**" + " Minuten\n" +
                            "Ende: " + (TimeFormat.RELATIVE.now()), false);

                    textChannel1.sendMessageEmbeds(eb3.build()).queue();

                }catch (IllegalArgumentException e) {
                    System.err.println("OK");
                }
            }
            //1000 = 1min
            //10 000 = 10mim
            //100 000 = 1h
        }, Time*60*1000);
    }
}
