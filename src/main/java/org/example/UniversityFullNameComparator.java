package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class UniversityFullNameComparator implements Comparator <Univercity> {

    @Override
    public int compare(Univercity o1, Univercity o2) {
        return StringUtils.compare(o1.fullName, o2.fullName);
    }
}
