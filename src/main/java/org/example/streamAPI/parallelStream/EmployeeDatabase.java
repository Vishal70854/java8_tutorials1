package org.example.streamAPI.parallelStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDatabase {

    public static List<EmployeeDB> getEmployees(){
        List<EmployeeDB> employees = new ArrayList<>();
        for(int i = 1; i < 1000; i++){
            employees.add(new EmployeeDB(i, "employee"+i,"A",Double.valueOf(new Random().nextInt(1000*100))));
        }
        return employees;
    }
}
