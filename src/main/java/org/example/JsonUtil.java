package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.student.Student;
import org.example.university.University;

import java.util.List;


public class JsonUtil  {
    private JsonUtil(){
    }
    public static String serializeObject(Object student){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(student);
    }
    public static String serializeStudent(Student student){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(student);
    }
public static String serializeUniversity(University university){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(university);
}
    public static String serializeListObjects(List<Object> studentList){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(studentList);
    }
    public static String serializeListStudents(List<Student> studentList){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(studentList);
    }
public static String serializeListUniversities(List<University> universityList){
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(universityList);
}
    public static Student deserializeStudent(String studentJson){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(studentJson, Student.class);
    }
    public static List deserializeStudentList(String studentListJson){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(studentListJson, List.class);
    }

public static University deserializeUniversity(String universityJson){

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.fromJson(universityJson, University.class);
}

public static  List <University> deserializeUnivercityList(String universityListJson){
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.fromJson(universityListJson, List.class);
}


    public enum UniversityComparatorTypeEnum {
        fullName,
        yearOfFoundation,
        YearOfFoundationDesc



    }
}