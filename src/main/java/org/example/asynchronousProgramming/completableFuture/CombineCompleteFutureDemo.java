package org.example.asynchronousProgramming.completableFuture;

import org.example.asynchronousProgramming.completableFuture.database.EmployeeDatabase;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CombineCompleteFutureDemo {

    public  CompletableFuture<Employee> getEmployeeDetails(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getEmployeeDetails() : " + Thread.currentThread().getName());
            return EmployeeDatabase.fetchEmployees()
                    .stream()
                    .filter(emp -> "EMP001".equals(emp.getEmployeeId()))
                    .findAny().orElse(null);
        });
    }

    public CompletableFuture<Integer> getRatings(Employee employee){
        System.out.println("getRatings() : " + Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(() -> {
            return employee.getRating();
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // combine dependent future (2) -> thenCompose(Function Reference)
        // employee -> ratings

        CombineCompleteFutureDemo cf = new CombineCompleteFutureDemo();

        // use thenCompose(Function) which takes input from previous thread i.e cf.getEmployeeDetails() and process the output
        // if we have two dependent threads then we should use thenCompose() method of CompletableFuture<Return Type>

        // return type of CompletableFuture<Integer> is Integer because it gives the last completable future return type i.e here cf.getRatings(employee) return CompletableFuture<Integer>
        CompletableFuture<Integer> thenComposeResults = cf.getEmployeeDetails().thenCompose(employee -> cf.getRatings(employee));
        System.out.println("Ratings : " + thenComposeResults.get());


        // combine independent future (2) -> thenCombine()

        System.out.println("====================================================");

        // 1. task group employee and counts
        CompletableFuture<Map<String, Long>> employeeMapFuture = CompletableFuture.supplyAsync(() -> {
            return EmployeeDatabase.fetchEmployees()
                    .stream()
                    .collect(Collectors.groupingBy(
                            Employee::getGender,    // group based on gender of employee
                            Collectors.counting()   // count based on gender
                    ));
        });

        // 2. get all emails
        CompletableFuture<List<String>> emailsFuture = CompletableFuture.supplyAsync(() -> {
            return EmployeeDatabase.fetchEmployees()
                    .stream()
                    .map(Employee::getEmail)
                    .collect(Collectors.toList());
        });

        // if we have two or more independent tasks then we can use thenCombine(CompletableFutureReference, BiFunctionReference)
        CompletableFuture<String> thenCombineResults = employeeMapFuture.thenCombine(emailsFuture, (empMap, emails) -> {
            return empMap + " " + emails;
        });
        System.out.println("thenCombineResults : " + thenCombineResults.get());

        // combine multiple independent future (more than 2) -> allOf(n task)



        // combine multiple future (no need to wait for all)

    }

}
