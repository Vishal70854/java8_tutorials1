package org.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task extends  Thread{
    private int number;
    public Task(int number){
        this.number = number;
    }

    public void run(){  //SIGNATURE
        System.out.println("\nTask" + number + " started");
        for(int i = number*100; i <= number*100 + 99; i++){
            System.out.print("i "+ i);
        }
        System.out.println("\nTask" + number + " done");
    }
}

public class ExecutorServiceRunner {
    public static void main(String[] args) {

        /*
        // create only 1 thread at a time using Executors.newSingleThreadExecutor()
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // for Executors.newSingleThreadExecutor() when task1 thread will complete then only task2 thread will start running

        executorService.execute(new Task1());   // new thread for task1
        executorService.execute(new Thread(new Task2()));   // new thread for task2
         */
        //-------------------------------------------------------------------------------

        // running multiple threads at a time using Executors.newFixedThreadPool(2)
        // this means Executors.newFixedThreadPool(2) will run 2 threads at a time

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // task1 and task2 will run at the same time as newFixedThreadPool(2) size is 2
        executorService.execute(new Task(1));   // new thread for task1
        executorService.execute(new Task(2));   // new thread for task2

        // task3 and task4 will run at the same time as newFixedThreadPool(2) size is 2
        executorService.execute(new Task(3));   // new thread for task3
        executorService.execute(new Task(4));   // new thread for task4

        // task5 and task6 will run at the same time as newFixedThreadPool(2) size is 2
        executorService.execute(new Task(5));   // new thread for task5
        executorService.execute(new Task(6));   // new thread for task6


        executorService.shutdown(); // at the end of program we have to call shutdown() method in ExecutorService

    }
}
