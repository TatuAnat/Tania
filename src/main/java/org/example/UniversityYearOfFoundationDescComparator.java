package org.example;

import java.util.Comparator;

public class UniversityYearOfFoundationDescComparator implements Comparator<Univercity> {

    @Override
    public int compare(Univercity o1, Univercity o2) {
        return Integer.compare(o2.getYearOfFoundation(), o1.getYearOfFoundation());
    }
}
