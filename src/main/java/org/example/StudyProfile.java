package org.example;

public enum StudyProfile {
    Medecine ("Mедецина"),
    Econonmy ("Экономика"),
    Architecture ("Архитектура"),
    History ("История");
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
