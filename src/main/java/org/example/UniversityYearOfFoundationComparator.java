package org.example;

import java.util.Comparator;

public class UniversityYearOfFoundationComparator implements Comparator<Univercity> {
    @Override
    public int compare(Univercity o1, Univercity o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
