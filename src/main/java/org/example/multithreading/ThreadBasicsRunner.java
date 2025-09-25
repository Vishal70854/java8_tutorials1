package org.example.multithreading;

class Task1 extends  Thread{
    public void run(){  //SIGNATURE
        System.out.println("\nTask1 started");
        for(int i = 101; i <= 199; i++){
            System.out.print("i "+ i);
        }
        System.out.println("\nTask1 done");
    }
}

class Task2 implements Runnable{

    @Override
    public void run() {
        System.out.println("\nTask2 started");
        for(int i = 201; i <= 299; i++){
            System.out.print("i "+ i);
        }
        System.out.println("\nTask2 done");
    }
}

public class ThreadBasicsRunner {
    public static void main(String[] args) throws InterruptedException {

        // Task1
        System.out.println("\nTask1 kicked off");
        Task1 task1 = new Task1();
        task1.setPriority(1);
        task1.start();

        System.out.println("\nTask2 kicked off");
        // Task2
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.setPriority(1);
        task2Thread.start();

        // wait for task1 to complete
        task1.join();   // wait for task1 to complete first then only next line/below lines code will be executed
        task2Thread.join(); // wait for task2Thread to complete then only task3 will be kicked off

        System.out.println("\nTask3 kicked off");
        // Task3
        for(int i = 301; i <= 399; i++){
            System.out.print("i "+ i);
        }
        System.out.println("\nTask3 done");

        System.out.println("\nMain Done");

    }


}
