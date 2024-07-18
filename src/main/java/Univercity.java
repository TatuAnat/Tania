import org.example.StudyProfile;

public class Univercity {
    String id;
    String fullName;
    String shortName;
    int yearOfFoundation;
    StudyProfile mainProfile;

    public Univercity(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public Univercity setId(String id) {
        this.id = id;
        return this;
    }

    public Univercity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Univercity setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public Univercity setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public Univercity setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @Override
    public String toString() {
        return "Univercity{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}
