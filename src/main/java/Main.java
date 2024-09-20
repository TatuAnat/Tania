import org.example.*;
import org.example.student.Student;
import org.example.student.StudentComparatorTypeEnum;
import org.example.university.University;
import org.example.university.UniversityComparatorTypeEnum;

import java.io.IOException;

import java.util.Comparator;
import java.util.List;
import java.util.logging.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Main.class.getName());

        try{
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));

        }catch (IOException e){
        logger.severe("ERROR LOG MANAGER CONF: "+ e.getMessage());
        }
        
        logger.severe("tania log");

        String path = "C:\\Users\\hp\\Test\\project\\src\\main\\resources\\universityInfo.xlsx";
        String pathStatistics = "C:\\Users\\hp\\Test\\project\\src\\main\\resources\\statistics.xlsx";
        String directoryXml = "C:\\Users\\hp\\Test\\project\\src\\main\\resources\\xml";
        String directoryJSON = "C:\\Users\\hp\\Test\\project\\src\\main\\resources\\json";
        Comparator<Student> studentComparator = ComparatorUtils.getStudentComparator(StudentComparatorTypeEnum.avgScore);
        Comparator<University> univercityComparator = ComparatorUtils.getUniversityComparator((UniversityComparatorTypeEnum.yearOfFoundation));

        logger.info("start read students from " + path);
        List<Student> students = DataReader.readStudents(path);
        logger.info("finish read students from " + path);
        List<Student> sortedStudents = students
                .stream()
                .sorted(studentComparator)
                .toList();



        List<University> universities = DataReader.readUnivercity(path);
        List<University> sortedUniversities = universities
                .stream()
                .sorted(univercityComparator)
                .toList();


        for (Student student : students) {
            ////System.out.println(student.toString());
        }


        for (Student student : sortedStudents) {
            ////System.out.println(student.toString());
        }


        for (University university : universities) {
            ////System.out.println(university.toString());
        }


        for (University university : sortedUniversities) {
            ////System.out.println(university.toString());


        }


        Student oneStudent = students.get(0);

        try{
            XMLWriter.writeToXml(oneStudent, directoryXml);
        } catch (Exception e){
            logger.severe("ERROR write XML: " +e.getMessage());
        }
        try{
            JsonWriter.writeToJson(oneStudent, directoryJSON);
        } catch (Exception e){
            logger.severe("ERROR write JSON: " +e.getMessage());
        }


        String oneStudentJson = JsonUtil.serializeStudent(oneStudent);

        ////System.out.println(oneStudentJson);

        String studentListJson = JsonUtil.serializeListStudents(students);


        Student oneStudentDeserialized = JsonUtil.deserializeStudent(oneStudentJson);


        List<Student> listStudentDeserialized = JsonUtil.deserializeStudentList(studentListJson);

/*
        students.stream()
                .map(org.example.JsonUtil::serializeStudent)
                .forEach(System.out::println)
        ;
*/
        ////System.out.println(oneStudentDeserialized);
        ////System.out.println(listStudentDeserialized);
        for (int i = 0; i < listStudentDeserialized.size(); i++) {
            ////System.out.println(listStudentDeserialized.get(i));
        }


        University oneUniversity = universities.get(0);
        String oneUniversityJson = JsonUtil.serializeUniversity(oneUniversity);
        ////System.out.println(oneUniversityJson);
        String universityListJson = JsonUtil.serializeListUniversities(universities);
        ////System.out.println(universityListJson);
        University oneUniversityDeserialized = JsonUtil.deserializeUniversity(oneUniversityJson);
        ////System.out.println(oneUniversityDeserialized);

        List<University> listUniversityDeserialized = JsonUtil.deserializeUnivercityList(universityListJson);
        for (int i = 0; i < listUniversityDeserialized.size(); i++) {
            ////System.out.println(listUniversityDeserialized.get(i));

        }
       /* universities.stream()
                .map(org.example.JsonUtil::serializeUniversity)
                .forEach(System.out::println);*/


        StatisticsUtils statisticsUtils = new StatisticsUtils();
        List<Statistics> statisticsList = statisticsUtils.generateStatistics(students, universities);

        XlsWriter.writeStatisticsToExcel(statisticsList, pathStatistics);
    }
}
