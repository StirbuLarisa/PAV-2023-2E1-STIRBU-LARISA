package org.example;
import org.apache.commons.lang3.tuple.Pair;
import java.util.*;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;

import java.util.Random;

public class Problem {

    private List<Student> students;
    private Set<Project> projects;

    public Problem() {
        this.students = new LinkedList<>();
        this.projects = new TreeSet<>();


        Set<Project> possibleProj = new TreeSet<>();
        Faker faker = new Faker();
        Random random = new Random();
        String[] words = {"web", "app", "security", "database", "network", "analytics", "cloud", "AI", "automation", "testing","mobile","statistics"};


        int projNum = random.nextInt((7 - 4) + 1) + 4;
        int studentsNum = random.nextInt((8 - 5) + 1) + 5;

        for (int i = 0; i < projNum; i++) {

            Project toAdd = new Project(words[random.nextInt(words.length)] + " " + words[random.nextInt(words.length)]);
            possibleProj.add(toAdd);

        }
        this.projects = possibleProj;

        ArrayList<Project> prjList = new ArrayList<>(possibleProj);

        for (int i = 0; i < studentsNum; i++) {

            int possibleProjNum = random.nextInt((projNum - 0) + 1);
            Collections.shuffle(prjList);
            List<Project> projectForStudent = new ArrayList<>();

            for (int j = 0; j < possibleProjNum; j++) {

                projectForStudent.add(prjList.get(j));
            }
            Student toAdd = new Student(faker.name().firstName(), projectForStudent);
            this.students.add(toAdd);

        }


    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public List<Student> preferencesLowerThenAvg() {

        double avgNumPreferences = students.stream().mapToInt(student -> student.getPossibleProjects().size()).average().orElse(0.0);

        List<Student> studentsWithLessPreferences = students.stream().filter(student -> student.getPossibleProjects().size() < avgNumPreferences).collect(Collectors.toList());

        return studentsWithLessPreferences;

    }

    public List<Pair<Student,Project>> greedySolution(){

        List<Pair<Student, Project>> matching = new ArrayList<>();

        // Create a map of the number of students who want each project
        Map<Project, Boolean> isAllocated = new HashMap<>();
        for (Project project : getProjects()) {
            isAllocated.put(project, false);
        }

        List<Student> studentsSortedByNumProjects = new ArrayList<>(getStudents());
        studentsSortedByNumProjects.sort((s1, s2) -> Integer.compare(s1.getPossibleProjects().size(), s2.getPossibleProjects().size()));


        for (Student student : studentsSortedByNumProjects) {
            List<Project> possibleProjects = new ArrayList<>(student.getPossibleProjects());

            for (Project project : possibleProjects) {
                if (!isAllocated.get(project)) {
                    matching.add(Pair.of(student, project));
                    isAllocated.put(project, true);
                    break;
                }
            }
        }

        return matching;
    }


}

