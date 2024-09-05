package org.example.student;

import org.example.student.Student;

import java.util.Comparator;

public class StudentAvgExamScoreComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }
}
