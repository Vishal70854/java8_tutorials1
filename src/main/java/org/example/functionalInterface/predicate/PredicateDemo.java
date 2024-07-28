package org.example.functionalInterface.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        // here we will implement Predicate<Object> using lambda expressions
        // lambda expression to write logic for test method of Predicate<Object> interface
        Predicate<Integer> predicate = t -> t%2 == 0;   // return true if t is even else return false using lambda expression
        System.out.println(predicate.test(4));

        System.out.println("=================================================");

        //==========================================================
        // we can use Predicate interface in filter(predicate) in stream API
        List<Integer> list1 = Arrays.asList(1,2,6,43,7,9);
        list1.stream()
                .filter(predicate)  // here filter uses predicate internally but we are giving our own predicate which filters out even numbers
                .forEach(t -> System.out.println("print Even : " +t));   // forEach() internallly uses Consumer interface but we are giving our own implementation
        System.out.println("=======================================================");

        //==========================================================
        // instead of passing predicate reference variable we are passing our expression body of lambda expression for our own Predicate implementation
        list1.stream()
                .filter(t -> t%2 != 0)  // here filter uses predicate internally but we are giving our own predicate which filters out odd numbers
                .forEach(t -> System.out.println("print odd : " +t));   // forEach() internallly uses Consumer interface but we are giving our own implementation
        System.out.println("=======================================================");
    }
}
