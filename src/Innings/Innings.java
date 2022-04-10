package Innings;

import Helpers.Excel_Utility;
import Helpers.Helper;
import Models.Batsman;
import Models.Bowler;
import Models.Team_Array;

import java.io.IOException;
import java.util.ArrayList;

public class Innings {

    protected Helper cricketHelper = new Helper();
    protected Team_Array battingInfo = new Team_Array();
    protected Team_Array bowlingInfo = new Team_Array();
    protected ArrayList<Batsman> battingTeam = new ArrayList<>();
    protected ArrayList<Bowler> bowlingTeam = new ArrayList<>();
    protected Excel_Utility eu = new Excel_Utility();
    protected ArrayList<Batsman> batsmanList = new ArrayList();
    protected ArrayList<Bowler> bowlerList = new ArrayList();

    final int TOTAL_BALLS = 120;
    final int TOTAL_WICKETS = 10;


    public Innings() throws IOException {
    }

    public Helper getCricketHelper() {
        return cricketHelper;
    }

    public void setCricketHelper(Helper cricketHelper) {
        this.cricketHelper = cricketHelper;
    }

    public Team_Array getBattingInfo() {
        return battingInfo;
    }

    public void setBattingInfo(Team_Array battingInfo) {
        this.battingInfo = battingInfo;
    }

    public Team_Array getBowlingInfo() {
        return bowlingInfo;
    }

    public void setBowlingInfo(Team_Array bowlingInfo) {
        this.bowlingInfo = bowlingInfo;
    }

    public ArrayList<Batsman> getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(ArrayList<Batsman> battingTeam) {
        this.battingTeam = battingTeam;
    }

    public ArrayList<Bowler> getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(ArrayList<Bowler> bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public Excel_Utility getEu() {
        return eu;
    }

    public void setEu(Excel_Utility eu) {
        this.eu = eu;
    }

    public ArrayList<Batsman> getBatsmanList() {
        return batsmanList;
    }

    public void setBatsmanList(ArrayList<Batsman> batsmanList) {
        this.batsmanList = batsmanList;
    }

    public ArrayList<Bowler> getBowlerList() {
        return bowlerList;
    }

    public void setBowlerList(ArrayList<Bowler> bowlerList) {
        this.bowlerList = bowlerList;
    }

    public int getTOTAL_BALLS() {
        return TOTAL_BALLS;
    }

    public int getTOTAL_WICKETS() {
        return TOTAL_WICKETS;
    }
}
