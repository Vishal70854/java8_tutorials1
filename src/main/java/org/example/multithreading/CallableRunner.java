package org.example.multithreading;

import java.util.concurrent.*;

class CallableTask implements Callable<String>{

    private String name;

    public CallableTask(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000); // sleep for 1s
        return "Hello " + name;
    }
}

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // create a thread pool of size 1 using Executors.newFixedThreadPool(1)
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // Future<String> welcomeFuture is also a thread and it will run parallely with main method
        // we will get reponse of Future 1s late as we have used Thread.sleep(1000) in our CallableTask
        Future<String> welcomeFuture =
                executorService.submit(new CallableTask("vishal"));// .submit() method is used to execute a Callable interface
        System.out.println("\nnew CallableTask(\"vishal\") executed");

        System.out.println(welcomeFuture.get());    // this is running parallely with main and its a Thread

        System.out.println("\nMain completed");

        executorService.shutdown(); // make sure to shutdown executeService at the end of program


    }
}
