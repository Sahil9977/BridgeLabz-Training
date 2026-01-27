package lamda_expression;


import java.util.*;

public class NameUppercasing {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Amit", "Rahul", "Neha");

        employees.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
