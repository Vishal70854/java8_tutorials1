package org.example.asynchronousProgramming.completableFuture;

import org.example.asynchronousProgramming.completableFuture.database.EmployeeDatabase;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {
    // here we are using supplyAsync(Supplier) so our thread will be pulled from ForkJoinThreadPool which is common thread pool
    public static List<Employee> getEmployees() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Employee>> listCompletableFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Thread name : " + Thread.currentThread().getName());    // print the thread name
            return EmployeeDatabase.fetchEmployees();
        });
        return listCompletableFuture.get();
    }

    // here we will  be using custom executor overloaded method i.e supplyAsync(Supplier, Executor) which is overloaded method of supplyAsync()
    // now our thread is custom which we will create from ExecutorService
    public static List<Employee> getEmployeesWithCustomExecutor() throws ExecutionException, InterruptedException {
        // create thread using ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(5);  // create thread pool of 5 threads


        CompletableFuture<List<Employee>> listCompletableFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Thread name : " + Thread.currentThread().getName());    // print the thread name
                    return EmployeeDatabase.fetchEmployees();
                },executorService); // provided custom created executor

        return listCompletableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Employee> employees = getEmployees();
        employees.stream()
                .forEach(System.out::println);

    }
}
