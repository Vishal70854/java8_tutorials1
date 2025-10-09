package org.example.asynchronousProgramming.completableFuture.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.asynchronousProgramming.completableFuture.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeDatabase {

    public static List<Employee> fetchEmployees(){
        ObjectMapper mapper = new ObjectMapper();   // map json object to java object

        try {
            // read "employees.json" file and convert it into List<Employee> using new TypeReference(Type)
            return mapper
                    .readValue(new File("employees.json"), new TypeReference<List<Employee>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
