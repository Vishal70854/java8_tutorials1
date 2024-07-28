package org.example.functionalInterface.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo{
    // in this class we will call accept(int t) method of Consumer<T> interface using lambda expressions
    public static void main(String[] args) {
        Consumer<Integer> consumer = (t) -> System.out.println("Printing : " + t);

        // call the accept method and it will invoke the above lambda expression and print the integer t
        consumer.accept(10);

        //==================================================================
        // use case :  Consumer<T> is used in forEach() method in stream API
        // example mentioned below
        List<Integer> list1 = Arrays.asList(1,2,6,43,7,9);
        // internally the forEach(consumer) will call the consumer.accept(t) each time as it is the only abstract method in Consumer interface
        // the below statement will invoke above consumer each time and output our own custom implementation ie(System.out.println("Printing : " + t);)
        System.out.println("===========================================");
        list1.stream().forEach(consumer);   // here we have passed our own consumer reference
        System.out.println("===========================================");

        //==================================================================
        // instead of passing consumer reference we can pass the expression body in forEach() method
        list1.forEach(t -> System.out.println("print : " +t));

        //==================================================================

    }
}

