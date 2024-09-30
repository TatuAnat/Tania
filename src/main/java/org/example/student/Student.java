package org.example.student;

import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    @SerializedName("full_name")
    String fullName;
    String universityId;
    int currentCourseNumber;
    float avgExamScore;
    public Student() {}
    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }
    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }
    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }
    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }
    @XmlElement
    public String getFullName() {
        return fullName;
    }
    @XmlElement
    public String getUniversityId() {
        return universityId;
    }
    @XmlElement
    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }
    public float getAvgExamScore() {
        return avgExamScore;
    }
    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }

}
