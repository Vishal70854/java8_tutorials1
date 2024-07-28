package org.example.functionalInterface;
interface Calculator1{
    void sum(int input);    // abstract method with 1 argument
}

public class Calculator1Impl {
    public static void main(String[] args) {
        // this is demo for functional interface having 1 argument for only abstract method

        // write lambda expression for sum(int input) method in Calculator1 interface
        // note :  when we have only 1 line expression body we can skip {} and we can write lambda expression on the same line
        Calculator1 calculator1 = (int input) -> System.out.println("Sum : " +input);
        // call the sum(input) method by using above variableName.methodName(), where methodName() is method of Calculator1 interface(functional interface)
        calculator1.sum(890);
    }
}
