package org.example.java8ProgrammingQuestions;




class NumberPrinter {
    private int number = 1;
    private final int MAX = 1000;

    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 1) {
                System.out.println("Odd Thread: " + number);
                number++;
                notify(); // wake up even thread
            } else {
                try {
                    wait(); // wait until it's odd's turn
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 == 0) {
                System.out.println("Even Thread: " + number);
                number++;
                notify(); // wake up odd thread
            } else {
                try {
                    wait(); // wait until it's even's turn
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class PrintOddEvenBy2Threads {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();

        /*
            odd thread
            even thread

            odd thread will only print odd numbers and even thread will only print even numbers

            sequence of numbering should be maintained like 1,2,3.....1000

            where n = 1000
        */
    }
}

