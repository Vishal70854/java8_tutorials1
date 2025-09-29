package org.example.functionalProgrammingExampleProjects;

import java.util.List;

public class FunctionalProgramming {
    public static void main(String[] args) {

        List<String> list = List.of("Apple","Banana","Cat","Dog");

        // example of procedural programming. lets see how Functional Programming comes into play
        printBasic(list);
        System.out.println("====================================================");

        // here we are printing the list with functional programming
        printWithFP(list);



    }

    private static void printBasic(List<String> list) {
        for(String string : list){
            System.out.println(string);
        }
    }

    private static void printWithFP(List<String> list) {
        list.stream().forEach(
                element -> System.out.println("element - " + element)
                );



    }

}
