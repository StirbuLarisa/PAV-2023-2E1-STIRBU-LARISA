import java.util.HashMap;
import java.util.Map;
public class Company implements Node,Comparable<Company> {

    private String name;
    private int numOfEmployees;
    private Map<String,Node> relationships;

    public Company(String name, int numOfEmployees) {
        this.name = name;
        this.numOfEmployees = numOfEmployees;
        this.relationships = new HashMap<>();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    @Override
    public Map<String, Node> getRelationships() {
        return relationships;
    }

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public void addRelationship(String label, Node node) {
        this.relationships.put(label, node);
        node.getRelationships().put(label,node);
    }
    public int numRelations() {
        return this.relationships.size();
    }

    public String obtainName() {
        return this.name;
    }


    public int compareTo(Company obj) {
        return this.getName().compareTo(obj.getName());
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", numOfEmployees=" + numOfEmployees +
                ", relationships=" + relationships +
                '}';
    }
}



