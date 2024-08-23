package org.example;

import java.util.Comparator;

public class UniversityYearOfFoundationComparator implements Comparator<University> {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
