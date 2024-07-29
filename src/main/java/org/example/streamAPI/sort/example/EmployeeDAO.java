package org.example.streamAPI.sort.example;

import java.util.ArrayList;
import java.util.List;

// DAO Layer
public class EmployeeDAO {

    public static List<Employee> getEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"vishal","IT",600000));
        employeeList.add(new Employee(2,"rajan","mechanical",1000000));
        employeeList.add(new Employee(3,"prashant","civil",400000));
        employeeList.add(new Employee(4,"sourav","electrical",200000));
        employeeList.add(new Employee(5,"mehul","automobile",1500000));

        return employeeList;
    }
}
