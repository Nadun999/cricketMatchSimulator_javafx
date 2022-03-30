package Helpers;

import Models.Batsman;
import Models.Bowler;
import Models.Team_Array;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class Excel_Utility {

    private static XSSFWorkbook wb;
    private static XSSFSheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;


    public Excel_Utility() throws IOException {
    }

//        String xx = sh.getRow(1).getCell(0).getStringCellValue();


    public ArrayList<Batsman> getBattingTeamFromExcel(String teamName, boolean isBattingTeam) throws IOException {

        Team_Array temp = new Team_Array(teamName);
        ArrayList<Batsman> battingTeam = new ArrayList<>();


        File excelFile = new File(String.valueOf(temp.getTeamPath()));
        FileInputStream fis = new FileInputStream(excelFile);


        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);
        Iterator<Row> row = sh.iterator();

//        System.out.println(sh.getRow(1).getCell(0).toString() );
//        System.out.println(sh.getRow(0).getLastCellNum());
//        System.out.println(sh.getLastRowNum());
        int cellCount = sh.getRow(1).getLastCellNum();
        int rowCount = sh.getLastRowNum();


        for (int i = 1; i < rowCount + 1; i++) {

            Batsman batsman = new Batsman();

            Row header = sh.getRow(i);
            int n = header.getLastCellNum();
            batsman.name = header.getCell(0).getStringCellValue();
            batsman.battingOrder = i;
//                batsman.battingOrder = Integer.parseInt(String.valueOf(header.getCell(5)));
//                System.out.println(batsman.name);

            battingTeam.add(batsman);
        }


//        for (Batsman i : battingTeam) {
//            System.out.println(i.name);
//            System.out.println(i.runs);
//            System.out.println(i.balls);
//            System.out.println(i.methodOfDissmal);
//            System.out.println(i.battingOrder);
//        }


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

//        System.out.println(sh.getRow(1).getCell(0).toString() );
//        System.out.println(sh.getRow(0).getLastCellNum());
//        System.out.println(sh.getLastRowNum());
        int cellCount = sh.getRow(1).getLastCellNum();
        int rowCount = sh.getLastRowNum();


        for (int i = 1; i < rowCount+1; i++) {

            Bowler bowler = new Bowler();

            Row header = sh.getRow(i);
            int n = header.getLastCellNum();
            bowler.name = header.getCell(0).getStringCellValue();

            bowlingTeam.add(bowler);
        }


//        for(Bowler i: bowlingTeam) {
//            System.out.println(i.name);
//            System.out.println(i.overs);
//            System.out.println(i.runs);
//            System.out.println(i.wickets);
//            System.out.println(i.economy);
//        }

        wb.close();
        fis.close();

        return bowlingTeam;
    }


    public void writeExcel() throws IOException, InvalidFormatException {

        fis = new FileInputStream(("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/coursework/tournament/points_table.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");
        int noOfRows = sh.getLastRowNum();
        System.out.println(noOfRows);

//        row = sh.createRow(10);
//        cell = row.createCell(10);
//        cell.setCellValue("QAV");
//        System.out.println(cell.getStringCellValue());
//        fos = new FileOutputStream("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/coursework/tournament/points_table.xlsx");
//        wb.write(fos);
//        fos.flush();
//        fos.close();
//        System.out.println("Done");

        findRow(sh,"Mumbai_India");


    }

    private static void findRow(XSSFSheet sheet, String cellContent) throws IOException {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
//                        int currentMatchCount = Integer.parseInt(String.valueOf(row.getCell(1).getRichStringCellValue()));
                        int currentMatchCount = (int) row.getCell(1).getNumericCellValue();
                        currentMatchCount++;
                        row.getCell(1).setCellValue(currentMatchCount);
                        fos = new FileOutputStream("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/coursework/tournament/points_table.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                        System.out.println("Done");
                        //                        System.out.println(cell.getRichStringCellValue().getString()+"--------------------");
                    }
                }
            }
        }
    }

}

