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
//        list.forEach(handleExceptionIfAny(s -> System.out.println(Integer.parseInt(s))));

        // approach 4 : handling generic exception
        list.forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)),NumberFormatException.class));
        System.out.println("============================================");

        // handling Generic excpetion.. in this case it is Arithmetic exception since 10/0 is infinity
        List<Integer> list2 = Arrays.asList(1,0);
        list2.forEach(handleGenericException(s -> System.out.println(10/s), ArithmeticException.class));




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

    // part of approach 4
    static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(
            Consumer<Target> targetConsumer,
            Class<ExObj> exObjClass){

        return obj -> {
            try {
                targetConsumer.accept(obj);
            } catch (Exception ex) {
                try {
                    ExObj exObj = exObjClass.cast(ex);
                    System.out.println("exception : " + exObj.getMessage());
                } catch (Exception ecx) {
                    throw ex;
                }
            }
        };
    }
}
