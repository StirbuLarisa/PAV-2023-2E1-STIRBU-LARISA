package org.example;
import org.apache.commons.lang3.tuple.Pair;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Problem problem = new Problem();



        for (Project prj : problem.getProjects()){

            System.out.println(prj);
        }

        for (Student std: problem.getStudents()){
            System.out.println(std);
        }

        System.out.println();
        System.out.println("he students that have a number of preferences lower than the average number of preferences:");

        List<Student> studentsWithNumOfPreffLower = problem.preferencesLowerThenAvg();
        for (Student std: studentsWithNumOfPreffLower){
            System.out.println(std);
        }

        System.out.println();
        System.out.println("Matchings:");

        List<Pair<Student,Project>> matching =problem.greedySolution();
        for (Pair<Student,Project> pair : matching){
            System.out.println(pair);
        }

    }
}