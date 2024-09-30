package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.student.Student;
import org.example.university.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class DataReader {

    public DataReader() {}

    public static List<Student> readStudents(String file) throws IOException {
        List<Student> students = new ArrayList<>();
        Logger logger = Logger.getLogger(DataReader.class.getName());
        logger.info("readStudents method");

        try{
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
        }catch (IOException e){
            logger.severe("ERROR READ FILE: " + e.getMessage() );
        }
        return students;
    }
    public static List<University> readUnivercity (String file) throws IOException{
        List<University> university = new ArrayList<>();
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
            StudyProfile mainProfile =StudyProfile.valueOf(row.getCell(4).getStringCellValue());
            university.add(new University(universityCode, fullName, shortName,yearsOfFoundation, mainProfile));
        }
    return university;
    }
}
