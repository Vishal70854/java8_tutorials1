package org.example.functionalInterface.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo2 {
    public static void main(String[] args) {
        Function<Integer, Integer > function = t -> t*2;  // take t as input and return t*2 as output
        System.out.println(function.apply(5));

        //====================================================================
        System.out.println("=====================================================");

        List<Integer> list = Arrays.asList(4,5,2,1,7,8,6);
        list.stream()
                .map(function)  // passed the function reference which returns 2*i for each element
                .forEach(t -> System.out.println(t));

        //=================================================================
        System.out.println("=====================================================");
        // Function example by passing function lambda in map() method
        list.stream()
                .map(t -> t*2)  // take t as input for each element and return t *2 as output for each element
                .forEach(System.out::println);  // print each element

    }
}
