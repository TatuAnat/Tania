package org.example.university;

import org.example.university.University;

import java.util.Comparator;

public class UniversityYearOfFoundationDescComparator implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o2.getYearOfFoundation(), o1.getYearOfFoundation());
    }
}