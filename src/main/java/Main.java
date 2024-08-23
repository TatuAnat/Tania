import org.example.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\hp\\Test\\project\\src\\main\\resources\\universityInfo.xlsx";
        Comparator<Student> studentComparator = ComparatorUtils.getStudentComparator(StudentComparatorTypeEnum.avgScore);
        Comparator<University> univercityComparator = ComparatorUtils.getUniversityComparator((UniversityComparatorTypeEnum.yearOfFoundation));

        List<Student> students = DataReader.readStudents(path);
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
            System.out.println(student.toString());
        }


        for (Student student : sortedStudents) {
            System.out.println(student.toString());
        }


        for (University university : universities) {
            System.out.println(university.toString());
        }


        for (University university : sortedUniversities) {
            System.out.println(university.toString());


        }


        Student oneStudent = students.get(0);

        String oneStudentJson = JsonUtil.serializeStudent(oneStudent);

        System.out.println(oneStudentJson);

        String studentListJson = JsonUtil.serializeListStudents(students);


        Student oneStudentDeserialized = JsonUtil.deserializeStudent(oneStudentJson);



        List<Student> listStudentDeserialized = JsonUtil.deserializeStudentList(studentListJson);


        students.stream()
                .map(JsonUtil::serializeStudent)
                .forEach(System.out::println);


        University oneUniversity = universities.get(0);
        String oneUniversityJson = JsonUtil.serializeUniversity(oneUniversity);
        System.out.println(oneUniversityJson);
        String universityListJson = JsonUtil.serializeListUniversities(universities);
        University oneUniversityDeserialized = JsonUtil.deserializeUniversity(oneUniversityJson);
        List <University>  listOneUniversityDeserialized =JsonUtil.deserializeUnivercityList(universityListJson);
        universities.stream()
                .map(JsonUtil::serializeUniversity)
                .forEach(System.out::println);
    }
}