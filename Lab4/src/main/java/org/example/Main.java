package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        Project dfs = new Project("DFS");
        Project bfs = new Project("BFS");
        Project djikstra = new Project("Djikstra");
        Project roy = new Project("Roy-Floyd");

        List <Student> students = Stream.of(
                new Student ("Ana", Stream.of(dfs,bfs,djikstra).collect(Collectors.toList())),
                new Student ("Radu", Stream.of(bfs,djikstra).collect(Collectors.toList())),
                new Student ("Bob",Stream.of(dfs,djikstra).collect(Collectors.toList())),
                new Student ("Ion", Stream.of(roy,djikstra).collect(Collectors.toList()))
                ).collect(Collectors.toCollection(LinkedList::new));

        students.stream().sorted();

        Set<Project> projects = Stream.of(dfs,bfs,roy,djikstra).sorted().collect(Collectors.toCollection(TreeSet::new));


        System.out.println("Studentii:");
        students.forEach(System.out::println);

        System.out.println("Proiecte:");
        projects.forEach(System.out::println);

    }


}