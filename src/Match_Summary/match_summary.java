package Match_Summary;

import Helpers.Excel_Utility;
import Models.InningsSummary;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class match_summary {

    private String winning_team;
    private String losing_team;

    public void matchSummary(InningsSummary firstInningsSummary, InningsSummary secondInningsSummary) throws IOException, InvalidFormatException {

        if (secondInningsSummary.getTotalRuns() > firstInningsSummary.getTotalRuns()) {
            String match_result = secondInningsSummary.getBattingTeamName().replace('_', ' ') + " Won by " + (firstInningsSummary.getTOTAL_WICKETS() - secondInningsSummary.getWickets()) + " wickets";
            winning_team = secondInningsSummary.getBattingTeamName();
            losing_team = firstInningsSummary.getBattingTeamName();
        } else if (secondInningsSummary.getTotalRuns() < firstInningsSummary.getTotalRuns()) {
            String match_result = secondInningsSummary.getBowlingTeamName().replace('_', ' ') + " Won by " + (firstInningsSummary.getTotalRuns() - secondInningsSummary.getTotalRuns()) + " runs";
            winning_team = firstInningsSummary.getBattingTeamName();
            losing_team = secondInningsSummary.getBattingTeamName();
        }

        Excel_Utility eu = new Excel_Utility();
        eu.updatePointsTable(winning_team,true);
        eu.updatePointsTable(losing_team,false);
        eu.writePointsTable();
    }
}
