package org.example;

import org.apache.commons.lang3.StringUtils;
import org.example.Student;

import java.util.Comparator;

public class StudentFullnameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o2.getFullName(), o1.getFullName());
    }
}
