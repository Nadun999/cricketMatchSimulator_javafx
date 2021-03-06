package Innings;

import Helpers.Excel_Utility;
import Helpers.Helper;
import Models.Batsman;
import Models.Bowler;
import Models.Team_Array;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Second_Innings extends Innings {

    private int second_ing_total = 0;
    private int second_ing_balls = 1;
    private int second_ing_wickets = 0;

    public Second_Innings(List<Team_Array> toss_outcome) throws IOException {
        battingInfo = toss_outcome.get(1);
        bowlingInfo = toss_outcome.get(0);
    }

    public int getSecond_ing_total() {
        return second_ing_total;
    }

    public int getSecond_ing_balls() {
        return second_ing_balls;
    }

    public int getSecond_ing_wickets() {
        return second_ing_wickets;
    }

    public void playSecondInnings(int Total) throws IOException, InvalidFormatException {

        bowlingTeam = eu.getBowlingTeamFromExcel(bowlingInfo.getTeamName(),true);
        battingTeam = eu.getBattingTeamFromExcel(battingInfo.getTeamName(),true);

        Batsman batsman_onstrike = new Batsman();
        Batsman batsman_offstrike = new Batsman();
        Bowler bowler_onstrike = new Bowler();

        ArrayList<Batsman> yetToBat = new ArrayList();
        ArrayList<Batsman> dismissedBatsman = new ArrayList();
        ArrayList<Bowler> yetToBowl = new ArrayList();

        int bowlerScore = 0; /** score counting variable for bowler **/
        int batterScore = 0; /** score counting variable for batsman **/

        yetToBat = battingTeam;

        /** getting the last 5 players from bowling team **/
        for (int i = bowlingTeam.size() - 1; i >= 6; i--) {
            yetToBowl.add(bowlingTeam.get(i));
        }

        /** opening batsmen coming to the field **/
        batsman_onstrike = yetToBat.get(0);
        yetToBat.remove(0);
        batsman_offstrike = yetToBat.get(0);
        yetToBat.remove(0);

        /** opening bowler **/
        bowler_onstrike = yetToBowl.get(0);
        yetToBowl.remove(0);

        /** match starts **/
        while (second_ing_balls < (TOTAL_BALLS+1)) {
            if ((second_ing_wickets == TOTAL_WICKETS) || (second_ing_total > Total)) {
                break;
            }
            else {
                if (((second_ing_balls - 1) > 0) && ((second_ing_balls - 1) % 6 == 0) && (yetToBowl.size() > 0)) {
                    yetToBowl.add(bowler_onstrike);
                    bowler_onstrike = yetToBowl.get(0);
                    yetToBowl.remove(0);
                }

                /** get random scores for bowler and batsman **/
                Random random = new Random();
                bowlerScore = cricketHelper.genarateBowlerScore();
                batterScore = cricketHelper.genarateBatterScore();

                /** when batsman is out **/
                if (bowlerScore == batterScore) {

                    /** out - add wicket to wickets **/
                    second_ing_wickets ++;

                    /** adding wickets to bowler **/
                    bowler_onstrike.setWickets(bowler_onstrike.getWickets()+1);

                    /** adding first_ing_balls to batsman **/
                    batsman_onstrike.setBalls(batsman_onstrike.getBalls()+1);

                    /** adding dismissed bowler name to batsman **/
                    batsman_onstrike.setBowlerName(bowler_onstrike.getName());

                    /** adding method of dismissal to batsman **/
                    batsman_onstrike.setMethodOfDissmal(cricketHelper.methodOfDismissal());

                    /** moving the dismissed_batsmen to dismissed_batsmen array **/
                    if (!dismissedBatsman.contains(batsman_onstrike)){
                        dismissedBatsman.add(batsman_onstrike);
                    }


                    /**
                     //fall of wickets
                     System.out.println('FOW at', first_ing_total, ' --> ', first_ing_wickets + 1, ' on over -', int(first_ing_balls / 6), '.', (first_ing_balls) % 6, batsman_onstrike[0][0]);

                     //appending the FOW data to the graph
                     graph_first_ing_fow_balls.append(first_ing_balls)
                     graph_first_ing_fow_total.append(first_ing_total)
                     **/


                    /** bring new batsman to the crease(batsman_onstrike) **/
                    if (yetToBat.size() > 0) {
                        batsman_onstrike = yetToBat.get(0);
                        yetToBat.remove(0);
                    }
                }

                /** when batsman is scoring runs **/
                else {

                    /** add batter score to first_ing_total **/
                    second_ing_total += batterScore;

                    /** adding batter_score to current_batsman **/
                    batsman_onstrike.setRuns(batsman_onstrike.getRuns()+batterScore);

                    /** adding first_ing_balls to current_batsman **/
                    batsman_onstrike.setBalls(batsman_onstrike.getBalls()+1);

                    /** adding batter_score to current_bowler **/
                    bowler_onstrike.setRuns(bowler_onstrike.getRuns()+batterScore);

                    /** swapping onstrike batsman when strike rotates **/
                    if (batterScore == 1 || batterScore ==3) {
                        Batsman current_batsman = batsman_onstrike;
                        batsman_onstrike = batsman_offstrike;
                        batsman_offstrike = current_batsman;
                    }
                }
            }

            /** adding first_ing_balls to bowler **/
            bowler_onstrike.setBalls(bowler_onstrike.getBalls()+1);

            /** adding second_ing_balls to second_ing ball count **/
            second_ing_balls ++;
        }

        /** add dismissed_batsmen to batsman_list **/
        batsmanList = dismissedBatsman;

        /** add on and off strike batsmen to batsman_list **/
        if (second_ing_wickets != TOTAL_WICKETS) {
            if (!batsmanList.contains(batsman_onstrike)){
                batsman_onstrike.setMethodOfDissmal("* NOT OUT");
                batsmanList.add(batsman_onstrike);
            }
        }

        batsman_offstrike.setMethodOfDissmal("NOT OUT");
        batsmanList.add(batsman_offstrike);

        /** add each batsman in yet_to_bat to batsman_list array for displaying purposes **/
        if (yetToBat.size() > 0) {
            batsmanList.addAll(yetToBat);
        }

        /** add bowlers to bowler_list_second_ing **/
        bowlerList.addAll(yetToBowl);
        bowlerList.add(bowler_onstrike);

        /** sort score_card_second_ing to the original batting order **/
        Collections.sort(batsmanList,(o1, o2) -> o1.getBattingOrder().compareTo(o2.getBattingOrder()));

        /** writing the batsman list into a txt file **/
        try {
            File myFile1 = new File("src/txt2/secondBattingCard.txt");
            PrintStream writer = new PrintStream(myFile1);

            for(Batsman i: batsmanList) {
                writer.print(i.getName()+"      "+i.getRuns()+"  "+i.getBalls()+"  "+i.getMethodOfDissmal()+"    "+i.getBowlerName()+ System.lineSeparator());
            }
            writer.close();

        } catch(FileNotFoundException fnf) {
            System.out.println(fnf+"file not found");
        }

        /** writing the bowler list into a txt file **/
        try {
            File myFile2 = new File("src/txt2/secondBowlingCard.txt");
            PrintStream writer = new PrintStream(myFile2);

            for(Bowler i: bowlerList) {
                double overs =((int)i.getBalls())/6+(((i.getBalls())%6)/10.0);
                writer.print(i.getName()+"      "+i.getRuns()+"  "+overs+"  "+i.getWickets()+ System.lineSeparator());
            }
            writer.close();

        } catch(FileNotFoundException fnf) {
            System.out.println(fnf+"file not found");
        }

        /** calling playerstanding to write the excel file **/
        eu.playerStandingWriteExcel(batsmanList,bowlerList,true);
        eu.playerStandingWriteExcel(batsmanList,bowlerList,false);
    }
}