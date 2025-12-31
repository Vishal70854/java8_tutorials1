package org.example.java8ProgrammingQuestions;

import java.util.Arrays;
import java.util.List;

class Employee {
    private String name;
    private double salary;
    // getters, setters, constructor

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Emp {
    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 60000),
                new Employee("Charlie", 70000),
                new Employee("David", 60000),
                new Employee("Eve", 80000)
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = getEmployees();
        System.out.println(employees);
    }
}