import org.example.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\hp\\Test\\project\\src\\main\\resources\\universityInfo.xlsx";
        Comparator<Student> studentComparator = ComparatorUtils.getStudentComparator(StudentComparatorTypeEnum.avgScore);
        Comparator<Univercity> univercityComparator = ComparatorUtils.getUniversityComparator((UniversityComparatorTypeEnum.yearOfFoundation));

        List<Student> students = DataReader.readStudents(path);
        List<Student> sortedStudents = students
                .stream()
                .sorted(studentComparator)
                .toList();

        List<Univercity> universities = DataReader.readUnivercity(path);
        List<Univercity> sortedUniversities = universities
                .stream()
                .sorted(univercityComparator)
                .toList();




        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println(student.toString());
        }



        for (Student student : sortedStudents) {
            System.out.println(student.toString());
        }






        for (Univercity univercity : universities) {
            System.out.println(univercity.toString());
        }




        System.out.println("Sorted list of universities:");
        for (Univercity university : sortedUniversities) {
            System.out.println(university.toString());


        }





    }
}