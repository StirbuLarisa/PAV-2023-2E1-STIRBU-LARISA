import java.time.LocalDate;
import java.util.Map;

public class Designer extends Person{

    private int yearsOfExperience;
    private String bestSkill;

    public Designer(String name, LocalDate dateOfBirth, int yearsOfExperience, String bestSkill) {
        super(name, dateOfBirth);
        this.yearsOfExperience = yearsOfExperience;
        this.bestSkill = bestSkill;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getBestSkill() {
        return bestSkill;
    }

    public void setBestSkill(String bestSkill) {
        this.bestSkill = bestSkill;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "yearsOfExperience=" + yearsOfExperience +
                ", bestSkill='" + bestSkill + '\'' +
                '}';
    }
}
