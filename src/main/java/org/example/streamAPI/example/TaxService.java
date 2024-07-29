package org.example.streamAPI.example;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

    public static void main(String[] args) {
        System.out.println(evaluateTaxUsers("TAX"));
    }
    public static List<Employee> evaluateTaxUsers(String input){
        if(input.equalsIgnoreCase("tax")){
            // return all employees list whose salary > 500000
            return  EmployeeDAO.getEmployees().stream() // convert List to stream
                    .filter(emp -> emp.getSalary() > 500000)    // filter out employees whose salary > 500000
                    .collect(Collectors.toList());// convert stream to List
        }
        else{
            // return all employees list whose salary < 500000
            return  EmployeeDAO.getEmployees().stream() // convert List to stream
                    .filter(emp -> emp.getSalary() <= 500000)    // filter out employees whose salary > 500000
                    .collect(Collectors.toList());// convert stream to List
        }

    }
}
