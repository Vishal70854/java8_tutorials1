package org.example.streamAPI.sort.example;

import  org.example.streamAPI.sort.example.Employee;
import org.example.streamAPI.sort.example.EmployeeDAO;

import java.util.Comparator;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        // sort Custom class based on some field
        List<Employee> employees = EmployeeDAO.getEmployees();
        // sort employees based on SalaryComparator class
        //=================================================================
        // approach 1
//        Collections.sort(employees, new MySalaryComparator());

        //=================================================================
        // approach 2 to write comparator in place of Collections.sort
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return (int) (o1.getSalary() - o2.getSalary()); // sort in ascending order of employee salary
//            }
//        });
        //===================================================================
        // approach 3  to write comparator using lambda expression which internally calls compare(i1,i2) method of Comparator<Object> interface
        // (o1,o2) ->  (int) (o1.getSalary() - o2.getSalary()));
        // in the above code it will automatically call compare method of Comparator<> interface to sort employees list on basis of salary field

//        Collections.sort(employees, (o1,o2) ->  (int) (o1.getSalary() - o2.getSalary())); // sort in ascending order of employee salary
//
//        System.out.println(employees);

        //=================================================================

        // now we want to sort employees list using stream api
        employees.stream()
                .sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())) // sort in ascending order of salary using stream API
                .forEach(System.out::println);  // print each item using Method Reference

        System.out.println("=======================================================");
        //=====================================================================
        // sort employees list using Comparator.comparing() under sorted() in stream api
        employees.stream()
                .sorted(Comparator.comparing(emp -> emp.getSalary()))   // sort on the basis of salary of employee
                .forEach(System.out::println);

        System.out.println("===========================================================");
        //=================================================================================

        // sort employees list using Method reference based on name field
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        System.out.println("====================================================");

        /*
        // in this class we will sort our collection using stream api and lambda expressions

        List<Integer> list = Arrays.asList(3,12,7,4);

        // sort list using Collections
        Collections.sort(list); // sort in ascending order
        Collections.reverse(list);  // descending order
        System.out.println(list);
        System.out.println("=============================================");

        // sort list using stream API
        list.stream().sorted().forEach(t -> System.out.println(t)); // ascending sort the list using stream api sorted() method
        System.out.println("=============================================");

        list.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.println(t)); // descending sort the list using stream api sorted(Comparator.reverseOrder()) method
        System.out.println("=============================================");

        */

    }
}
