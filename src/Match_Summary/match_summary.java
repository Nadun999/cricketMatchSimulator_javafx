package Match_Summary;

import Models.InningsSummary;

public class match_summary {

    public void matchSummary(InningsSummary firstInningsSummary, InningsSummary secondInningsSummary){

        System.out.println("\n------------------------------------------------------------Match Result----------------------------------------------\n");
//        System.out.println(Total1+" \n"+Total2);

        if (secondInningsSummary.getTotalRuns() > firstInningsSummary.getTotalRuns()) {

            String match_result = secondInningsSummary.getBattingTeamName().replace('_', ' ') + " Won by " + (firstInningsSummary.getTOTAL_WICKETS() - secondInningsSummary.getWickets()) + " wickets";
            System.out.println(match_result);

//            winning_team = team_to_bowl
//            losing_team = team_to_bat
        }
//
        else if (secondInningsSummary.getTotalRuns() < firstInningsSummary.getTotalRuns()) {

            String match_result = secondInningsSummary.getBowlingTeamName().replace('_', ' ') + " Won by " + (firstInningsSummary.getTotalRuns() - secondInningsSummary.getTotalRuns()) + " runs";
            System.out.println(match_result);

//            winning_team = team_to_bat
//            losing_team = team_to_bowl
        }
//
//        elif (Total2 == Total1) {
//            winning_team = team_to_bat
//            losing_team = team_to_bowl
//            is_drawn = 1
//            print('\n\n-------------------------------------------------------Match drawn-----------------------------------------------\n')
//        }

    }


}
