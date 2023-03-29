package org.example;
import java.util.*;

public class Student implements Comparable<Student>{

    private String name;
    private List<Project> possibleProjects;

    public Student(String name, List<Project> possibleProjects) {
        this.name = name;
        this.possibleProjects = possibleProjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getPossibleProjects() {
        return possibleProjects;
    }

    public void setPossibleProjects(List<Project> possibleProjects) {
        this.possibleProjects = possibleProjects;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", possibleProjects=" + possibleProjects +
                '}';
    }
}
