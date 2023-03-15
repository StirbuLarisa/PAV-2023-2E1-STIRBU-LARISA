public class Company implements Node,Comparable<Company> {

    private String name;
    private int numOfEmployees;

    public Company(String name, int numOfEmployees) {
        this.name = name;
        this.numOfEmployees = numOfEmployees;
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

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public String obtainName() {
        return this.name;
    }

    public int compareTo(Company o) {

        if(this.name.compareTo(o.getName())>0)
            return 1;

        if(this.name.compareTo(o.getName())==0)
            return 0;

        return -1;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", numOfEmployees=" + numOfEmployees +
                '}';
    }
}
