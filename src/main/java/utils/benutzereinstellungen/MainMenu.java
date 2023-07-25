package utils.benutzereinstellungen;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainMenu extends ListenerAdapter {

    private static HashMap<Integer, RoleMessage> pages = new HashMap<Integer, RoleMessage>();
    private static HashMap<String, String> categories;
    private static String[] memes;

    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getChannelType().equals(ChannelType.PRIVATE)) return;

        if (event.getMessage().getContentStripped().startsWith("!mainmenu")) {
            if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                EmbedBuilder bannermain = new EmbedBuilder();
                EmbedBuilder ebmain = new EmbedBuilder();

                bannermain.setImage("https://cdn.discordapp.com/attachments/987815549880926218/1033036281908834425/Rollen_Settings.png");
                bannermain.setColor(0x4b3488);

                ebmain.setTitle("Hier kannst du anderen Usern was über dich erzählen.");
                ebmain.addField("Falls du dich mal verklickt haben solltest, kannst du über die Buttons deine Einstellungen zurücksetzen.", "_ _", false);
                ebmain.setColor(0x4b3488);
                ebmain.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");

                Emoji emoji = Emoji.fromFormatted("<:Delete:992826553568346182>");

                ActionRow menu = ActionRow.of(Button.primary("gsn.selectroles", "Rollen auswählen"), Button.danger("resetall", "Alle zurücksetzen").withEmoji(emoji), Button.secondary("gsn.showroles", "Rollen anzeigen"));

                //ActionRow ar1 = ActionRow.of(Button.danger("resetall", "Alle Kategorien").withEmoji(emoji), Button.secondary("resetage", "Alter").withEmoji(emoji), Button.secondary("resetgender", "Geschlecht").withEmoji(emoji), Button.secondary("resetregion", "Region").withEmoji(emoji));
                //ActionRow ar2 = ActionRow.of(Button.secondary("resetdm", "DM's").withEmoji(emoji), Button.secondary("resetplatforms", "Plattformen").withEmoji(emoji), Button.secondary("resetskill", "Skills").withEmoji(emoji), Button.secondary("resetgame", "Games").withEmoji(emoji));

                event.getChannel().sendMessageEmbeds(bannermain.build(), ebmain.build()).setActionRows(menu).queue();
            }
        }

        /*if (event.getMessage().getContentStripped().startsWith("!gamemenu")) {
            if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                EmbedBuilder ebgame = new EmbedBuilder();

                ebgame.setTitle("Hier kannst du deine Spiele auswählen.");
                ebgame.setDescription("**Hier gibt es folgende Rollen:**\n" + "> <:Grafik:992867971066249326>️ │ <@&990571834401521674> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                        "> <:Coden:992865244248547448> │ <@&990572584770867200> \n");
                ebgame.setColor(0x4b3488);
                ebgame.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
                ebgame.setThumbnail("https://cdn.discordapp.com/attachments/990240111042113536/992877333356744795/Game.png");
                event.getChannel().sendMessageEmbeds(ebgame.build()).setActionRow(sendGameRoles1()).queue();
            }
        }*/

    }

    public void onButtonInteraction(ButtonInteractionEvent e) {

        if(e.getChannelType() != ChannelType.PRIVATE) {

            if(e.getComponentId().equals("gsn.selectroles")) {
                InteractionHook ih = e.deferReply(true).complete();

                ih.editOriginal(receiveMessage(0, e.getMember())).queueAfter(500, TimeUnit.MILLISECONDS);

            }
            if(e.getComponentId().startsWith("gsn_mainmenu")) {
                String[] args = e.getComponentId().split("_");

                if(args[2].equals("back")) {
                    e.editMessage(receiveMessage(Integer.valueOf(args[3]) - 1, e.getMember())).queue();
                }
                if(args[2].equals("continue")) {
                    if(Integer.valueOf(args[3]) >= (pages.size() - 1)) {
                        EmbedBuilder eb = new EmbedBuilder();
                        eb.setFooter("Viel");
                        eb.setColor(0x4b3488);
                        eb.setImage("https://c.tenor.com/x8v1oNUOmg4AAAAd/rickroll-roll.gif");

                        String[] lyrics = new String("We're no strangers to love_You know the rules and so do I (do I)_A full commitment's what I'm thinking of_You wouldn't get this from any other guy_I just wanna tell you how I'm feeling_Gotta make you understand_Never gonna give you up_Never gonna let you down_Never gonna run around and desert you_Never gonna make you cry_Never gonna say goodbye_Never gonna tell a lie and hurt you_We've known each other for so long_Your heart's been aching, but you're too shy to say it (say it)_Inside, we both know what's been going on (going on)_We know the game and we're gonna play it_And if you ask me how I'm feeling_Don't tell me you're too blind to see").split("_");

                        SelectMenu.Builder sbuilder = SelectMenu.create("gsnfakemenu").setPlaceholder("Du kannst mehrere geheime Rollen auswählen!");

                        for(int i = 0; i < lyrics.length; i++) {

                            sbuilder.addOption(lyrics[i], "gsnfakeoption" + i);

                        }

                        sbuilder.setMaxValues(1);

                        e.editMessageEmbeds(eb.build()).setActionRows(ActionRow.of(Button.primary("gsn.fake1", "Spaß").asDisabled(), Button.success("gsn.fake2", "auf").asDisabled(), Button.primary("gsn.fake3", "dem").asDisabled(), Button.danger("gsn.fake4", "Server!").asDisabled()), ActionRow.of(sbuilder.build())).queue();
                    }else {
                        e.editMessage(receiveMessage(Integer.valueOf(args[3]) + 1, e.getMember())).queue();
                    }
                }
            }

            if(e.getComponentId().equals("gsn.showroles")) {

                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("Meine aktuellen Rollen:");
                eb.setColor(0x4b3488);
                eb.setThumbnail("https://cdn.discordapp.com/attachments/987815549880926218/1033054359602352278/menu.png");

                List<Role> roles = e.getMember().getRoles();

                for(String s : categories.keySet()) {

                    int i = 0;
                    String roleString = "";

                    for(Role r : SelectionRoles.getRolesByMenuId(s)) {

                        if(roles.contains(r)) {

                            roleString =  roleString + ", " + r.getAsMention();
                            i++;

                        }

                    }

                    if(roleString != "") {

                        if(roleString.length() >= 1024) {

                            eb.addField(categories.get(s), "Du hast " + i + " Rollen!", false);

                        }else {

                            eb.addField(categories.get(s) + " (" + i + ")", roleString.substring(1), false);

                        }

                    }

                }

                if(eb.getFields().isEmpty()) {

                    eb.setDescription("Du hast aktuell keine Rollen ausgewählt! Nutze den Button \"Rollen Auswählen\", damit hier etwas erscheint.");

                }

                InteractionHook ih = e.deferReply(true).complete();

                ih.editOriginalEmbeds(eb.build()).queueAfter(500, TimeUnit.MILLISECONDS);

            }

        }

    }

    public void onSelectMenuInteraction(SelectMenuInteractionEvent e) {

        if(e.getComponentId().equals("gsnfakemenu")) {

            if(e.getComponent().getOptions().get(0).getValue().startsWith("gsnfakeoption")) {

                int i = (int)(Math.random() * 4);
                Button button = Button.primary("gsnfakebutton", "Hier wurde er vergraben!").withUrl(memes[(int)(Math.random() * 14)]);;

                switch(i) {
                    case 1: button = Button.primary("gsnfakebutton", "Hier wurde er vergraben!").withUrl(memes[(int)(Math.random() * 14)]); break;
                    case 2: button = Button.secondary("gsnfakebutton", "Hier wurde er vergraben!").withUrl(memes[(int)(Math.random() * 14)]); break;
                    case 3: button = Button.danger("gsnfakebutton", "Hier wurde er vergraben!").withUrl(memes[(int)(Math.random() * 14)]); break;
                    case 4: button = Button.success("gsnfakebutton", "Hier wurde er vergraben!").withUrl(memes[(int)(Math.random() * 14)]); break;
                }

                e.reply("Falls du dich fragst, wo dein Skill ist:").setEphemeral(true).addActionRow(button).queue();

            }

        }

    }

    public Message receiveMessage(int page, Member member) {

        if(!pages.containsKey(page)) {
            return null;
        }

        RoleMessage rm = pages.get(page);

        Button backButton;
        Button pageButton;
        Button nextButton;
        Button deleteButton;

        if(page < 1) {
            backButton = Button.primary("gsn_mainmenu_back_" + page, "Zurück").asDisabled();
        }else {
            backButton = Button.primary("gsn_mainmenu_back_" + page, "Zurück");
        }

        if(page >= 6 && page <= 9) {
            pageButton = Button.success("gsn_mainmenu_pages", "Games " + (page + -5) + "/" + 4).asDisabled();
        }else {
            pageButton = Button.secondary("gsn_mainmenu_pages", "Seite " + (page + 1) + "/" + pages.size()).asDisabled();
        }

        nextButton = Button.primary("gsn_mainmenu_continue_" + page, "Weiter");

        Emoji emoji = Emoji.fromFormatted("<:Delete:992826553568346182>");

        deleteButton = Button.danger(rm.resetString, "Zurücksetzen").withEmoji(emoji);

        MessageBuilder messageBuilder = new MessageBuilder(pages.get(page).embed.build());

        messageBuilder.setActionRows(ActionRow.of(backButton, pageButton, nextButton, deleteButton), ActionRow.of(pages.get(page).selectMenu.setDefaultValues(SelectionRoles.getActiveValues(member, pages.get(page).selectMenu.getId())).build()));

        return messageBuilder.build();

    }

    public static void initializeMessages() {

        categories = new HashMap<String, String>() {{

            put("age", "Alter");
            put("gender", "Geschlecht");
            put("region", "Region");
            put("dm", "DM-Status");
            put("skill", "Skill");
            put("platforms", "Plattformen");
            put("games", "Games");

        }};

        memes = new String[]{"https://www.youtube.com/watch?v=ZZ5LpwO-An4",
                "https://www.youtube.com/watch?v=astISOttCQ0",
                "https://www.youtube.com/watch?v=w0AOGeqOnFY",
                "https://www.youtube.com/watch?v=d1YBv2mWll0",
                "https://www.youtube.com/watch?v=jIQ6UV2onyI",
                "https://www.youtube.com/watch?v=i1ojUmdF42U",
                "https://www.youtube.com/watch?v=c2s4TvZ7AXY",
                "https://www.youtube.com/watch?v=RKW6rjnYEkc",
                "https://www.youtube.com/watch?v=XlgqZeeoOtI",
                "https://www.youtube.com/watch?v=SdmfidIYS84",
                "https://www.youtube.com/watch?v=m_nvfeGYbi8&t",
                "https://www.youtube.com/watch?v=8UjWwMtrETk",
                "https://www.youtube.com/watch?v=xTPA5126LyI",
                "https://www.youtube.com/watch?v=LodjsJZZvUs"};

        Emoji emoji = Emoji.fromFormatted("<:Delete:992826553568346182>");
        // Age Gender Region DM Platforms Skills Games1 Games2 Games3 Games4
        EmbedBuilder ebage = new EmbedBuilder();

        ebage.setTitle("Hier kannst du dein Alter auswählen.");
        ebage.setDescription("**Hier gibt es folgende Rollen:**\n" + "> \uD83D\uDD34 │ <@&984895847940632576> \n" +
                "> \uD83D\uDFE0 │ <@&984895977167142952> \n" +
                "> \uD83D\uDFE1 │ <@&984896191311527996> \n" +
                "> \uD83D\uDFE2 │ <@&984896279949754390> \n" +
                "> \uD83D\uDD35 │ <@&984896542886490133> \n");
        ebage.setColor(0x4b3488);
        ebage.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebage.setThumbnail("https://cdn.discordapp.com/attachments/987815549880926218/1033054338182025216/cancel-2.png");

        EmbedBuilder ebgender = new EmbedBuilder();

        ebgender.setTitle("Hier kannst du dein Geschlecht auswählen.");
        ebgender.setDescription("**Hier gibt es folgende Rollen:**\n" + "> ♂️ │ <@&984897171629432902> \n" +
                "> ♀️ │ <@&984897284137418762> \n" +
                "> ⚧ │ <@&992104505942483016> \n");
        ebgender.setColor(0x4b3488);
        ebgender.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebgender.setThumbnail("https://cdn.discordapp.com/attachments/987815549880926218/1033054822225690694/user-male--v1.png");

        EmbedBuilder ebregion = new EmbedBuilder();

        ebregion.setTitle("Hier kannst du deine Region auswählen.");
        ebregion.setDescription("**Hier gibt es folgende Rollen:**\n" + "> <:switzerland:992484713061158943>️ │ <@&992467791749845093> \n" +
                "> <:Giconaustria:992484711727374396>️ │ <@&992467889401626674> \n" +
                "> <:50pxDeutschland_Lage_von_BadenWr:992482063666130974> │ <@&992464394745286666> \n" +
                "> <:Deutschland_Lage_von_Bayern:992482080711770283> │ <@&992464555030609930> \n" +
                "> <:50pxDeutschland_Lage_Berlins:992482060738494504> │ <@&992464643056484445> \n" +
                "> <:50pxDeutschland_Lage_von_Branden:992482065104785569> │ <@&992465558098415676> \n" +
                "> <:50pxDeutschland_Lage_von_Bremen:992482066421792778> │ <@&992466369708826644> \n" +
                "> <:50pxDeutschland_Lage_von_Hamburg:992482067843645531> │ <@&992466596884905997> \n" +
                "> <:50pxDeutschland_Lage_von_Hessen:992482069261340752> │ <@&992466654434967552> \n" +
                "> <:50pxDeutschland_Lage_von_Mecklen:992482070528020540> │ <@&992466715407564931> \n" +
                "> <:50pxDeutschland_Lage_von_Nieders:992482071635296397> │ <@&992466837755408434> \n" +
                "> <:50pxDeutschland_Lage_von_Nordrhe:992482073048793188> │ <@&992466949059645540> \n" +
                "> <:50pxDeutschland_Lage_von_Rheinla:992482074323865770> │ <@&992467050326917151> \n" +
                "> <:50pxDeutschland_Lage_des_Saarlan:992482062080692284> │ <@&992467108841672804> \n" +
                "> <:50pxDeutschland_Lage_von_Sachsen:992482075556986910> │ <@&992467190219554816> \n" +
                "> <:50pxDeutschland_Lage_von_Sachsen:992482076853031022> │ <@&992467256141414481> \n" +
                "> <:50pxDeutschland_Lage_von_Schlesw:992482078174224534> │ <@&992467320284917871> \n" +
                "> <:50pxDeutschland_Lage_von_Thringe:992482079466065990> │ <@&992467696102944919> \n");
        ebregion.setColor(0x4b3488);
        ebregion.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebregion.setThumbnail("https://cdn.discordapp.com/attachments/987815549880926218/1033054481090367659/country_1.png");

        EmbedBuilder ebdm = new EmbedBuilder();

        ebdm.setTitle("Hier kannst du deine Direct Message Einstellung auswählen.");
        ebdm.setDescription("**Hier gibt es folgende Rollen:**\n" + "> <:DMOpen:992840873614262372>️ │ <@&990573075378630676> \n" +
                "> <:AsktoDM:992840870921506866>️ │ <@&990573315192160316> \n" +
                "> <:DMClosed:992840871848464425> │ <@&990573585041076244> \n");
        ebdm.setColor(0x4b3488);
        ebdm.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebdm.setThumbnail("https://cdn.discordapp.com/attachments/987815549880926218/1033054353772253234/mailbox-closed-flag-down.png");

        EmbedBuilder ebplatforms = new EmbedBuilder();

        ebplatforms.setTitle("Hier kannst du deine Plattformen auswählen.");
        ebplatforms.setDescription("**Hier gibt es folgende Rollen:**\n" + "> <:Windows:992757071013478400>️ │ <@&990570270727217222> \n" +
                "> <:Apple:992757064038371338>️ │ <@&990570993808470046> \n" +
                "> <:Android:992757062696177744> │ <@&990571190349365288> \n" +
                "> <:Switch:992757067200856156> │ <@&990571403742945330> \n" +
                "> <:Xbox:992757072657666118> │ <@&990571445887320144> \n" +
                "> <:Playstation:992757065338585108> │ <@&990571451331510282> \n");
        ebplatforms.setColor(0x4b3488);
        ebplatforms.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebplatforms.setThumbnail("https://media.discordapp.net/attachments/987815549880926218/1033054505916452924/Server.png?width=309&height=309");

        EmbedBuilder ebskills = new EmbedBuilder();

        ebskills.setTitle("Hier kannst du deine Skills auswählen.");
        ebskills.setDescription("**Hier gibt es folgende Rollen:**\n" + "> <:Grafik:992867971066249326>️ │ <@&990571834401521674> \n" +
                "> <:Video:992865247197138944>️ │ <@&990572115675709451> \n" +
                "> <:Coden:992865244248547448> │ <@&990572584770867200> \n");
        ebskills.setColor(0x4b3488);
        ebskills.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebskills.setThumbnail("https://cdn.discordapp.com/attachments/987815549880926218/1033054346541269152/dribbble.png");

        EmbedBuilder ebgame1 = new EmbedBuilder();

        ebgame1.setTitle("Games von A-D");
        ebgame1.setDescription("**Hier gibt es folgende Games:**\n" + "> <:age_of_empires_4_sm:992875373584982136>️ │ <@&990594150346928139> \n" +
                "> <:among_us_sm:992875376177074206>️ │ <@&990584399860998204> \n" +
                "> <:apex_legends_sm:992875377414381580> │ <@&990584386787352576> \n" +
                "> <:ark_sm:992875379079528540> │ <@&990584401354186792> \n" +
                "> <:astroneer_sm:992875380144869528> │ <@&990591249411096618> \n" +
                "> <:back_4_blood_sm:992875385027043328> │ <@&990593604617658428> \n" +
                "> <:battlefield_2042_sm:992875386755092552> │ <@&990591254985322516> \n" +
                "> <:battlefield_v_sm:992875388399263855> │ <@&990586061803646976> \n" +
                "> <:borderlands_3_sm:992875391234605086> │ <@&990588174734602270> \n" +
                "> <:call_of_duty_cold_war_sm:992875394577481769> │ <@&990586057227661362> \n" +
                "> <:MW2:1045744203000451232> │ <@&1045743285983002705> \n" +
                "> <:call_of_duty_vanguard_sm:992875396150341802> │ <@&990593601979433000> \n" +
                "> <:call_of_duty_warzone_sm:992875397588975698> │ <@&990584394748153916> \n" +
                "> <:counter_strike_go_sm:992875399635804161> │ <@&990583324848295977> \n" +
                "> <:cyberpunk_2077_sm:992875405956620338> │ <@&990586066182475796> \n" +
                "> <:dayz_sm:992875408796168222> │ <@&990593603761999912> \n" +
                "> <:destiny_2_sm:992875410020913172> │ <@&990584399152160798> \n" +
                "> <:diablo_iii_sm:992875411019153440> │ <@&990586065347833866> \n" +
                "> <:D4:1130793450971861102> │ <@&1130805463697608784> \n" +
                "> <:doom_eternal_sm:992875415519633458> │ <@&990591242847002644> \n" +
                "> <:dota_2_sm:992875416836636703> │ <@&990584398321680414> \n" +
                "> <:dota_underlords_sm:992875418124288020> │ <@&990591255723540500> \n");
        ebgame1.setColor(0x4b3488);
        ebgame1.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebgame1.setThumbnail("https://media.discordapp.net/attachments/987815549880926218/1033054505580892191/Game.png?width=309&height=309");

        EmbedBuilder ebgame2 = new EmbedBuilder();

        ebgame2.setTitle("Games von E-L");
        ebgame2.setDescription("**Hier gibt es folgende Games:**\n" + "> <:elden_ring_sm:992875419445514240>️ │ <@&990593602491133992> \n" +
                "> <:elder_scrolls_online_sm:992875421030948925>️ │ <@&990588412505513994> \n" +
                "> <:factorio_sm:992875422041784321>️ │ <@&990591245124505681> \n" +
                "> <:Fs22:1045744406097055774> │ <@&1045742917672767548> \n" +
                "> <:fall_guys_sm:992875425359474738>️ │ <@&990586061916889148> \n" +
                "> <:fallout_76_sm:992875426819080263>️ │ <@&990588408193761361> \n" +
                "> <:for_honor_sm:992875431835476038>️ │ <@&990588171530166304> \n" +
                "> <:fortnite_sm:992875433106341929>️ │ <@&990582892046458900> \n" +
                "> <:forza_5_sm:992875436101079070>️ │ <@&990591253240479744> \n" +
                "> <:garrys_mod_sm:992875437715894272>️ │ <@&990586069747658782> \n" +
                "> <:grand_theft_auto_5_sm:992875441130057778>️ │ <@&990584391266861128> \n" +
                "> <:grounded_sm:992875443348832356>️ │ <@&990591250304483329> \n" +
                "> <:halo_the_master_chief_collection:992875446620393503>️ │ <@&990588173992198144> \n" +
                "> <:hearthstone_sm:992875447866114179>️ │ <@&990586067080065074> \n" +
                "> <:hell_let_loose_sm:992875448763678731>️ │ <@&990594546842873877> \n" +
                "> <:heroes_of_the_storm_sm:992875450307195060>️ │ <@&990588411188494406> \n" +
                "> <:hunt_showdown_sm:992875452442091560>️ │ <@&990594153077432360> \n"+
                "> <:league_of_legends_sm:992875455373914122>️ │ <@&990581853469687828> \n"+
                "> <:lost_ark_sm:992875372154720326>️ │ <@&990588410420949022> \n");
        ebgame2.setColor(0x4b3488);
        ebgame2.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebgame2.setThumbnail("https://media.discordapp.net/attachments/987815549880926218/1033054505580892191/Game.png?width=309&height=309");

        EmbedBuilder ebgame3 = new EmbedBuilder();

        ebgame3.setTitle("Games von M-R");
        ebgame3.setDescription("**Hier gibt es folgende Games:**\n" + "> <:flight_simulator_sm:992875430631710730>️ │ <@&990591252145778700> \n"+
                "<:minecraft_sm:992875638656602142>️ │ <@&990583261933735946> \n" +
                "<:monster_hunter_world_sm:992875642116919386>️ │ <@&990586064500563978> \n" +
                "<:mordhau_sm:992875644503465985>️ │ <@&990591254955950150> \n" +
                "<:mount_and_blade_ii_bannerlord_sm:992875646671917076>️ │ <@&990591256281362463> \n" +
                "<:new_world_sm:992875648278335489>️ │ <@&990588409099747338> \n" +
                "<:no_mans_sky_sm:992875649612120184>️ │ <@&990588170154422322> \n" +
                "<:osu_sm:992875653571559624>️ │ <@&990586063284211783> \n" +
                "<:overwatch_2_sm:992875654783696916>️ │ <@&990594150971895889> \n" +
                "<:overwatch_sm:992875655861645322>️ │ <@&990584397004685342> \n" +
                "<:paladins_sm:992875657132527646>️ │ <@&990586062730575872> \n" +
                "<:path_of_exile_sm:992875658705371227>️ │ <@&990586069852491817> \n" +
                "<:payday_2_sm:992875660169195662>️ │ <@&990586071005929483> \n" +
                "<:phasmophobia_sm:992875662094385263>️ │ <@&990586057999388712> \n" +
                "<:pubg_sm:992875663637893152>️ │ <@&990584397709328464> \n" +
                "<:rainbow_6_siege_sm:992875666976546887>️ │ <@&990584393749901313> \n" +
                "<:realm_royale_sm:992875668838809681>️ │ <@&990591245963366430> \n" +
                "<:red_dead_redemption_2_sm:992875670558490684>️ │ <@&990586061090619412> \n" +
                "<:ring_of_elysium_sm:992875671829368892>️ │ <@&990591251520835654> \n" +
                "<:rocket_league_sm:992875675776208997>️ │ <@&990584395415044096> \n" +
                "<:rust_sm:992875682017312768>️ │ <@&990584400670498816> \n");
        ebgame3.setColor(0x4b3488);
        ebgame3.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebgame3.setThumbnail("https://media.discordapp.net/attachments/987815549880926218/1033054505580892191/Game.png?width=309&height=309");

        EmbedBuilder ebgame4 = new EmbedBuilder();

        ebgame4.setTitle("Games von S-W");
        ebgame4.setDescription("**Hier gibt es folgende Games:**\n" + "> <:satisfactory_sm:992875683556638873>️ │ <@&990588412522287184> \n" +
                "> <:scum_sm:992875685074972793>️ │ <@&990588413092704328> \n" +
                "> <:sea_of_thieves_sm:992875687302144030>️ │ <@&990586056317472788> \n" +
                "> <:smite_sm:992875688560443453>️ │ <@&990586072830459955> \n" +
                "> <:star_citizen_sm:992875691043459133>️ │ <@&990591243715248138> \n" +
                "> <:subnautica_below_zero_sm:992875695258742804>️ │ <@&990591245883670578> \n" +
                "> <:team_fortress_2_sm:992875697985032223>️ │ <@&990588169294585876> \n" +
                "> <:teamfight_tactics_sm:992875700224786462>️ │ <@&990586053960282174> \n" +
                "> <:the_division_2_sm:992875704322637904>️ │ <@&990586068585816124> \n" +
                "> <:v_rising_sm:992875706986020935>️ │ <@&990594544645062776> \n" +
                "> <:valheim_sm:992875709930410126>️ │ <@&990586071932887040> \n" +
                "> <:valorant_sm:992875711062868149>️ │ <@&990582367871709205> \n" +
                "> <:vermintide_2_sm:992875712828686397>️ │ <@&990591251487273011> \n" +
                "> <:war_thunder_sm:992875714363805816>️ │ <@&990591240561098794> \n" +
                "> <:warframe_sm:992875716586766366>️ │ <@&990586059366756362> \n" +
                "> <:world_of_tanks_sm:992875626056921170>️ │ <@&990591246454120450> \n" +
                "> <:world_of_warcraft_sm:992875630226063370>️ │ <@&990584401966538812> \n" +
                "> <:world_of_warships_sm:992875634281955408>️ │ <@&990591248442216478> \n");
        ebgame4.setColor(0x4b3488);
        ebgame4.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");
        ebgame4.setThumbnail("https://media.discordapp.net/attachments/987815549880926218/1033054505580892191/Game.png?width=309&height=309");

        pages.put(0, new RoleMessage(sendAgeRoles(), ebage,"resetage"));
        pages.put(1, new RoleMessage(sendGenderRoles(), ebgender,"resetgender"));
        pages.put(2, new RoleMessage(sendRegionRoles(), ebregion,"resetregion"));
        pages.put(3, new RoleMessage(sendDMRoles(), ebdm,"resetdm"));
        pages.put(4, new RoleMessage(sendPlatformRoles(), ebplatforms,"resetplatforms"));
        pages.put(5, new RoleMessage(sendSkillRoles(), ebskills,"resetskill"));

        pages.put(6, new RoleMessage(sendGameRoles1(), ebgame1,"resetgames"));
        pages.put(7, new RoleMessage(sendGameRoles2(), ebgame2,"resetgames"));
        pages.put(8, new RoleMessage(sendGameRoles3(), ebgame3,"resetgames"));
        pages.put(9, new RoleMessage(sendGameRoles4(), ebgame4,"resetgames"));

    }

    static SelectMenu.Builder sendAgeRoles() {

        return SelectMenu.create("age")
                .setPlaceholder("Du kannst maximal 1 Rolle auswählen.")
                .addOption("unter 18", "under18", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("\uD83D\uDD34"))
                .addOption("18 - 20", "18-20", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("\uD83D\uDFE0"))
                .addOption("21 - 25", "21-25", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("\uD83D\uDFE1"))
                .addOption("26 - 30", "26-30", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("\uD83D\uDFE2"))
                .addOption("über 30", "over30", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("\uD83D\uDD35"))
                .setRequiredRange(1, 1);
    }

    static SelectMenu.Builder sendGenderRoles() {

        return SelectMenu.create("gender")
                .setPlaceholder("Du kannst maximal 1 Rolle auswählen.")
                .addOption("Männlich", "male", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("♂"))
                .addOption("Weiblich", "female", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("♀"))
                .addOption("Divers", "divers", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("⚧"))
                .setRequiredRange(1, 1);
    }

    static SelectMenu.Builder sendRegionRoles() {

        return SelectMenu.create("region")
                .setPlaceholder("Du kannst maximal 1 Rolle auswählen.")
                .addOption("Schweiz", "schweiz", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:switzerland:992484713061158943>"))
                .addOption("Österreich", "osterreich", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Giconaustria:992484711727374396>"))
                .addOption("Baden Württemberg", "badenwürttemberg", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_BadenWr:992482063666130974>"))
                .addOption("Bayern", "bayern", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Deutschland_Lage_von_Bayern:992482080711770283>"))
                .addOption("Berlin", "berlin", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_Berlins:992482060738494504>"))
                .addOption("Brandenburg", "brandenburg", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Branden:992482065104785569>"))
                .addOption("Bremen", "bremen", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Bremen:992482066421792778>"))
                .addOption("Hamburg", "hamburg", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Hamburg:992482067843645531>"))
                .addOption("Hessen", "hessen", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Hessen:992482069261340752>"))
                .addOption("Mecklenburg-Vorpommern", "mecklenburgvorpommern", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Mecklen:992482070528020540>"))
                .addOption("Niedersachsen", "niedersachsen", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Nieders:992482071635296397>"))
                .addOption("Nordrhein Westfalen", "nordrheinwestfalen", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Nordrhe:992482073048793188>"))
                .addOption("Rheinland-Pfalz", "rheinlandpfalz", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Rheinla:992482074323865770>"))
                .addOption("Saarland", "saarland", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_des_Saarlan:992482062080692284>"))
                .addOption("Sachsen", "sachsen", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Sachsen:992482075556986910>"))
                .addOption("Sachsen-Anhalt", "sachsenanhalt", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Sachsen:992482076853031022>"))
                .addOption("Schleswig-Holstein", "schleswigholstein", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Schlesw:992482078174224534>"))
                .addOption("Thüringen", "thuringen", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:50pxDeutschland_Lage_von_Thringe:992482079466065990>"))

                .setRequiredRange(1, 1);
    }

    static SelectMenu.Builder sendDMRoles() {

        return SelectMenu.create("dm")
                .setPlaceholder("Du kannst maximal 1 Rolle auswählen.")
                .addOption("DM's Open", "dmopen", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:DMOpen:992840873614262372>"))
                .addOption("Ask to DM's", "askdm", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:AsktoDM:992840870921506866>"))
                .addOption("DM's Closed", "dmclosed", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:DMClosed:992840871848464425>"))

                .setRequiredRange(1, 1);
    }

    static SelectMenu.Builder sendPlatformRoles() {

        return SelectMenu.create("platforms")
                .setPlaceholder("Du kannst mehrere Rollen auswählen.")
                .addOption("Windows", "windows", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Windows:992757071013478400>"))
                .addOption("Apple", "apple", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Apple:992757064038371338>"))
                .addOption("Android", "android", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Android:992757062696177744>"))
                .addOption("Nintendo", "nintendo", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Switch:992757067200856156>"))
                .addOption("Xbox", "xbox", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Xbox:992757072657666118>"))
                .addOption("Playstation", "playstation", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Playstation:992757065338585108>"))

                .setRequiredRange(1, 6);
    }

    static SelectMenu.Builder sendSkillRoles() {

        return SelectMenu.create("skill")
                .setPlaceholder("Du kannst mehrere Rollen auswählen.")
                .addOption("Grafik Design", "grafik", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Grafik:992867971066249326>"))
                .addOption("Videoschnitt", "video", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Video:992865247197138944>"))
                .addOption("Programmieren", "coden", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Coden:992865244248547448>"))

                .setRequiredRange(1, 3);
    }

    static SelectMenu.Builder sendGameRoles1() {

        SelectMenu.Builder builder = SelectMenu.create("game1").setPlaceholder("Du kannst mehrere Rollen auswählen.");

        builder
                .addOption("Age of Empires 4", "ageofempires4", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:age_of_empires_4_sm:992875373584982136>"))
                .addOption("Among Us", "amongus", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:among_us_sm:992875376177074206>"))
                .addOption("Apex Legends", "apexlegends", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:apex_legends_sm:992875377414381580>"))
                .addOption("Ark", "ark", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:ark_sm:992875379079528540>"))
                .addOption("Astroneer", "astroneer", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:astroneer_sm:992875380144869528>"))
                .addOption("Back 4 Blood", "back4blood", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:back_4_blood_sm:992875385027043328>"))
                .addOption("Battlefield 2042", "battlefield2042", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:battlefield_2042_sm:992875386755092552>"))
                .addOption("Battlefield V", "battlefieldv", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:battlefield_v_sm:992875388399263855>"))
                .addOption("Borderlands 3", "borderlands3", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:borderlands_3_sm:992875391234605086>"))
                .addOption("Brawhalla", "brawhalla", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:brawlhalla_sm:992875393298202694>"))
                .addOption("Call of Duty: Cold War", "callofdutycoldwar", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:call_of_duty_cold_war_sm:992875394577481769>"))
                .addOption("Call of Duty: Modern Warfare 2", "callofdutymw2", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:MW2:1045744203000451232>"))
                .addOption("Call of Duty: Vanguard", "callofdutyvanguard", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:call_of_duty_vanguard_sm:992875396150341802>"))
                .addOption("Call of Duty: Warzone", "callofdutywarzone", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:call_of_duty_warzone_sm:992875397588975698>"))
                .addOption("Counter-Strike: GO", "csgo", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:counter_strike_go_sm:992875399635804161>"))
                .addOption("Cyberpunk 2077", "cyberpunkt2077", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:cyberpunk_2077_sm:992875405956620338>"))
                .addOption("DayZ", "dayz", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:dayz_sm:992875408796168222>"))
                .addOption("Destiny 2", "destiny2", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:destiny_2_sm:992875410020913172>"))
                .addOption("Diablo III", "diabloiii", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:diablo_iii_sm:992875411019153440>"))
                .addOption("Diablo IV", "diabloiv", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:D4:1130793450971861102>"))
                .addOption("DOOM Eternal", "doometernal", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:doom_eternal_sm:992875415519633458>"))
                .addOption("Dota 2", "dota2", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:dota_2_sm:992875416836636703>"))
                .addOption("Dota Underlords", "dotaunderloards", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:dota_underlords_sm:992875418124288020>"))
                .setRequiredRange(1, builder.getOptions().size());

        return builder;

    }

    static SelectMenu.Builder sendGameRoles2() {

        SelectMenu.Builder builder = SelectMenu.create("game2").setPlaceholder("Du kannst mehrere Rollen auswählen.");

        builder
                .addOption("Elden Ring", "eldenring", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:elden_ring_sm:992875419445514240>"))
                .addOption("Elder Scrolls Online", "elderscrollsonline", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:elder_scrolls_online_sm:992875421030948925>"))
                .addOption("Factorio", "factorio", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:factorio_sm:992875422041784321>"))
                .addOption("Farming Simulator 22", "farmingsimulator22", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:Fs22:1045744406097055774>"))
                .addOption("Fall Guys: Ultimate Knockout", "fallguys", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:fall_guys_sm:992875425359474738>"))
                .addOption("Fallout 76", "fallout76", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:fallout_76_sm:992875426819080263>"))
                .addOption("For Honor", "forhonor", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:for_honor_sm:992875431835476038>"))
                .addOption("Fortnite", "fortnite", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:fortnite_sm:992875433106341929>"))
                .addOption("Forza Horizon 5", "forzahorizon5", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:forza_5_sm:992875436101079070>"))
                .addOption("Garry's Mod", "garrysmod", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:garrys_mod_sm:992875437715894272>"))
                .addOption("Grand Theft Auto 5", "gta5", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:grand_theft_auto_5_sm:992875441130057778>"))
                .addOption("Grounded", "grounded", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:grounded_sm:992875443348832356>"))
                .addOption("Halo: The Master Chief Collection", "halothemasterchiefcollection", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:halo_the_master_chief_collection:992875446620393503>"))
                .addOption("Hearthstone", "hearthstone", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:hearthstone_sm:992875447866114179>"))
                .addOption("Hell Let Loose", "hellletloose", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:hell_let_loose_sm:992875448763678731>"))
                .addOption("Heroes of the Storm", "heroesofthestorm", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:heroes_of_the_storm_sm:992875450307195060>"))
                .addOption("Hunt: Showdown", "huntshowdown", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:hunt_showdown_sm:992875452442091560>"))
                .addOption("League of Legends", "lol", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:league_of_legends_sm:992875455373914122>"))
                .addOption("Lost Ark", "lostark", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:lost_ark_sm:992875372154720326>"))
                .setRequiredRange(1, builder.getOptions().size());

        return builder;

    }

    static SelectMenu.Builder sendGameRoles3() {

        SelectMenu.Builder builder = SelectMenu.create("game3").setPlaceholder("Du kannst mehrere Rollen auswählen.");

        builder
                .addOption("Microsoft Flight Simulator", "microsoftflightsimulator", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:flight_simulator_sm:992875430631710730>"))
                .addOption("Minecraft", "minecraft", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:minecraft_sm:992875638656602142>"))
                .addOption("Monster Hunter World", "monsterhunterworld", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:monster_hunter_world_sm:992875642116919386>"))
                .addOption("Mordhau", "mordhau", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:mordhau_sm:992875644503465985>"))
                .addOption("Mount & Blade II: Bannerlord", "mountbladeiibannerlord", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:mount_and_blade_ii_bannerlord_sm:992875646671917076>"))
                .addOption("New World", "newworld", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:new_world_sm:992875648278335489>"))
                .addOption("No Man's Sky", "nomanssky", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:no_mans_sky_sm:992875649612120184>"))
                .addOption("osu!", "osu", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:osu_sm:992875653571559624>"))
                .addOption("Overwatch 2", "overwatch2", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:overwatch_2_sm:992875654783696916>"))
                .addOption("Overwatch", "overwatch", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:overwatch_sm:992875655861645322>"))
                .addOption("Paladins", "paladins", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:paladins_sm:992875657132527646>"))
                .addOption("Path of Exile", "pathofexile", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:path_of_exile_sm:992875658705371227>"))
                .addOption("PayDay 2", "payday2", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:payday_2_sm:992875660169195662>"))
                .addOption("Phasmophobia", "phasmophobia", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:phasmophobia_sm:992875662094385263>"))
                .addOption("PUBG: Battlegrounds", "pubg", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:pubg_sm:992875663637893152>"))
                .addOption("Rainbow 6 Siege", "rainbow6siege", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:rainbow_6_siege_sm:992875666976546887>"))
                .addOption("Realm Royale", "realmroyale", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:realm_royale_sm:992875668838809681>"))
                .addOption("Red Dead Redemption 2", "rdr2", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:red_dead_redemption_2_sm:992875670558490684>"))
                .addOption("Ring of Elysium", "ringofelysium", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:ring_of_elysium_sm:992875671829368892>"))
                .addOption("Rocket League", "rocketleague", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:rocket_league_sm:992875675776208997>"))
                .addOption("Rust", "rust", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:rust_sm:992875682017312768>"))
                .setRequiredRange(1, builder.getOptions().size());

        return builder;

    }

    static SelectMenu.Builder sendGameRoles4() {

        SelectMenu.Builder builder = SelectMenu.create("game4").setPlaceholder("Du kannst mehrere Rollen auswählen.");

        builder
                .addOption("Satisfactory", "satisfactory", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:satisfactory_sm:992875683556638873>"))
                .addOption("SCUM", "scum", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:scum_sm:992875685074972793>"))
                .addOption("Sea of Thieves", "seaofthieves", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:sea_of_thieves_sm:992875687302144030>"))
                .addOption("Smite", "smite", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:smite_sm:992875688560443453>"))
                .addOption("Star Citizen", "starcitizen", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:star_citizen_sm:992875691043459133>"))
                .addOption("Subnautica: Below Zero", "subnautica", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:subnautica_below_zero_sm:992875695258742804>"))
                .addOption("Team Fortress 2", "teamfortress2", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:team_fortress_2_sm:992875697985032223>"))
                .addOption("Teamfight Tactics", "teamfighttactics", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:teamfight_tactics_sm:992875700224786462>"))
                .addOption("The Division 2", "thedivision2", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:the_division_2_sm:992875704322637904>"))
                .addOption("V Rising", "vrising", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:v_rising_sm:992875706986020935>"))
                .addOption("Valheim", "valheim", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:valheim_sm:992875709930410126>"))
                .addOption("Valorant", "valorant", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:valorant_sm:992875711062868149>"))
                .addOption("Vermintide 2", "vermintide2", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:vermintide_2_sm:992875712828686397>"))
                .addOption("War Thunder", "warthunder", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:war_thunder_sm:992875714363805816>"))
                .addOption("Warframe", "warframe", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:warframe_sm:992875716586766366>"))
                .addOption("World of Tanks", "worldofthanks", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:world_of_tanks_sm:992875626056921170>"))
                .addOption("World of Warcraft", "worldofwarcraft", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:world_of_warcraft_sm:992875630226063370>"))
                .addOption("World of Warships", "worldofwarships", "Klicke um diese Option zu wählen!", Emoji.fromFormatted("<:world_of_warships_sm:992875634281955408>"))
                .setRequiredRange(1, builder.getOptions().size());

        return builder;

    }

}