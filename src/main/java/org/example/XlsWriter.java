package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    private XlsWriter(){

    }

    public static void writeStatisticsToExcel(List<Statistics> statisticsList, String pathFile){

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Statistics");

        String[] headers = {"Profile", "Avg. Score", "Num. Students", "Num. Universities", "University names"};


        Row headerRow = sheet.createRow(0);


        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        headerStyle.setFont(font);

        for (int i = 0; i < headers.length; i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        for(int i = 0; i< statisticsList.size(); i++){
            Statistics statistics = statisticsList.get(i);
            Row statisticsRow = sheet.createRow(i+1);
            Cell cellProfile = statisticsRow.createCell(0);
            cellProfile.setCellValue(statistics.getProfile());
            Cell cellAvgScore = statisticsRow.createCell(1);
           cellAvgScore .setCellValue(statistics.getAverageExamScore());
            Cell cellNumStudents = statisticsRow.createCell(2);
            cellNumStudents.setCellValue(statistics.getNumberOfStudents());
            Cell cellNumUniversities = statisticsRow.createCell(3);
            cellNumUniversities.setCellValue(statistics.getNumberOfUniversities());
            Cell cellUniversityNames = statisticsRow.createCell(4);
            cellUniversityNames.setCellValue(statistics.getUniversityNames().toString());
        }



      try  (FileOutputStream fileOut = new FileOutputStream(pathFile)) {

          workbook.write(fileOut);
      }catch (IOException e){
          System.out.println(e.getMessage());
      }
      try {


          workbook.close();
      } catch (IOException e){
          System.out.println(e.getMessage());
      }

        }

    }


