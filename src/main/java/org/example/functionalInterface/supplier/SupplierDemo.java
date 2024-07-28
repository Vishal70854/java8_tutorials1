package org.example.functionalInterface.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        // we will use lambda expression to implement Supplier<Object> interface
        // Supplier interface's get() method does not have any method argument but it will always return value
        // return value type can be based on our requirement i.e String, Integer, UserDefined Object etc

        // lambda expression for invoking get() method of Supplier interface
        Supplier<String> supplier = () -> "Hi Vishal implementation of Supplier<T> interface using lambda expressions"; // return String object type


        // call the get() method and it will invoke the above lambda expression
        System.out.println(supplier.get());
        System.out.println("====================================================");

        //==========================================================================
        // we can use Supplier interface in stream API where we are not getting our result based on filter
        // so to return dummy data we can use Supplier<T>
        // since my list1 doesnot contain anything so .orElseGet(supplier) will run and it will return "Hi Vishal"
        List<String> list1 = Arrays.asList();
        System.out.println(list1.stream().findAny().orElseGet(supplier));

        System.out.println("====================================================");

        //==========================================================================
        // passing lambda expression in orElseGet() instead of reference of supplier object
        // since my list1 doesnot contain anything so .orElseGet(supplier) will run and it will return "Hi Vishal"
        System.out.println(list1.stream().findAny().orElseGet(() -> "Hi Vishal implementation of Supplier<T> interface using lambda expressions"));
    }
}
