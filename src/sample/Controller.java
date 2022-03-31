package sample;
import Helpers.Excel_Utility;
import Helpers.Helper;
import Innings.First_Innings;
import Innings.Second_Innings;
import Match_Summary.match_summary;
import Models.Batsman;
import Models.Bowler;
import Models.InningsSummary;
import Models.Team_Array;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class Controller {


    Team_Array team1 = new Team_Array("Mumbai_India");
    Team_Array team2 = new Team_Array("Chennai_SouthAfrica");
    Team_Array team3 = new Team_Array("Delhi_NewZealand");
    Team_Array team4 = new Team_Array("RoyalChallengers_Bangladesh");
    Team_Array team5 = new Team_Array("Rajastan_Australia");
    Team_Array team6 = new Team_Array("Kolkata_England");
    Team_Array team7 = new Team_Array("Punjab_Pakistan");
    Team_Array team8 = new Team_Array("Sunrisers_SriLanka");

    //        Assigning teams to the groups
    Team_Array[] Group_A = { team1,team2,team3,team4 };
    Team_Array[] Group_B = { team5,team6,team7,team8 };

    Helper cricket_helper = new Helper();

    ArrayList<Batsman> batsmanList = new ArrayList();
    ArrayList<Bowler> bowlerList = new ArrayList();





    @FXML
    private Button start_button;
    @FXML
    private Button mainMenu;
    @FXML
    public Button exitButton;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label T1;
    @FXML
    private Label T2;
    @FXML
    private Label total1;
    @FXML
    private Label wickets1;
    @FXML
    private Label overs1;
    @FXML
    private Label total2;
    @FXML
    private Label wickets2;
    @FXML
    private Label overs2;
    @FXML
    private Button seeMoreTeam1;
    @FXML
    private Button seeMoreTeam2;
    @FXML
    private Button playerStandings;
//    @FXML
//    private Button seeMoreTeam2;


    public Controller() throws IOException {
    }
//    @FXML
//    private Button GroupA;
//    @FXML
//    private Button GroupB;
//    @FXML
//    private Button leagueStart;
//    @FXML
//    private Button Exit;
//    @FXML
//    private Button colombo;
//    @FXML
//    private Button kandy;
//    @FXML
//    private Button galle;
//    @FXML
//    private Button jaffna;
//    @FXML
//    private Label player1;
//    @FXML
//    private Button show;
//    @FXML
//    private Button edit;
//    @FXML
//    private Button refresh;
//    @FXML
//    private Button apply;
//    @FXML
//    private Button back2;
//    @FXML
//    private TextField text1;
//    @FXML
//    private TextField text_no1;



    public void firstLayout() throws IOException {
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("intro.fxml"));
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    public void exit(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void secondLayout() throws IOException {
        Stage stage = (Stage) start_button.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("match.fxml"));
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    public void showPlayerStandings() throws IOException
    {
        Stage stage = (Stage) playerStandings.getScene().getWindow();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("playerStanding.fxml"));
        primaryStage.setTitle("Group A Matches");
        primaryStage.setScene(new Scene(root, 900, 650));
        primaryStage.show();
    }

    public void seeMore1() throws IOException {
        Stage stage = (Stage) seeMoreTeam1.getScene().getWindow();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("matchMoreInfoTeam1.fxml"));
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 1100, 650));
        primaryStage.show();
    }

    public void seeMore2() throws IOException {
        Stage stage = (Stage) seeMoreTeam2.getScene().getWindow();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("matchMoreInfoTeam2.fxml"));
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 1100, 650));
        primaryStage.show();
    }



    public void startMatch() throws IOException, InvalidFormatException {


        //        Generating a match between two teams
        ArrayList<Team_Array> the_match = cricket_helper.get_random_match(Group_A,Group_B);

        Team_Array Team1 = the_match.get(0);
        Team_Array Team2 = the_match.get(1);
        lb1.setText(Team1.getTeamName().replace('_', ' ')+" vs "+Team2.getTeamName().replace('_', ' '));



        //        Tossing the coin
        List<Team_Array> tossOutcome = cricket_helper.toss_coin(the_match);
        String[] toss_outcome = new String[2];

        Team_Array visiting_team = the_match.get(0);
        Team_Array home_team = the_match.get(1);

        List<String> coin = Arrays.asList("heads", "tails");
        List<String> selection = Arrays.asList("heads", "tails");
        List<String> options = Arrays.asList("bowl", "bat");

        Collections.shuffle(coin);
        Collections.shuffle(selection);
        Collections.shuffle(options);

        if(selection.get(0).equals(coin.get(0))){
            toss_outcome[0] = visiting_team.getTeamName();
            toss_outcome[1] = options.get(0);
            lb2.setText(toss_outcome[0].replace('_', ' ')+" won the toss and choose to "+options.get(0));
        }
        else {
            toss_outcome[0] = home_team.getTeamName();
            toss_outcome[1] = options.get(1);
            lb2.setText(toss_outcome[0].replace('_', ' ')+" won the toss and choose to "+options.get(1));
        }




        //        start first innings
        First_Innings firstInnings = new First_Innings(tossOutcome);
        firstInnings.playFirstInnings();
        total1.setText(String.valueOf(firstInnings.getFirst_ing_total()));
        wickets1.setText(String.valueOf(firstInnings.getFirst_ing_wickets()));
        overs1.setText(String.valueOf((firstInnings.getFirst_ing_balls()-1)/6+"."+(firstInnings.getFirst_ing_balls()-1)%6));

        //        start second innings
        Second_Innings secondInnings = new Second_Innings(tossOutcome);
        secondInnings.playSecondInnings(firstInnings.Total1);
        total2.setText(String.valueOf(secondInnings.getSecond_ing_total()));
        wickets2.setText(String.valueOf(secondInnings.getSecond_ing_wickets()));
        overs2.setText(String.valueOf((secondInnings.getSecond_ing_balls()-1)/6+"."+(secondInnings.getSecond_ing_balls()-1)%6));


        //        setting names of the two teams to d GUI
        T1.setText(firstInnings.getBattingInfo().getTeamName().replace('_', ' '));
        T2.setText(firstInnings.getBowlingInfo().getTeamName().replace('_', ' '));



        //        InningsSummary
        InningsSummary firstInningsSummary = new InningsSummary(){{
            setBattingTeamName(firstInnings.getBattingInfo().getTeamName());
            setBowlingTeamName(firstInnings.getBowlingInfo().getTeamName());
            setTotalRuns(firstInnings.getFirst_ing_total());
        }};

        InningsSummary secondInningsSummary = new InningsSummary(){{
            setBattingTeamName(secondInnings.getBattingInfo().getTeamName());
            setBowlingTeamName(secondInnings.getBowlingInfo().getTeamName());
            setWickets(secondInnings.getSecond_ing_wickets());
            setTotalRuns(secondInnings.getSecond_ing_total());
        }};


        //        match summary
        match_summary matchSummary = new match_summary();
        matchSummary.matchSummary(firstInningsSummary,secondInningsSummary);


        if (secondInningsSummary.getTotalRuns() > firstInningsSummary.getTotalRuns()) {
            String match_result = secondInningsSummary.getBattingTeamName().replace('_', ' ') + " Won by " + (firstInningsSummary.getTOTAL_WICKETS() - secondInningsSummary.getWickets()) + " wickets";
            lb3.setText(match_result);

            /**
            winning_team = team_to_bowl
            losing_team = team_to_bat
            **/
        }
        else if (secondInningsSummary.getTotalRuns() < firstInningsSummary.getTotalRuns()) {
            String match_result = secondInningsSummary.getBowlingTeamName().replace('_', ' ') + " Won by " + (firstInningsSummary.getTotalRuns() - secondInningsSummary.getTotalRuns()) + " runs";
            lb3.setText(match_result);

            /**
            winning_team = team_to_bat
            losing_team = team_to_bowl
            **/
        }


//        display player playerStandings
        Excel_Utility eu = new Excel_Utility();
        eu.displayPlayerStanding();


    }


}