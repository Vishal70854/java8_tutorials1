package org.example.asynchronousProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WhyNotFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<List<Integer>> future = service.submit(() -> {
            // you are doing some api call
            System.out.println("Thread : " + Thread.currentThread().getName());
            delay(1);
            return Arrays.asList(1, 2, 3, 4);
        });

        List<Integer> list = future.get();
        System.out.println(list);


        service.shutdown();

        // demo of Completable Future(syntax)
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.get();    // this will return some value
        completableFuture.complete("return some dummy data");   // if thread is taking long time then we can use complete() to complete the execution of CompletableFuture




    }

    private static void delay(int min) {
        try {
            TimeUnit.MINUTES.sleep(min);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
