package org.example;

import org.example.Student;

import java.util.Comparator;

public class StudentAvgExamScoreDescComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
