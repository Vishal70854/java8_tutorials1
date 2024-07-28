package org.example.functionalInterface.supplier;

import java.util.function.Supplier;
// Supplier interface has get() which has no argument but return value of object type mentioned in <> i.e Supplier<Object>
public class SupplierDemo1 implements Supplier<String> {    // Supplier<String> means get() method will return String value as return type
    @Override
    public String get() {
        return "Hi Vishal"; // return String object type
    }

    public static void main(String[] args) {
        // we will follow the traditional approach to implement Supplier<T> where T can be any object
        // and override get() that returns a value of type T mentioned in <> i.e Supplier<String> will return String value from get() method

        Supplier<String> supplier = new SupplierDemo1();
        System.out.println(supplier.get());
    }
}
