package org.example.asynchronousProgramming.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncDemo {
    // this method is an use of anonymous implementation of Runnable interface with Completable Future
    public Void saveEmployees(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();

        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Employee> employees = mapper
                            .readValue(jsonFile, new TypeReference<List<Employee>>() {  // read the json file and convert it to List<Employees>
                            });
                    System.out.println("Thread name : " + Thread.currentThread().getName());
//                    employees.stream().forEach(System.out::println);    // print all the employees
                    System.out.println(employees.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return runAsyncFuture.get();

    }

    // example of CompletableFuture and Runnable lambda
    public Void saveEmployeesWithCustomExecutor(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        // we are creating our custom executor with pool of 5 threads and we will overload it in CompletableFuture.runAsync(Runnable, ExecutorService)
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(
                () -> {
                try {
                    List<Employee> employees = mapper
                            .readValue(jsonFile, new TypeReference<List<Employee>>() {  // read the json file and convert it to List<Employees>
                            });
                    System.out.println("Thread name : " + Thread.currentThread().getName());
//                    employees.stream().forEach(System.out::println);    // print all the employees
                    System.out.println(employees.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }, executor);   // the thread will be our custom created thread using executor
        return runAsyncFuture.get();

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
        runAsyncDemo.saveEmployees(new File("employees.json"));

        System.out.println("=============================");

        runAsyncDemo.saveEmployeesWithCustomExecutor(new File("employees.json"));
    }
}
