package org.example.java8ProgrammingQuestions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8ProgrammingQuestionSet2 {
    public static void main(String[] args) {
        /*
        1. Count employees
        Find how many employees are in the list
         */
        List<Employee> employees = Emp.getEmployees();

        countTotalNumberOfEmployeeUsingJava8(employees);

        System.out.println("========================================================");

        /*
        2. Sum of salaries
        Calculate the total salary of all employees
         */
        sumOfSalariesUsingJava8(employees);

        System.out.println("========================================================");

        /*
        3. Average salary
        Find the average salary
        */
        averageSalaryOfEmployees(employees);

        System.out.println("========================================================");

        /*
        4. Highest salary
        Find the employee with the highest salary
         */
        highestSalaryOfEmployee(employees);

        System.out.println("========================================================");

        /*
        5. Second highest salary
        Find the employee with the second highest salary
         */
        secondHighestSalaryOfEmployee(employees);

        System.out.println("========================================================");

        /*
        6. Group employees by salary
        Group employees who share the same salary
         */

        groupSalaryByEmployees(employees);

        System.out.println("========================================================");

        /*
        7. Top 2 salaries
        Get the top 2 salaries as a list
         */
        top2SalariesOfEmployees(employees);

        System.out.println("========================================================");

        /*
        8. Group by Salary and Count
        How many employees earn each salary
         */
        groupBySalaryAndCounts(employees);

        System.out.println("========================================================");


        /*  we dont have department in Employee class. (just for understanding purpose)
        9. Sum of Salaries by Department
        Total salary per department

        Map<String, Double> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

        */
    }

    private static void groupBySalaryAndCounts(List<Employee> employees) {
        Map<Double, Long> salaryCounts = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));
        System.out.println("group by salary and count : " +salaryCounts);
    }

    // top 2 salaries by employees
    private static void top2SalariesOfEmployees(List<Employee> employees) {
        List<Double> topTwoSalaries = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("top two salaries : " +topTwoSalaries);
    }

    // group salary by employees
    private static void groupSalaryByEmployees(List<Employee> employees) {
        Map<Double, List<Employee>> groupedBySalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println("group salary by employee \n "+ groupedBySalary);
    }

    // second highest salary of employee
    private static void secondHighestSalaryOfEmployee(List<Employee> employees) {
        Employee secondHighest = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // e -> e.getSalary() // both are same and the list is sorted in descending order based on salary
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("second highest salary of employee : " +secondHighest);
    }

    // highest salary of employee
    private static void highestSalaryOfEmployee(List<Employee> employees) {
        Employee highestSalary = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))// e -> e.getSalary() // both are same
                .orElse(null);
        System.out.println(highestSalary);
    }

    // average salary of employees
    private static void averageSalaryOfEmployees(List<Employee> employees) {
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("average salary of employees : " +avgSalary);
    }
    // total sum of salary of employees
    private static void sumOfSalariesUsingJava8(List<Employee> employees) {
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary) // e -> e.getSalary() // both are same and can be used interchangeable
                .sum();
        System.out.println("total sum of salaries of employees : " +totalSalary);
    }
    // total count of employees using java 8 stream api
    private static void countTotalNumberOfEmployeeUsingJava8(List<Employee> employees) {
        long count = employees.stream().count();
        System.out.println("total count of employees : " +count);
    }
}
