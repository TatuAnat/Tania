package org.example;

import java.util.Comparator;

public class ComparatorUtils {

    private ComparatorUtils(){
        // ! new ComparatorUtils()
    }


    public static Comparator<Student> getStudentComparator(StudentComparatorTypeEnum type){
        return switch (type) {
            case avgScore -> new StudentAvgExamScoreComparator();
            case avgScoreDesc -> new StudentAvgExamScoreDescComparator();
            case fullName -> new StudentFullnameComparator();

        };
    }
    public static Comparator <Univercity> getUniversityComparator (UniversityComparatorTypeEnum type1){
        switch (type1){
            case fullName:
                return  new UniversityFullNameComparator();
            case yearOfFoundation:
                return new UniversityYearOfFoundationComparator();
            case YearOfFoundationDesc:
                return new UniversityYearOfFoundationDescComparator();
            default:
                throw new IllegalArgumentException("...");
        }

    }
}

