package Models;

public class InningsSummary {

    private String battingTeamName;
    private String bowlingTeamName;
    private static int TOTAL_WICKETS = 10;
    private int totalRuns;
    private int wickets;


    public String getBattingTeamName() {
        return battingTeamName;
    }

    public void setBattingTeamName(String battingTeamName) {
        this.battingTeamName = battingTeamName;
    }

    public String getBowlingTeamName() {
        return bowlingTeamName;
    }

    public void setBowlingTeamName(String bowlingTeamName) {
        this.bowlingTeamName = bowlingTeamName;
    }

    public int getTOTAL_WICKETS() {
        return TOTAL_WICKETS;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}
