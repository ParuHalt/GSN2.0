package LevelSystem;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ButtonInteraction extends ListenerAdapter {

    HashMap<Integer,String> levelroles = new HashMap<>();

    Member m;
    String me = "";

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {

        levelroles.put(1, "986725612347609088");
        levelroles.put(2 , "986725527756890132");
        levelroles.put(3 , "986725450388734063");
        levelroles.put(4 , "986725332587532318");
        levelroles.put(5 , "986725256762916864");
        levelroles.put(6 , "986725163867471893");
        levelroles.put(7 , "986725089624092782");
        levelroles.put(8 , "986725018186702848");
        levelroles.put(9 , "986724547577389056");
        levelroles.put(10, "986724466530861137");
        levelroles.put(11 , "986724378031059084");
        levelroles.put(12 , "986724297680756736");
        levelroles.put(13 , "986724200796549160");
        levelroles.put(14 , "986724131905089597");
        levelroles.put(15 , "986724061281386576");
        levelroles.put(16 , "986723995242094592");
        levelroles.put(17 , "986723931757084682");
        levelroles.put(18 , "986723854049218570");
        levelroles.put(19 , "986723784457330728");
        levelroles.put(20 , "986723721232416829");
        levelroles.put(21 , "986723639279910922");
        levelroles.put(22 , "986723513803104347");
        levelroles.put(23 , "986723442818699274");
        levelroles.put(24 , "986723367317012560");
        levelroles.put(25 , "986723303915925514");
        levelroles.put(26 , "986723238694494260");
        levelroles.put(27 , "986723139738300456");
        levelroles.put(28 , "986723072063205496");
        levelroles.put(29 , "986722990030983188");
        levelroles.put(30 , "986722920208416819");
        levelroles.put(31 , "986722861064544276");
        levelroles.put(32 , "986722803686469632");
        levelroles.put(33 , "986722740683804742");
        levelroles.put(34 , "986722615957811301");
        levelroles.put(35 , "986722615957811301");
        levelroles.put(36 , "986722558260965476");
        levelroles.put(37 , "986722496596291594");
        levelroles.put(38 , "986722433505575032");
        levelroles.put(39 , "986722370188369920");
        levelroles.put(40 , "986722298318966837");
        levelroles.put(41 , "986722189288034344");
        levelroles.put(42 , "986722109965353010");
        levelroles.put(43 , "986722027803115541");
        levelroles.put(44 , "986721972962594867");
        levelroles.put(45 , "986721905878892625");
        levelroles.put(46 , "986721826212315196");
        levelroles.put(47 , "986721755110469763");
        levelroles.put(48 , "986721686982365309");
        levelroles.put(49 , "986721633404321853");
        levelroles.put(50 , "986721568308740116");
        levelroles.put(51 , "986721513451446362");
        levelroles.put(52 , "986721441770766377");
        levelroles.put(53 , "986721391812440124");
        levelroles.put(54 , "986721315899711508");
        levelroles.put(55 , "986721247301894204");
        levelroles.put(56 , "986721112765395044");
        levelroles.put(57 , "986721054040916038");
        levelroles.put(58 , "986720994121093230");
        levelroles.put(59 , "986720892459573269");
        levelroles.put(60 , "986720816320352347");
        levelroles.put(61 , "986720737974976613");
        levelroles.put(62 , "986720584421482516");
        levelroles.put(63 , "986720327398748191");
        levelroles.put(64 , "986720230225104938");
        levelroles.put(65 , "986720162357071912");
        levelroles.put(66 , "986720105218080848");
        levelroles.put(67 , "986720005100011541");
        levelroles.put(68 , "986719942474874900");
        levelroles.put(69 , "986719865245139035");
        levelroles.put(70 , "986719767857627217");
        levelroles.put(71 , "986717431483494440");
        levelroles.put(72 , "986719545488199740");
        levelroles.put(73 , "986719499195658290");
        levelroles.put(74 , "986719447794483310");
        levelroles.put(75 , "986719291724431390");
        levelroles.put(76 , "986719204587745331");
        levelroles.put(77 , "986719142335873094");
        levelroles.put(78 , "986719057640292352");
        levelroles.put(79 , "986718977935949884");
        levelroles.put(80 , "986718900618149928");
        levelroles.put(81 , "986718817499627540");
        levelroles.put(82 , "986718757361700914");
        levelroles.put(83 , "986718707537547265");
        levelroles.put(84 , "986718650536956005");
        levelroles.put(85 , "986718534652547112");
        levelroles.put(86 , "986718019843678288");
        levelroles.put(87 , "986717958443261983");
        levelroles.put(88 , "986717886401876030");
        levelroles.put(89 , "986717767023603832");
        levelroles.put(90 , "986717637906153553");
        levelroles.put(91 , "986717467411886151");
        levelroles.put(92 , "986716252133273601");
        levelroles.put(93 , "986716079323770911");
        levelroles.put(94 , "986715568935678002");
        levelroles.put(95 , "986715300332445716");
        levelroles.put(96 , "986668177226358824");
        levelroles.put(97 , "986668050868740167");
        levelroles.put(98 , "986667969511825498");
        levelroles.put(99 , "986715690742476821");
        levelroles.put(100 , "986667579865198613");


        if (event.getButton().getId().equals("lb")) {

            EmbedBuilder image1 = new EmbedBuilder();
            EmbedBuilder eb1 = new EmbedBuilder();

            image1.setImage("https://cdn.discordapp.com/attachments/987815549880926218/1131953422963322880/Leaderboard.png");
            image1.setColor(0x4b3488);

            eb1.setTitle("Das " + event.getGuild().getName() + " Leaderborad");
            eb1.setColor(0x4b3488);
            eb1.setImage("https://cdn.discordapp.com/attachments/818211419974664214/988044606891495454/Footer_Banner.png");


            //eb1.appendDescription("<@&986725612347609088>");
            //eb1.getDescriptionBuilder().append("\n");
                        for (Member member : event.getGuild().getMembers()) {
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(1)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                                //eb1.addField("1", "●" + member.getAsMention() , false);

                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(2)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(3)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(4)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(5)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(6)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(7)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(8)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(9)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(10)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(11)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(12)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(13)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(14)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(15)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(16)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(17)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(18)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(19)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(20)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(21)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(22)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(23)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(24)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(25)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(26)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(27)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(27)))) {


                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(29)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(30)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(31)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(32)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(33)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(34)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(35)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(36)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(37)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(38)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");

                            }if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(39)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(40)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(41)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(42)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(43)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(44)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(45)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(46)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(47)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(48)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(49)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(50)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(51)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(52)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(53)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(54)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(55)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(56)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(57)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(58)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(59)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(60)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(61)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(62)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(63)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(64)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(65)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(66)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(67)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(68)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(69)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(70)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(71)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(72)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(73)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(74)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(75)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(76)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(77)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(78)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(79)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(80)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(81)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(82)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(83)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(84)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(85)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(86)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(87)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(88)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(89)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(90)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(91)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(92)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(93)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(94)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(95)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(96)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(97)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(98)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(99)))) {

                                me = member.getId();
                                eb1.appendDescription("●" + member.getAsMention() + "\n");
                            }
                            if (member.getRoles().contains(event.getGuild().getRoleById(levelroles.get(100)))) {

                                me = member.getId();
                                //eb1.appendDescription("●" + member.getAsMention() + "\n");
                                eb1.addField("100", "●" + member.getAsMention() + "\n", false);
                            }
                        }

            event.replyEmbeds(image1.build(), eb1.build()).setEphemeral(true).queue();


        }
    }
}
