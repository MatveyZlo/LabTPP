package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String position;
    private double salary;

    public Employee(String name, int age, String position, double salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}

public class Main {
    public static void main(String[] args) {

        List<String> words = List.of("Сковородка", "День", "Ромашка", "Сковородка", "День", "Стол", "Церковь", "Магазин", "Ромашка", "Магазин");


        String mostFrequentWords;
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == words.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values().stream()
                        .max(Long::compare)
                        .orElse(0L))
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", ", "Самые повторяющиеся слова: ", "!")));



        List<Employee> employees = Arrays.asList(
                new Employee("Игорь", 19, "Разработчик", 1200),
                new Employee("Матвей", 52, "Менеджер", 1500),
                new Employee("Илья", 35, "Разработчик", 1800),
                new Employee("Вася", 35, "Разработчик", 1600),
                new Employee("Вадим", 35, "Менеджер", 2000),
                new Employee("Алексей", 35, "Разработчик", 1400),
                new Employee("Марина", 50, "Менеджер", 1700)
        );

        String targetPosition = "Разработчик";
        int n = 3;

        System.out.println(findTopPaidEmployees(employees, targetPosition, n));
    }

    public static String findTopPaidEmployees(List<Employee> employees, String position, int n) {
        return employees.stream()
                .filter(employee -> employee.getPosition().equals(position))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(Employee::getName)
                .limit(n)
                .sorted((o1, o2) -> o2.codePointAt(0) - o1.codePointAt(0))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> n + " самых высокооплачиваемых сотрудников зовут: " + String.join(", ", list) + "."));
    }
}