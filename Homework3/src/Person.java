import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person> {

    private String name;
    private LocalDate dateOfBirth;
    private Map<String,Node> relationships;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.relationships = new HashMap<>();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Map<String, Node> getRelationships() {
        return relationships;
    }

    public void addRelationship(String label, Node node) {
        this.relationships.put(label, node);
        node.getRelationships().put(label,node);
    }

    public int numRelations() {
        return this.relationships.size();
    }

    public String obtainName() {
        return this.getName();
    }

    public int compareTo(Person obj) {
        return this.getName().compareTo(obj.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", relationships=" + relationships +
                '}';
    }
}
