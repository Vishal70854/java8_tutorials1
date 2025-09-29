package org.example.functionalProgrammingExampleProjects;

import java.util.List;

public class MethodReferencesRunner {
    // print each number. defined this method inorder to use Method References
    public static void print(Integer number){
        System.out.println(number);
    }

    // check number is even or not
    public static boolean isEven(Integer number){
        return number%2 == 0;
    }
    public static void main(String[] args) {
        // using lambda expression in stream
        // take list of string as input and return length of each element as output
        // example 1
        List.of("Ant","Bat","cat","Dog","Elephant").stream()
                .map(s -> s.length())
                .forEach(s -> System.out.println(s));

        System.out.println("===================================================");
        // example 2

        System.out.println("using Method References : ");
        // method references can call both static methods and instance methods
        // example is shown below

        List.of("Ant","Bat","cat","Dog","Elephant").stream()
                .map(String::length)    // same as s -> s.length()
                .forEach(MethodReferencesRunner::print);  // method references example (replacement of .forEach(s -> System.out.println(s));)

        System.out.println("==================================================");

        // example 3
        // get the maximum even number from the list below

        Integer max = List.of(23,45,67,34).stream()
                .filter(MethodReferencesRunner::isEven) // same as n -> n%2 == 0
                .max(Integer::compare)  //used Method References -> same as (n1,n2) -> Integer.compare(n1,n2)
                .orElse(0);
        System.out.println("max element - " + max);




    }
}
