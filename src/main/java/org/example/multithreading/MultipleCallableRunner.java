package org.example.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // create a thread pool of size 3 using Executors.newFixedThreadPool(3)
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // list of callable task
        List<CallableTask> tasks = List.of(
                new CallableTask("in28minutes"),
                new CallableTask("vishal"),
                new CallableTask("Adam")
        );

        // execute all tasks using invokeAll() method
        List<Future<String>> results =
                executorService.invokeAll(tasks);

        // loop around results to get our output
        for(Future<String> result : results){
            System.out.println(result.get());
        }

        executorService.shutdown();


    }
}
