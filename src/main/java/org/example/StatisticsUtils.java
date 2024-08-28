package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsUtils {

    public List<Statistics> generateStatistics(List<Student> students, List<University> universities) {


        Map<StudyProfile, List<Student>> studentsByProfile = new HashMap<>();

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            University university = findUniversityBy(universities, student.getUniversityId());

            StudyProfile profile = university.getMainProfile();

            if (!studentsByProfile.containsKey(profile)) {
                studentsByProfile.put(profile, new ArrayList<>());
            }
            studentsByProfile.get(profile).add(student);
        }

        List<Statistics> statisticsList = new ArrayList<>();

        for (Map.Entry<StudyProfile, List<Student>> entry : studentsByProfile.entrySet()) {

            StudyProfile profile = entry.getKey();
            List<Student> profileStudents = entry.getValue();


            double averageScore = this.getAvgScoreAllStudents(profileStudents);

            int studentCount = profileStudents.size();

            List<String> universityNames = universities.stream()
                    .filter(university -> university.getMainProfile() == profile)
                    .map(University::getFullName)
                    .distinct()
                    .collect(Collectors.toList());

            int universityCount = universityNames.size();
            Statistics statistics = new Statistics(
                    profile.getProfileName(),
                    averageScore,
                    studentCount,
                    universityCount,
                    universityNames
            );

            statisticsList.add(statistics);


        }

        return statisticsList;
    }

    private double getAvgScoreAllStudents(List<Student> students) {

        if (students.size() == 0) return 0;
        double total = 0;

        for (int i = 0; i < students.size(); i++) {
            total = total + students.get(i).getAvgExamScore();
        }

        return total / students.size();
    }

    private University findUniversityBy(List<University> universities, String universityId) {

        return universities.stream()
                .filter(university -> university.getId().equals(universityId))
                .findFirst()
                .orElse(null);
    }


}
