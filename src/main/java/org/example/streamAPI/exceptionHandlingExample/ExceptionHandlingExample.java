package org.example.streamAPI.exceptionHandlingExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ExceptionHandlingExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("44","123","373","xyz");

//        List<Integer> intList = list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
//        System.out.println("converted List elements from String to Integer " + intList);

//        // example 1 of exception handling using try-catch
//        list.forEach(s -> {
//            try {
//                System.out.println(Integer.parseInt(s));
//            }catch (Exception ex){
//                System.out.println("exception : " +ex.getMessage());
//            }
//        });
        System.out.println("==================================================");

        // approach 2 :  extract try-catch logic to a separate method
//        list.forEach(ExceptionHandlingExample::printList);

        System.out.println("==================================================");

        // approach 3 : using exception handling for Consumer<Type> in another method
        list.forEach(handleExceptionIfAny(s -> System.out.println(Integer.parseInt(s))));



    }
    // part of approach 2
    public static void printList(String s){
        try {
            System.out.println(Integer.parseInt(s));
        }catch (Exception ex){
            System.out.println("exception : " +ex.getMessage());
        }
    }

    // part of approach 3
    public static Consumer<String> handleExceptionIfAny(Consumer<String> payload){
        return obj -> {
            try {
                payload.accept(obj);
            } catch (Exception ex) {
                System.out.println("exception : " +ex.getMessage());
            }
        };
    }
}
