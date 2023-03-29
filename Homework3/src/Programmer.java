import java.time.LocalDate;
import java.util.Map;

public class Programmer extends Person{

    private int numOfProgrammingLanguages;
    private String favouriteProgrammingLanguage;

    public Programmer(String name, LocalDate dateOfBirth,  int numOfProgrammingLanguages, String favouriteProgrammingLanguage) {
        super(name, dateOfBirth);
        this.numOfProgrammingLanguages = numOfProgrammingLanguages;
        this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    }

    public int getNumOfProgrammingLanguages() {
        return numOfProgrammingLanguages;
    }

    public void setNumOfProgrammingLanguages(int numOfProgrammingLanguages) {
        this.numOfProgrammingLanguages = numOfProgrammingLanguages;
    }

    public String getFavouriteProgrammingLanguage() {
        return favouriteProgrammingLanguage;
    }

    public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
        this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Programmer{" +
                "numOfProgrammingLanguages=" + numOfProgrammingLanguages +
                ", favouriteProgrammingLanguage='" + favouriteProgrammingLanguage + '\'' +
                '}';
    }
}
