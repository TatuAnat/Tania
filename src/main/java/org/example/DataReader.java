package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Comparator;
public class DataReader {

    public DataReader() {}

    public static List<Student> readStudents(String file) throws IOException {
        List<Student> students = new ArrayList<>();


                FileInputStream f = new FileInputStream(file);
                Workbook workbook = new XSSFWorkbook(f);


            Sheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet){
                if(row.getRowNum() == 0) continue;
                String universityCode = row.getCell(0).getStringCellValue();
                String fullName = row.getCell(1).getStringCellValue();
                int currentCourseNumber = (int) row.getCell(2).getNumericCellValue();
                float getAvgExamScore = (float) row.getCell(3).getNumericCellValue();
                students.add(new Student(fullName, universityCode, currentCourseNumber,getAvgExamScore));
            }

        return students;
    }

    public static List<Univercity> readUnivercity (String file) throws IOException{
        List<Univercity> univercity = new ArrayList<>();
        FileInputStream f1 = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(f1);
        Sheet sheet = workbook.getSheetAt(1);
       Iterator<Row> iter = sheet.iterator();

       if(iter.hasNext()){
           iter.next();
       }

        while (iter.hasNext()){
            Row row = iter.next();

            String universityCode = row.getCell(0).getStringCellValue();
            String fullName = row.getCell(1).getStringCellValue();
            String shortName = row.getCell(2).getStringCellValue();
            int yearsOfFoundation = (int) row.getCell(3).getNumericCellValue();
           // StudyProfile mainProfile = (StudyProfile) row.getCell(4).getStringCellValue();

            StudyProfile mainProfile =StudyProfile.valueOf(row.getCell(4).getStringCellValue());

            univercity.add(new Univercity(universityCode, fullName, shortName,yearsOfFoundation, mainProfile));
        }
        
    return univercity;
    }
}
