package team_data;

import Models.Batsman;
import Models.Bowler;
import Models.Team_Array;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class teamProfileEditMumbai {

    private String currentTeamName;

    private static XSSFWorkbook wb;
    private static XSSFSheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;
    ArrayList<Batsman> topBatsmen = new ArrayList<>();
    ArrayList<String> players_names = new ArrayList<String>();
    String CurrentPlayerName;

    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private Label player3;
    @FXML
    private Label player4;
    @FXML
    private Label player5;
    @FXML
    private Label player6;
    @FXML
    private Label player7;
    @FXML
    private Label player8;
    @FXML
    private Label player9;
    @FXML
    private Label player10;
    @FXML
    private Label player11;
    @FXML
    private Button show;
    @FXML
    private Button back2;
    @FXML
    private Button edit;
    @FXML
    private TextField text_no1;
    @FXML
    private TextField text1;
    @FXML
    private Button refresh;



    public void players_name() throws IOException, InvalidFormatException {

        File new_obj = new File("src/team_data/CurrentTeam.txt");
        Scanner sc = new Scanner(new_obj);
        String CurrentTeamName = sc.nextLine();
        sc.close();



        fis = new FileInputStream(("src/team_data/"+CurrentTeamName+"/"+CurrentTeamName+".xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");

        for (Row row : sh) {
            for (Cell cell : row) {
                if(row.getRowNum() != 0 && cell.getColumnIndex() == 0){
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        Batsman currentBatsman = new Batsman();

                        currentBatsman.setName(cell.getRichStringCellValue().getString().trim());

                        topBatsmen.add(currentBatsman);
                        players_names.add(currentBatsman.getName());
                    }
                }
            }
        }

        player1.setText(players_names.get(0));
        player2.setText(players_names.get(1));
        player3.setText(players_names.get(2));
        player4.setText(players_names.get(3));
        player5.setText(players_names.get(4));
        player6.setText(players_names.get(5));
        player7.setText(players_names.get(6));
        player8.setText(players_names.get(7));
        player9.setText(players_names.get(8));
        player10.setText(players_names.get(9));
        player11.setText(players_names.get(10));

    }

    public void Edit() throws IOException, InvalidFormatException {

        File new_obj = new File("src/team_data/CurrentTeam.txt");
        Scanner sc = new Scanner(new_obj);
        String CurrentTeamName = sc.nextLine();
        sc.close();

        for (int i = 0; i < 11; i++) {
            if(text_no1.getText().equals(Integer.toString(i+1))) {
                players_names.set(i,text1.getText());
            }
        }

        player1.setText(players_names.get(0));
        player2.setText(players_names.get(1));
        player3.setText(players_names.get(2));
        player4.setText(players_names.get(3));
        player5.setText(players_names.get(4));
        player6.setText(players_names.get(5));
        player7.setText(players_names.get(6));
        player8.setText(players_names.get(7));
        player9.setText(players_names.get(8));
        player10.setText(players_names.get(9));
        player11.setText(players_names.get(10));

        //updATE EXCEL
        fis = new FileInputStream(("src/team_data/"+CurrentTeamName+"/"+CurrentTeamName+".xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");
        int noOfRows = sh.getLastRowNum();
        int indexToUpdate = Integer.parseInt(text_no1.getText());

        for (Row row : sh) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getColumnIndex() == 0) {
                    if (cell.getRowIndex() == indexToUpdate) {

                        CurrentPlayerName = row.getCell(0).getStringCellValue();

                        row.getCell(0).setCellValue(text1.getText());
                        fos = new FileOutputStream("src/team_data/Mumbai_India/Mumbai_India.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                        System.out.println("Done");
                    }
                }
            }
        }
//        System.out.println(CurrentPlayerName+"   CurrentPlayerName");
        updatePlayerNameInPlayerStanding(CurrentPlayerName,text1.getText());
    }

    public void updatePlayerNameInPlayerStanding(String CurrentPlayerName,String editedName) throws IOException, InvalidFormatException {
        fis = new FileInputStream(("src/PlayerStanding/player_standings.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");
        int noOfRows = sh.getLastRowNum();

        for (Row row : sh) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(CurrentPlayerName)) {

                        row.getCell(0).setCellValue(editedName);
                        fos = new FileOutputStream("src/PlayerStanding/player_standings.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                        System.out.println("Done player standing");
                    }
                }
            }
        }

    }

    public void backToTeams() throws IOException
    {
        ArrayList<String> players_names3 = new ArrayList<String>();
        File new_obj = new File("src/txt/colombo.txt");
        Scanner sc = new Scanner(new_obj);
        while (sc.hasNextLine())
        {
            String names = sc.nextLine();
            players_names3.add(names);

        }
        sc.close();
        if (players_names3.contains(""))
        {
            Stage stage = (Stage) back2.getScene().getWindow();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("error_msg.fxml"));
            primaryStage.setTitle("Colombo Team");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        }
        else
        {
            Stage stage = (Stage) back2.getScene().getWindow();
            Stage primaryStage = new Stage();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("GroupA_teams.fxml"));
            primaryStage.setTitle("Group A Teams");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        }
    }


}
