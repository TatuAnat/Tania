import org.example.StudyProfile;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ivanov Ivan", "Id123456", 1,5.0f);
    Student student1 = new Student ("Petr Petrov" , "Id689411", 2, 4.0f);
        System.out.println(student1.fullName);
        System.out.println(student.universityId);
        Univercity univercity = new Univercity("Id123456", "Hogward", "HW", 1865, StudyProfile.History);
        Univercity univercity1 = new Univercity("Id689411", "Smolvile", "SM", 1864, StudyProfile.Architecture);
        System.out.println(univercity.fullName);
        System.out.println(univercity1.yearOfFoundation);
    }

}
