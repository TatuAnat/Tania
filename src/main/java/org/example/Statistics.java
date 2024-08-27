package org.example;

import java.util.List;

public class Statistics {

    private String profile;
    private double averageExamScore;
    private int numberOfStudents;
    private int numberOfUniversities;

    private List<String> universityNames;

    public Statistics(String profile, double averageExamScore, int numberOfStudents, int numberOfUniversities, List<String> universityNames){
        this.profile = profile;
        this.averageExamScore = averageExamScore;
        this.numberOfStudents = numberOfStudents;
        this.numberOfUniversities = numberOfUniversities;
        this.universityNames = universityNames;
    }

    public String getProfile() {
        return profile;
    }

    public Statistics setProfile(String profile) {
        this.profile = profile;
        return this;
    }

    public double getAverageExamScore() {
        return averageExamScore;
    }

    public Statistics setAverageExamScore(double averageExamScore) {
        this.averageExamScore = averageExamScore;
        return this;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public Statistics setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public Statistics setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
        return this;
    }

    public List<String> getUniversityNames() {
        return universityNames;
    }

    public Statistics setUniversityNames(List<String> universityNames) {
        this.universityNames = universityNames;
        return this;
    }
}
