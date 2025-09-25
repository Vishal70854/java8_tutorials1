package org.example.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleAnyCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // create a thread pool of size 3 using Executors.newFixedThreadPool(3)
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // list of callable task
        List<CallableTask> tasks = List.of(
                new CallableTask("in28minutes"),
                new CallableTask("vishal"),
                new CallableTask("Adam")
        );

        // execute any of the task using invokeAny() method
        String result = executorService.invokeAny(tasks);

        System.out.println(result);

        executorService.shutdown();


    }
}
