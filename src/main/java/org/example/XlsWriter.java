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



        FileOutputStream fileOut = new FileOutputStream(pathFile);

            workbook.write(fileOut);
            workbook.close();

        }

    }


