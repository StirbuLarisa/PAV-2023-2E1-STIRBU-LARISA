import java.util.*;
public class Main {

    public static void main(String[] args) {

        List<Node> relations = new ArrayList<>();
        Person ana = new Person("Ana", 21);
        Person ion = new Person("Ion", 23);
        Person bob = new Person("Bob", 31);

        Company max = new Company("MaxCode", 61);
        Company endava = new Company("Endava", 324);
        Company conti = new Company("Continental", 235);

        relations.add(ion);
        relations.add(ana);
        relations.add(bob);

        relations.add(max);
        relations.add(endava);
        relations.add(conti);

        for ( Node i :relations){
            System.out.println(i.toString());
        }


    }
}