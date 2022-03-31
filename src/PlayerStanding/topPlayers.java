package PlayerStanding;

import Models.Batsman;
import Models.Bowler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


import java.util.Collections;

public class topPlayers {

    @FXML
    private Label topbatsman1;
    @FXML
    private Label topbatsman2;
    @FXML
    private Label topbatsman3;
    @FXML
    private Label topbatsman4;
    @FXML
    private Label topbatsman5;
    @FXML
    private Label topbowler1;
    @FXML
    private Label topbowler2;
    @FXML
    private Label topbowler3;
    @FXML
    private Label topbowler4;
    @FXML
    private Label topbowler5;
    @FXML
    private Button showD;


    public void performanceDetails() throws IOException {

        ArrayList<String> players_names = new ArrayList<String>();
        File new_obj = new File("src/PlayerStanding/topBatsman.txt");
        Scanner sc = new Scanner(new_obj);

        while (sc.hasNextLine()) {
            String names = sc.nextLine();
            players_names.add(names);
        }
        sc.close();


        ArrayList<String> players_names1 = new ArrayList<String>();
        File new_obj1 = new File("src/PlayerStanding/topBowler.txt");
        Scanner sc1 = new Scanner(new_obj1);
        while (sc1.hasNextLine()) {
            String names = sc1.nextLine();
            players_names1.add(names);
        }
        sc.close();

        topbatsman1.setText(players_names.get(0));
        topbatsman2.setText(players_names.get(1));
        topbatsman3.setText(players_names.get(2));
        topbatsman4.setText(players_names.get(3));
        topbatsman5.setText(players_names.get(4));

        topbowler1.setText(players_names1.get(0));
        topbowler2.setText(players_names1.get(1));
        topbowler3.setText(players_names1.get(2));
        topbowler4.setText(players_names1.get(3));
        topbowler5.setText(players_names1.get(4));
    }
}
