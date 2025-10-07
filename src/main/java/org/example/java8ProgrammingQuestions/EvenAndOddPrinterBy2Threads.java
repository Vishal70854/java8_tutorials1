package org.example.java8ProgrammingQuestions;

import com.sun.tools.javac.Main;

// program to print even & odd number using 2 threads
public class EvenAndOddPrinterBy2Threads implements Runnable {

    static int count = 1;
    Object object;

    public EvenAndOddPrinterBy2Threads(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (count <= 10) {
            // even
            if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println("Thread name : " + Thread.currentThread().getName() + " value : " + count);
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            // odd
            if (count % 2 == 1 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println("Thread name : " + Thread.currentThread().getName() + " value : " + count);
                    count++;
                    object.notify();    // notify to other thread is execution is completed so that other threads can start execution

                }

            }
        }
    }

    public static void main(String[] args) {

        Object lock = new Object();

        Runnable r1 = new EvenAndOddPrinterBy2Threads(lock);
        Runnable r2 = new EvenAndOddPrinterBy2Threads(lock);

        new Thread(r1, "even").start(); // start the even thread
        new Thread(r2,"odd").start();   // start the odd thread
    }
}

