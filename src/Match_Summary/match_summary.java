package Match_Summary;

import Helpers.Excel_Utility;
import Models.InningsSummary;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class match_summary {

    String winning_team;
    String losing_team;

    public void matchSummary(InningsSummary firstInningsSummary, InningsSummary secondInningsSummary) throws IOException, InvalidFormatException {

        System.out.println("\n------------------------------------------------------------Match Result----------------------------------------------\n");

        if (secondInningsSummary.getTotalRuns() > firstInningsSummary.getTotalRuns()) {

            String match_result = secondInningsSummary.getBattingTeamName().replace('_', ' ') + " Won by " + (firstInningsSummary.getTOTAL_WICKETS() - secondInningsSummary.getWickets()) + " wickets";
            System.out.println(match_result);

            winning_team = secondInningsSummary.getBattingTeamName();
            losing_team = firstInningsSummary.getBattingTeamName();
        }

        else if (secondInningsSummary.getTotalRuns() < firstInningsSummary.getTotalRuns()) {

            String match_result = secondInningsSummary.getBowlingTeamName().replace('_', ' ') + " Won by " + (firstInningsSummary.getTotalRuns() - secondInningsSummary.getTotalRuns()) + " runs";
            System.out.println(match_result);

            winning_team = firstInningsSummary.getBattingTeamName();
            losing_team = secondInningsSummary.getBattingTeamName();
        }

//        elif (Total2 == Total1) {
//            winning_team = team_to_bat
//            losing_team = team_to_bowl
//            is_drawn = 1
//            print('\n\n-------------------------------------------------------Match drawn-----------------------------------------------\n')
//        }


        Excel_Utility eu = new Excel_Utility();
        eu.updatePointsTable(winning_team,true);
        eu.updatePointsTable(losing_team,false);
        eu.writePointsTable();
    }


}
