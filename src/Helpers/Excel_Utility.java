package Helpers;

import Models.Batsman;
import Models.Bowler;
import Models.Team_Array;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class Excel_Utility {

    private static XSSFWorkbook wb;
    private static XSSFSheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;
    private ArrayList<String> pointsTableArray = new ArrayList<>();

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
    private Label pTeam1;
    @FXML
    private Label pTeam2;
    @FXML
    private Label pTeam3;
    @FXML
    private Label pTeam4;
    @FXML
    private Label pTeam5;
    @FXML
    private Label pTeam6;
    @FXML
    private Label pTeam7;
    @FXML
    private Label pTeam8;


    public Excel_Utility() throws IOException {
    }

    public ArrayList<Batsman> getBattingTeamFromExcel(String teamName, boolean isBattingTeam) throws IOException {

        Team_Array temp = new Team_Array(teamName);
        ArrayList<Batsman> battingTeam = new ArrayList<>();

        File excelFile = new File(String.valueOf(temp.getTeamPath()));
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);
        Iterator<Row> row = sh.iterator();

        int cellCount = sh.getRow(1).getLastCellNum();
        int rowCount = sh.getLastRowNum();

        for (int i = 1; i < rowCount + 1; i++) {

            Batsman batsman = new Batsman();

            Row header = sh.getRow(i);
            int n = header.getLastCellNum();
            batsman.setName(header.getCell(0).getStringCellValue());
            batsman.setBattingOrder(i);
            battingTeam.add(batsman);
        }
        wb.close();
        fis.close();
        return battingTeam;
    }

    public ArrayList<Bowler> getBowlingTeamFromExcel(String teamName, boolean isBowlingTeam) throws IOException {

        Team_Array temp = new Team_Array(teamName);
        ArrayList<Bowler> bowlingTeam = new ArrayList<>();

        File excelFile = new File(String.valueOf(temp.getTeamPath()));
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);
        Iterator<Row> row = sh.iterator();

        int cellCount = sh.getRow(1).getLastCellNum();
        int rowCount = sh.getLastRowNum();

        for (int i = 1; i < rowCount+1; i++) {

            Bowler bowler = new Bowler();

            Row header = sh.getRow(i);
            int n = header.getLastCellNum();
            bowler.setName(header.getCell(0).getStringCellValue()) ;
            bowlingTeam.add(bowler);
        }
        wb.close();
        fis.close();
        return bowlingTeam;
    }


    public void playerStandingWriteExcel(ArrayList<Batsman> batting,ArrayList<Bowler> bowling ,boolean isBatsman) throws IOException, InvalidFormatException {

        fis = new FileInputStream(("src/PlayerStanding/player_standings.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");
        int noOfRows = sh.getLastRowNum();

        if (isBatsman){
            for(Batsman player: batting){
                playerStandingFindBatsmanRow(sh,player);
            }
        }else {
            for(Bowler player: bowling){
                playerStandingFindBowlerRow(sh,player);
            }

        }
    }

    private static void playerStandingFindBatsmanRow(XSSFSheet sheet, Batsman cellContent) throws IOException {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent.getName())) {
                        int currentBatsmanRuns = (int) row.getCell(1).getNumericCellValue();
                        currentBatsmanRuns+= cellContent.getRuns();
                        row.getCell(1).setCellValue(currentBatsmanRuns);
                        fos = new FileOutputStream("src/PlayerStanding/player_standings.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                    }
                }
            }
        }
    }

    private static void playerStandingFindBowlerRow(XSSFSheet sheet, Bowler cellContent) throws IOException {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent.getName())) {
                        int currentBowlerWickets = (int) row.getCell(2).getNumericCellValue();
                        currentBowlerWickets+= cellContent.getWickets();
                        row.getCell(2).setCellValue(currentBowlerWickets);
                        fos = new FileOutputStream("src/PlayerStanding/player_standings.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                    }
                }
            }
        }
    }

    public void displayPlayerStanding() throws IOException, InvalidFormatException {

        fis = new FileInputStream(("src/PlayerStanding/player_standings.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");
        int noOfRows = sh.getLastRowNum();
        ArrayList<Batsman> topBatsmen = new ArrayList<>();
        ArrayList<Bowler> topBowler = new ArrayList<>();

        for (Row row : sh) {
            if(row.getRowNum() != 0){
                for (Cell cell : row) {
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        Batsman currentBatsman = new Batsman();
                        Bowler currentBowler = new Bowler();

                        currentBatsman.setName(row.getCell(0).toString());
                        currentBowler.setName(row.getCell(0).toString());
                        currentBatsman.setRuns((int)row.getCell(1).getNumericCellValue());
                        currentBowler.setWickets((int)row.getCell(2).getNumericCellValue());

                        topBatsmen.add(currentBatsman);
                        topBowler.add(currentBowler);
                    }
                }
            }
        }

        //sort batsman runs to descending order
        Collections.sort(topBatsmen,(o1, o2) -> o2.getIntegerRuns().compareTo(o1.getIntegerRuns()));

        //sort bowler wickets to descending order
        Collections.sort(topBowler,(o1, o2) -> o2.getIntegerWickets().compareTo(o1.getIntegerWickets()));

        //writing batsman player standings into text file to display
        try{
            File myFile = new File("src/PlayerStanding/topBatsman.txt");
            PrintStream writer = new PrintStream(myFile);

            for(int i = 0; i < 5; i++) {
                writer.print(topBatsmen.get(i).getName()+" "+topBatsmen.get(i).getRuns()+ System.lineSeparator());
            }
            writer.close();
        } catch(FileNotFoundException fnf) {
            System.out.println(fnf+"file not found");
        }

        //writing bowler player standings into text file to display
        try{
            File myFile1 = new File("src/PlayerStanding/topBowler.txt");
            PrintStream writer1 = new PrintStream(myFile1);

            for(int i = 0; i < 5; i++) {
                writer1.print(topBowler.get(i).getName()+" "+topBowler.get(i).getWickets()+ System.lineSeparator());
            }
            writer1.close();
        } catch(FileNotFoundException fnf) {
            System.out.println(fnf+"file not found");
        }
    }


    public void updatePointsTable(String teamName,boolean isWon) throws IOException, InvalidFormatException {

        fis = new FileInputStream(("src/PointsTable/points_table.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");

        for (Row row : sh) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(teamName)) {

                        int currentMatchCount = (int) row.getCell(1).getNumericCellValue();
                        int currentMatchWins = (int) row.getCell(2).getNumericCellValue();
                        int currentMatchLooseCount = (int) row.getCell(3).getNumericCellValue();
                        int currentPoints = (int) row.getCell(4).getNumericCellValue();

                        if (isWon){
                            currentMatchCount=currentMatchCount+1;
                            currentMatchWins=currentMatchWins+1;
                            currentPoints= currentPoints+2;

                            row.getCell(1).setCellValue(currentMatchCount);
                            row.getCell(2).setCellValue(currentMatchWins);
                            row.getCell(4).setCellValue(currentPoints);
                        }
                        if (!isWon){
                            currentMatchCount=currentMatchCount+1;
                            currentMatchLooseCount=currentMatchLooseCount+1;

                            row.getCell(1).setCellValue(currentMatchCount);
                            row.getCell(3).setCellValue(currentMatchLooseCount);
                        }

                        fos = new FileOutputStream("src/PointsTable/points_table.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                    }
                }
            }
        }
    }

    public void writePointsTable() throws IOException, InvalidFormatException {
        fis = new FileInputStream(("src/PointsTable/points_table.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");

        for (Row row : sh) {
            if (row.getRowNum() == 0 || row.getRowNum() == 5) {
                pointsTableArray.add(row.getCell(0).toString() + "  " + row.getCell(1).toString() + " " + row.getCell(2).toString() + "  " + row.getCell(3).toString() + "  " + row.getCell(3).toString() + "  " + row.getCell(4).toString());
            } else {
                pointsTableArray.add(row.getCell(0).toString() + "                 " + (int) (row.getCell(1).getNumericCellValue()) + "                 " + (int) (row.getCell(2).getNumericCellValue()) + "                 " + (int) (row.getCell(3).getNumericCellValue()) + "                 " + (int) (row.getCell(4).getNumericCellValue()));
            }
        }

        try{
            File myFile = new File("src/PointsTable/points_table.txt");
            PrintStream writer = new PrintStream(myFile);

            for(int i=0;i<pointsTableArray.size();i++) {
                writer.print(pointsTableArray.get(i)+System.lineSeparator());
            }
            writer.close();
        } catch(FileNotFoundException fnf) {
            System.out.println(fnf+"file not found");
        }


    }

    public void displayPointsTable() throws IOException, InvalidFormatException {


        ArrayList<String> pointsTable = new ArrayList<String>();
        File new_obj1 = new File("src/PointsTable/points_table.txt");
        Scanner sc = new Scanner(new_obj1);
        while (sc.hasNextLine()) {
            String names = sc.nextLine();
            pointsTable.add(names);
        }
        sc.close();

        pTeam1.setText(pointsTable.get(1));
        pTeam2.setText(pointsTable.get(2));
        pTeam3.setText(pointsTable.get(3));
        pTeam4.setText(pointsTable.get(4));

        pTeam5.setText(pointsTable.get(6));
        pTeam6.setText(pointsTable.get(7));
        pTeam7.setText(pointsTable.get(8));
        pTeam8.setText(pointsTable.get(9));
    }
}