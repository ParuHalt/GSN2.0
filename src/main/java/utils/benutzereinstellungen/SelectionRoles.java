package utils.benutzereinstellungen;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SelectionRoles extends ListenerAdapter {

    private static HashMap<String, Role> roles;
    private static List<String> menus = Arrays.asList("region", "platforms", "gender", "age", "dm", "skill", "game1", "game2", "game3", "game4");
    private static List<String> buttons = Arrays.asList("resetall", "resetplatforms", "resetgender", "resetage", "resetregion", "resetdm", "resetskill", "resetgames");

    public void onSelectMenuInteraction(SelectMenuInteractionEvent e) {

        if(menus.contains(e.getComponentId())) {

            if(!e.getValues().isEmpty()) {

                String added = "";
                String removed = "";

                int addedint = 0, removedint = 0, currentint = 0;

                List<Role> memberRoles = new ArrayList<Role>(e.getMember().getRoles());

                InteractionHook ih = e.deferReply(true).complete();

                for(SelectOption so : e.getComponent().getOptions()) {

                    String value = so.getValue();
                    Role role = roles.get(value);

                    if(e.getValues().contains(value)) {

                        if(!memberRoles.contains(role)) {

                            memberRoles.add(role);
                            added = added + ", " + role.getAsMention();
                            addedint++;

                        }

                    }else {

                        if(memberRoles.contains(role)) {

                            memberRoles.remove(role);
                            removed = removed + ", " + role.getAsMention();
                            removedint++;

                        }

                    }

                }

                e.getGuild().modifyMemberRoles(e.getMember(), memberRoles).queue();

                EmbedBuilder eb = new EmbedBuilder();

                eb.setTitle("Werte wurden geupdated!");

                switch(e.getComponentId()) {

                    case "age": eb.setTitle("Dein Alter wurde aktualisiert!"); break;
                    case "gender": eb.setTitle("Dein Geschlecht wurde aktualisiert!"); break;
                    case "region": eb.setTitle("Deine Region wurde aktualisiert!"); break;
                    case "dm": eb.setTitle("Deine Direct Message Einstellung wurde aktualisiert"); break;
                    case "skill": eb.setTitle("Deine Skills wurden aktualisiert!"); break;
                    case "platforms": eb.setTitle("Deine Plattformen wurden aktualisiert!"); break;
                    case "game1": eb.setTitle("Deine Games wurden aktualisiert!"); break;
                    case "game2": eb.setTitle("Deine Games wurden aktualisiert!"); break;
                    case "game3": eb.setTitle("Deine Games wurden aktualisiert!"); break;
                    case "game4": eb.setTitle("Deine Games wurden aktualisiert!"); break;

                }

                if(added.equals("") && removed.equals("")) {

                    eb.addField("Veränderungen:", "Keine Rollen verändert!", false);

                }

                eb.setColor(0x4b3488);
                eb.setThumbnail("https://cdn.discordapp.com/attachments/990240111042113536/992753818402046042/synchronize.png");
                if (added != "") {
                    eb.addField("<:Plus:992816396515946646> Neue Werte (" + addedint + "):", added.substring(2), false);
                }
                if(removed != "") {
                    eb.addField("<:Minus:992816397845528586> Entfernte Werte (" + removedint + "):", removed.substring(2), false);
                }
                String current = "";

                List<Role> currentRoles = memberRoles;
                currentRoles.retainAll(getRolesByMenuId(e.getComponentId()));

                for(Role r : currentRoles) {
                    current = current + ", " + r.getAsMention();
                    currentint++;
                }
                if(current != "") {
                    eb.addField("Aktuelle Werte (" + currentint + "):", current.substring(2), false);
                }

                ih.editOriginal(new MessageBuilder(eb.build()).build()).queueAfter(500, TimeUnit.MILLISECONDS);

            }
        }
    }

    public void onButtonInteraction(ButtonInteractionEvent e) {

        if(buttons.contains(e.getComponentId())) {

            List<Role> memberRoles = new ArrayList<Role>(e.getMember().getRoles());
            SelectMenu[] selectMenu = getMenuById(e.getComponentId());

            String action = "";

            switch(e.getComponentId()) {

                case "resetage": action = "> Alter"; break;
                case "resetgender": action = "> Geschlecht"; break;
                case "resetregion": action = "> Region"; break;
                case "resetplatforms": action = "> Plattformen"; break;
                case "resetdm": action = "> Direct Message"; break;
                case "resetskill": action = "> Skills"; break;
                case "resetgame": action = "> Games"; break;
                case "resetall": action = "> Es wurden alle Kategorien zurückgesetzt"; break;

            }

            if(selectMenu == null) {

                for(String s : roles.keySet()) {

                    if(memberRoles.contains(roles.get(s))) {

                        memberRoles.remove(roles.get(s));

                    }

                }

            }else {

                for(SelectMenu sm : selectMenu) {

                    for(SelectOption so : sm.getOptions()) {

                        String s = so.getValue();

                        if(memberRoles.contains(roles.get(s))) {

                            memberRoles.remove(roles.get(s));

                        }

                    }

                }

            }

            e.getGuild().modifyMemberRoles(e.getMember(), memberRoles).queue();

            EmbedBuilder eb = new EmbedBuilder();

            eb.addField("Folgende Kategorie wurde zurückgesetzt:", action, true);
            eb.setColor(0x4b3488);
            eb.setThumbnail("https://cdn.discordapp.com/attachments/990240111042113536/992820840204877864/trash.png");

            e.replyEmbeds(eb.build()).setEphemeral(true).queue();

        }

    }

    public static List<String> getActiveValues(Member m, String id) {

        List<String> values = new ArrayList<String>();
        List<Role> memberRoles = m.getRoles();

        for(SelectMenu menu : getMenuById(id)) {

            for(SelectOption option : menu.getOptions()) {

                if(memberRoles.contains(roles.get(option.getValue()))) {

                    values.add(option.getValue());

                }

            }

        }

        return values;

    }

    public static List<Role> getRolesByMenuId(String id) {
        SelectMenu[] Menus = getMenuById(id);
        List<Role> values = new ArrayList<Role>();

        for(SelectMenu menu : Menus) {

            for(SelectOption option : menu.getOptions()) {

                values.add(roles.get(option.getValue()));

            }

        }

        return values;

    }

    public static SelectMenu[] getMenuById(String id) {

        switch(id) {

            case "resetage": case "age": return new SelectMenu[]{MainMenu.sendAgeRoles().build()};
            case "resetgender": case "gender": return new SelectMenu[]{MainMenu.sendGenderRoles().build()};
            case "resetregion": case "region": return new SelectMenu[]{MainMenu.sendRegionRoles().build()};
            case "resetplatforms": case "platforms": return new SelectMenu[]{MainMenu.sendPlatformRoles().build()};
            case "resetdm": case "dm": return new SelectMenu[]{MainMenu.sendDMRoles().build()};
            case "resetskill": case "skill": return new SelectMenu[]{MainMenu.sendSkillRoles().build()};
            case "resetgame": case "games": case "game1": case "game2": case "game3": case "game4": return new SelectMenu[]{MainMenu.sendGameRoles1().build(), MainMenu.sendGameRoles2().build(), MainMenu.sendGameRoles3().build(), MainMenu.sendGameRoles4().build()};
            default: return null;

        }
    }

    public void onMessageReceived(MessageReceivedEvent e) {

        if(!e.getChannelType().equals(ChannelType.PRIVATE) && e.getAuthor().getId().equals("600230293550399488") && e.getMessage().getContentDisplay().equals("!gimmeall")) {

            List<Role> roleList = new ArrayList<Role>(e.getMember().getRoles());

            for(Role r : roles.values()) {

                if(!roleList.contains(r)) {

                    roleList.add(r);

                }

            }

            e.getGuild().modifyMemberRoles(e.getMember(), roleList).queue();

        }

    }

    public void onReady(ReadyEvent e) {

        Guild guild = e.getJDA().getGuildById("984470784972042271");

        roles = new HashMap<String, Role>() {{

            // Age Roles

            put("under18", guild.getRoleById("984895847940632576"));
            put("18-20", guild.getRoleById("984895977167142952"));
            put("21-25", guild.getRoleById("984896191311527996"));
            put("26-30", guild.getRoleById("984896279949754390"));
            put("over30", guild.getRoleById("984896542886490133"));

            // Gender Roles

            put("male", guild.getRoleById("984897171629432902"));
            put("female", guild.getRoleById("984897284137418762"));
            put("divers", guild.getRoleById("992104505942483016"));

            // Region Roles

            put("schweiz", guild.getRoleById("992467791749845093"));
            put("osterreich", guild.getRoleById("992467889401626674"));
            put("badenwürttemberg", guild.getRoleById("992464394745286666"));
            put("bayern", guild.getRoleById("992464555030609930"));
            put("berlin", guild.getRoleById("992464643056484445"));
            put("brandenburg", guild.getRoleById("992465558098415676"));
            put("bremen", guild.getRoleById("992466369708826644"));
            put("hamburg", guild.getRoleById("992466596884905997"));
            put("hessen", guild.getRoleById("992466654434967552"));
            put("mecklenburgvorpommern", guild.getRoleById("992466715407564931"));
            put("niedersachsen", guild.getRoleById("992466837755408434"));
            put("nordrheinwestfalen", guild.getRoleById("992466949059645540"));
            put("rheinlandpfalz", guild.getRoleById("992467050326917151"));
            put("saarland", guild.getRoleById("992467108841672804"));
            put("sachsen", guild.getRoleById("992467190219554816"));
            put("sachsenanhalt", guild.getRoleById("992467256141414481"));
            put("schleswigholstein", guild.getRoleById("992467320284917871"));
            put("thuringen", guild.getRoleById("992467696102944919"));

            //Platform Roles

            put("windows", guild.getRoleById("990570270727217222"));
            put("apple", guild.getRoleById("990570993808470046"));
            put("android", guild.getRoleById("990571190349365288"));
            put("nintendo", guild.getRoleById("990571403742945330"));
            put("xbox", guild.getRoleById("990571445887320144"));
            put("playstation", guild.getRoleById("990571451331510282"));

            //DM Roles
            put("dmopen", guild.getRoleById("990573075378630676"));
            put("askdm", guild.getRoleById("990573315192160316"));
            put("dmclosed", guild.getRoleById("990573585041076244"));

            //Skill Roles
            put("grafik", guild.getRoleById("990571834401521674"));
            put("video", guild.getRoleById("990572115675709451"));
            put("coden", guild.getRoleById("990572584770867200"));

            //Game Roles
            put("ageofempires4", guild.getRoleById("990594150346928139"));
            put("amongus", guild.getRoleById("990584399860998204"));
            put("apexlegends", guild.getRoleById("990584386787352576"));
            put("ark", guild.getRoleById("990584401354186792"));
            put("astroneer", guild.getRoleById("990591249411096618"));
            put("back4blood", guild.getRoleById("990593604617658428"));
            put("battlefield2042", guild.getRoleById("990591254985322516"));
            put("battlefieldv", guild.getRoleById("990586061803646976"));
            put("borderlands3", guild.getRoleById("990588174734602270"));
            put("brawhalla", guild.getRoleById("990586067730194442"));
            put("callofdutycoldwar", guild.getRoleById("990586057227661362"));
            put("callofdutyvanguard", guild.getRoleById("990593601979433000"));
            put("callofdutywarzone", guild.getRoleById("990584394748153916"));
            put("csgo", guild.getRoleById("990583324848295977"));
            put("cyberpunkt2077", guild.getRoleById("990586066182475796"));
            put("dayz", guild.getRoleById("990593603761999912"));
            put("destiny2", guild.getRoleById("990584399152160798"));
            put("diabloiii", guild.getRoleById("990586065347833866"));
            put("doometernal", guild.getRoleById("990591242847002644"));
            put("dota2", guild.getRoleById("990584398321680414"));
            put("dotaunderloards", guild.getRoleById("990591255723540500"));
            put("eldenring", guild.getRoleById("990593602491133992"));
            put("elderscrollsonline", guild.getRoleById("990588412505513994"));
            put("factorio", guild.getRoleById("990591245124505681"));
            put("fallguys", guild.getRoleById("990586061916889148"));
            put("fallout76", guild.getRoleById("990588408193761361"));
            put("forhonor", guild.getRoleById("990588171530166304"));
            put("fortnite", guild.getRoleById("990582892046458900"));
            put("forzahorizon5", guild.getRoleById("990591253240479744"));
            put("garrysmod", guild.getRoleById("990586069747658782"));
            put("gta5", guild.getRoleById("990584391266861128"));
            put("grounded", guild.getRoleById("990591250304483329"));
            put("guildwars2", guild.getRoleById("990588414489407558"));
            put("halothemasterchiefcollection", guild.getRoleById("990588173992198144"));
            put("hearthstone", guild.getRoleById("990586067080065074"));
            put("hellletloose", guild.getRoleById("990594546842873877"));
            put("heroesofthestorm", guild.getRoleById("990588411188494406"));
            put("huntshowdown", guild.getRoleById("990594153077432360"));
            put("lol", guild.getRoleById("990581853469687828"));
            put("lostark", guild.getRoleById("990588410420949022"));
            put("microsoftflightsimulator", guild.getRoleById("990591252145778700"));
            put("minecraft", guild.getRoleById("990583261933735946"));
            put("monsterhunterworld", guild.getRoleById("990586064500563978"));
            put("mordhau", guild.getRoleById("990591254955950150"));
            put("mountbladeiibannerlord", guild.getRoleById("990591256281362463"));
            put("newworld", guild.getRoleById("990588409099747338"));
            put("nomanssky", guild.getRoleById("990588170154422322"));
            put("osu", guild.getRoleById("990586063284211783"));
            put("overwatch2", guild.getRoleById("990594150971895889"));
            put("overwatch", guild.getRoleById("990584397004685342"));
            put("paladins", guild.getRoleById("990586062730575872"));
            put("pathofexile", guild.getRoleById("990586069852491817"));
            put("payday2", guild.getRoleById("990586071005929483"));
            put("phasmophobia", guild.getRoleById("990586057999388712"));
            put("pubg", guild.getRoleById("990584397709328464"));
            put("rainbow6siege", guild.getRoleById("990584393749901313"));
            put("realmroyale", guild.getRoleById("990591245963366430"));
            put("rdr2", guild.getRoleById("990586061090619412"));
            put("ringofelysium", guild.getRoleById("990591251520835654"));
            put("rocketleague", guild.getRoleById("990584395415044096"));
            put("rust", guild.getRoleById("990584400670498816"));
            put("satisfactory", guild.getRoleById("990588412522287184"));
            put("scum", guild.getRoleById("990588413092704328"));
            put("seaofthieves", guild.getRoleById("990586056317472788"));
            put("smite", guild.getRoleById("990586072830459955"));
            put("starcitizen", guild.getRoleById("990591243715248138"));
            put("starcraftii", guild.getRoleById("990591240217182228"));
            put("subnautica", guild.getRoleById("990591245883670578"));
            put("teamfortress2", guild.getRoleById("990588169294585876"));
            put("teamfighttactics", guild.getRoleById("990586053960282174"));
            put("thedivision2", guild.getRoleById("990586068585816124"));
            put("vrising", guild.getRoleById("990594544645062776"));
            put("valheim", guild.getRoleById("990586071932887040"));
            put("valorant", guild.getRoleById("990582367871709205"));
            put("vermintide2", guild.getRoleById("990591251487273011"));
            put("warthunder", guild.getRoleById("990591240561098794"));
            put("warframe", guild.getRoleById("990586059366756362"));
            put("worldofthanks", guild.getRoleById("990591246454120450"));
            put("worldofwarcraft", guild.getRoleById("990584401966538812"));
            put("worldofwarships", guild.getRoleById("990591248442216478"));

        }};
    }
}
