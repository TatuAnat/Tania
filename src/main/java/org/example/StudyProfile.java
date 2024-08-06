package org.example;

public enum StudyProfile {
    MEDICINE ("Mедицина"),
    Econonmy ("Экономика"),
    Architecture ("Архитектура"),
    History ("История"),
    MATHEMATICS ("MATHEMATICS"),
    LINGUISTICS ("LINGUISTICS"),
    PHYSICS ("Fisica");
   private String profileName;


    StudyProfile(String profileName ) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public String toString() {
        return "StudyProfile{" +
                "profileName='" + profileName + '\'' +
                '}';
    }
}
