package org.example.functionalInterface.function;

import java.util.function.Function;
// Function<Integer, String>  means Function will take Integer value as input and return String value as output
public class FunctionDemo1 implements Function<Integer, String> {

    @Override
    public String apply(Integer value) {  // apply method will take Integer value as input and return String value as output
        return value + " multiplied by 10";
    }

    public static void main(String[] args) {
        Function<Integer, String> functionDemo1 = new FunctionDemo1();
        System.out.println(functionDemo1.apply(10));
    }


}
