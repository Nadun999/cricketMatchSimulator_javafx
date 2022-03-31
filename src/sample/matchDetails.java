package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class matchDetails {

    @FXML
    private Label batsman1;
    @FXML
    private Label batsman2;
    @FXML
    private Label batsman3;
    @FXML
    private Label batsman4;
    @FXML
    private Label batsman5;
    @FXML
    private Label batsman6;
    @FXML
    private Label batsman7;
    @FXML
    private Label batsman8;
    @FXML
    private Label batsman9;
    @FXML
    private Label batsman10;
    @FXML
    private Label batsman11;
    @FXML
    private Label batsman12;
    @FXML
    private Label batsman13;
    @FXML
    private Label batsman14;
    @FXML
    private Label batsman15;
    @FXML
    private Label batsman16;
    @FXML
    private Label batsman17;
    @FXML
    private Label batsman18;
    @FXML
    private Label batsman19;
    @FXML
    private Label batsman20;
    @FXML
    private Label batsman21;
    @FXML
    private Label batsman22;
    @FXML
    private Label bowler1;
    @FXML
    private Label bowler2;
    @FXML
    private Label bowler3;
    @FXML
    private Label bowler4;
    @FXML
    private Label bowler5;
    @FXML
    private Label bowler6;
    @FXML
    private Label bowler7;
    @FXML
    private Label bowler8;
    @FXML
    private Label bowler9;
    @FXML
    private Label bowler10;


    public void showMatchSummary1() throws FileNotFoundException {

        ArrayList<String> players_names = new ArrayList<String>();
        File new_obj = new File("src/txt2/firstBattingCard.txt");
        Scanner sc = new Scanner(new_obj);

        while (sc.hasNextLine()) {
            String names = sc.nextLine();
            players_names.add(names);
        }
        sc.close();


        ArrayList<String> players_names1 = new ArrayList<String>();
        File new_obj1 = new File("src/txt2/firstBowlingCard.txt");
        Scanner sc1 = new Scanner(new_obj1);
        while (sc1.hasNextLine()) {
            String names = sc1.nextLine();
            players_names1.add(names);
        }

        sc.close();

        batsman1.setText(players_names.get(0));
        batsman2.setText(players_names.get(1));
        batsman3.setText(players_names.get(2));
        batsman4.setText(players_names.get(3));
        batsman5.setText(players_names.get(4));
        batsman6.setText(players_names.get(5));
        batsman7.setText(players_names.get(6));
        batsman8.setText(players_names.get(7));
        batsman9.setText(players_names.get(8));
        batsman10.setText(players_names.get(9));
        batsman11.setText(players_names.get(10));

        bowler1.setText(players_names1.get(0));
        bowler2.setText(players_names1.get(1));
        bowler3.setText(players_names1.get(2));
        bowler4.setText(players_names1.get(3));
        bowler5.setText(players_names1.get(4));

    }


    public void showMatchSummary2() throws IOException {

        ArrayList<String> players_names = new ArrayList<String>();
        File new_obj = new File("src/txt2/secondBattingCard.txt");
        Scanner sc = new Scanner(new_obj);
        while (sc.hasNextLine()) {
            String names = sc.nextLine();
            players_names.add(names);
        }

        ArrayList<String> players_names1 = new ArrayList<String>();
        File new_obj1 = new File("src/txt2/secondBowlingCard.txt");
        Scanner sc1 = new Scanner(new_obj1);
        while (sc1.hasNextLine()) {
            String names = sc1.nextLine();
            players_names1.add(names);
        }
        sc.close();

        batsman12.setText(players_names.get(0));
        batsman13.setText(players_names.get(1));
        batsman14.setText(players_names.get(2));
        batsman15.setText(players_names.get(3));
        batsman16.setText(players_names.get(4));
        batsman17.setText(players_names.get(5));
        batsman18.setText(players_names.get(6));
        batsman19.setText(players_names.get(7));
        batsman20.setText(players_names.get(8));
        batsman21.setText(players_names.get(9));
        batsman22.setText(players_names.get(10));

        bowler6.setText(players_names1.get(0));
        bowler7.setText(players_names1.get(1));
        bowler8.setText(players_names1.get(2));
        bowler9.setText(players_names1.get(3));
        bowler10.setText(players_names1.get(4));

    }

}
