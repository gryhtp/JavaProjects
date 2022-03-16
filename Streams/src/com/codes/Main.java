package com.codes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList("N40", "N38", "B12", "B6", "G53", "G49", "G60", "g64", "G50", "I26", "I17", "I29", "O71");

        List<String> gNumbers = new ArrayList<>();


//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort(Comparator.naturalOrder());
//        gNumbers.forEach(System.out::println);

        someBingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted().forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream , inNumberStream);
        System.out.println(concatStream.distinct().peek(System.out::println).count());


        System.out.println("======================================");


        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Timmy Turner", 35);
        Employee jack = new Employee("Jack Hill", 56);
        Employee snow = new Employee("Snow White", 66);
        Employee red = new Employee("Red Hood", 32);
        Employee charming = new Employee("Prince Charming", 88);


        Department hr = new Department("Human Resources");

        hr.addEmployee(john);
        hr.addEmployee(tim);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");

        accounting.addEmployee(red);
        accounting.addEmployee(charming);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream().flatMap(department -> department.getEmployees().stream()).forEach(System.out::println);

        System.out.println("======================================");

        List<String> sortGNumbers = someBingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted().collect(Collectors.toList());

        for (String s : sortGNumbers){
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupedByAge = departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getAge));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce(((employee, employee2) -> employee.getAge() < employee2.getAge() ? employee : employee2))
                .ifPresent(System.out::println);

    }
}
