package PointsTable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PointsTable {

    private static XSSFWorkbook wb;
    private static XSSFSheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;

    public void updatePointsTable(String teamName) throws IOException, InvalidFormatException {

        fis = new FileInputStream(("src/PointsTable/points_table.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");

        teamName = "Mumbai_India";

        for (Row row : sh) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(teamName)) {
//                        int currentMatchCount = Integer.parseInt(String.valueOf(row.getCell(1).getRichStringCellValue()));
                        int currentMatchCount = (int) row.getCell(1).getNumericCellValue();
                        int currentMatchWins = (int) row.getCell(2).getNumericCellValue();
                        int currentPoints = (int) row.getCell(3).getNumericCellValue();
                        currentMatchCount++;
                        currentMatchWins++;
                        currentPoints+=2;

                        row.getCell(1).setCellValue(currentMatchCount);
                        fos = new FileOutputStream("src/PointsTable/points_table.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                        System.out.println("Done");
                    }
                }
            }
        }
    }











}
