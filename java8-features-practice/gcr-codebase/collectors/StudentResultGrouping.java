package collectors;

import java.util.*;
import java.util.stream.*;

class StudentResultGrouping {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Rahul", "A"),
                new Student("Amit", "B"),
                new Student("Neha", "A"),
                new Student("Priya", "C")
        );

        Map<String, List<String>> result =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        ));

        System.out.println(result);
    }
}

class Student {
    private String name;
    private String grade;

    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    String getName() { return name; }
    String getGrade() { return grade; }
}
