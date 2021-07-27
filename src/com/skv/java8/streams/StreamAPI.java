package com.skv.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Skv", 30);
        Employee employee2 = new Employee("Pvs", 70);
        Employee employee3 = new Employee("Akb", 25);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        OptionalInt maxAge = employeeList.stream().mapToInt(Employee::getAge).max();
        if (maxAge.isPresent()) {
            System.out.println("Max Age :" + maxAge.getAsInt());
        } else {
            System.out.println("No such age");
        }
        System.out.print("Employess with name starts with S : ");
        employeeList.stream()
                .map(Employee::getName)
                .filter(e->e.startsWith("S"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.print("Total age of Employees: " +  employeeList.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum));

    }

}