package org.example.university;

import org.apache.commons.lang3.StringUtils;
import org.example.university.University;

import java.util.Comparator;

public class UniversityFullNameComparator implements Comparator <University> {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.fullName, o2.fullName);
    }
}