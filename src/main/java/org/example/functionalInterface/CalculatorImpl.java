package org.example.functionalInterface;

// Calculator interface is the functional interface
interface Calculator{
    // functional interface contains only 1 abstract method and can contain any number of default and static methods
    void switchOn();    // abstract method with 0 argument
}
public class CalculatorImpl {
    public static void main(String[] args) {
        // this is demo for functional interface having method with 0 arguments
        /*
        // traditional approach will be to implements Calculator interface and
        // override switchOn() method but we can use lambda expression as lambda expression are instances of functional interface
        // they will give default implementation for the only abstract method in functional interface

        // syntax :     ()          ->          {};
        // () this will contain all the arguments that the only abstract method will have
        // -> this is the arrow token which is used to link between arguments list and expression body
        // {};  this is the expression body which is used to give implementation for the only abstract method in functional interface
         */
        // below line give the implementation for switchOn() of functional interface
        Calculator switchedOnMethod = () -> System.out.println("Switched On");
        /*
        // to call the switchOn() method call it with variableName.methodName() and it will invoke the lambda expression automatically
        // since lambda expression work only for functional interface where we have only 1 umimplemented method
        // so it will invoke that unimplemented method automatically
         */
        switchedOnMethod.switchOn();
    }
}
