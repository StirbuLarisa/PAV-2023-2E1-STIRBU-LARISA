

public class Person implements Node, Comparable<Person> {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String obtainName() {
        return this.getName();
    }

    public int compareTo(Person o) {

        if(this.name.compareTo(o.getName())>0)
            return 1;
        if(this.name.compareTo(o.getName())==0)
            return 0;

        return -1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
