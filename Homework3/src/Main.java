import java.time.LocalDate;
import java.util.*;

public class Main {


    public static void main(String[] args){
        Network network = new Network();

        Person ana = new Person("Ana", LocalDate.of(1990,2,13));
        Programmer ion = new Programmer("Ion", LocalDate.of(2000,4,23),5,"Python");
        Programmer mara = new Programmer("Mara", LocalDate.of(2001,3,13),4,"Java");
        Designer mih = new Designer("Mihai", LocalDate.of(1998,3,19),3,"friendlly");
        Designer radu = new Designer("Radu", LocalDate.of(1997,11,27),4,"social");
        Person bob = new Person("Bob", LocalDate.of(1999,12,31));

        Company max = new Company("MaxCode", 61);
        Company endava = new Company("Endava", 324);
        Company conti = new Company("Continental", 235);

        network.addNode(ana);
        network.addNode(ion);
        network.addNode(mara);
        network.addNode(mih);
        network.addNode(radu);
        network.addNode(bob);
        network.addNode(max);
        network.addNode(endava);
        network.addNode(conti);

        ana.addRelationship("prietenie1",ion);
        ana.addRelationship("prietenie2",radu);
        ana.addRelationship("prietenie3",mara);
        ana.addRelationship("ura",bob);
        mara.addRelationship("prietenie",bob);
        mara.addRelationship("ura",radu);
        ion.addRelationship("prietenie",mih);

        max.addRelationship("angajat1",ana);
        max.addRelationship("angajat2",ion);
        endava.addRelationship("angajat1",ion);
        endava.addRelationship("angajat2",bob);
        endava.addRelationship("angajat3",mih);
        conti.addRelationship("angajat",radu);

        network.printNodes();
    }


}