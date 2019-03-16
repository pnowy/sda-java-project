package pl.sda.programming1.datastructures.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Student {

    private String name;
    private List<Integer> grades;

    public Student(String name, Integer ... grades) {
        this.name = name;
        this.grades = Arrays.asList(grades);
    }

    public Stream<Integer> getGradesStream() {
        return grades.stream();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }
}
