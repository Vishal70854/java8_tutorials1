package org.example.streamAPI.parallelStream;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {

        // try to iterate 100 using normal stream
        long start = 0;
        long end = 0;
/*
        start= System.currentTimeMillis();
        IntStream.range(1,100).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Plain stream took time : " +(end-start));
*/

        System.out.println("===================================================");
        // try to iterate 100 using parallel stream to check time difference between
        // normal stream and parallel stream
/*
        start = System.currentTimeMillis();
        IntStream.range(1,100).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Parallel stream took time : " +(end-start));
*/

        System.out.println("==================================================");

        // example using normal stream to get order to execution of Thread
        IntStream.range(1,10).forEach(x ->
                System.out.println("Thread : " + Thread.currentThread().getName() + " : " +x));
        System.out.println("==================================================");
        // example using parallel stream to get order to execution of Thread
        IntStream.range(1,10).parallel().forEach(x ->
                System.out.println("Thread : " + Thread.currentThread().getName() + " : " +x));

        System.out.println("==================================================");

        // let's get the average of all EmployeeDB object using normal stream and parallel stream
        List<EmployeeDB> employees = EmployeeDatabase.getEmployees();

        // normal stream
        start = System.currentTimeMillis();
        double salaryWithStream = employees.stream().map(e -> e.getSalary()).mapToDouble(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("average salary with normal stream : " +salaryWithStream);
        System.out.println("normal stream average time : "+(end-start));

        System.out.println("==================================================");

        // using parallel stream
        start = System.currentTimeMillis();
        double salaryWithParallelStream = employees.parallelStream().map(e -> e.getSalary()).mapToDouble(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("average salary with parallel stream : " +salaryWithParallelStream);
        System.out.println("parallel stream average time : "+(end-start));

        System.out.println("=================================================");






    }
}
