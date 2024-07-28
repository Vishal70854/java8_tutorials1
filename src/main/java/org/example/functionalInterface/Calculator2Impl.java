package org.example.functionalInterface;
interface Calculator2{
    int subtract(int i1, int i2);   // abstract method with 2 arguments and return type
}

public class Calculator2Impl {
    public static void main(String[] args) {
        // lambda expression example with 2 argument list and return type
        // since we have more than 1 line of expression body that's why we are enclosing it within {}
        // Calculator2 calculator2 = (i1, i2) -> i2 - i1;    // one line lambda expression which return i2-i1 of the above method i.e subtract(i1,i2)

        Calculator2 calculator2 = (i1, i2) -> {
            if(i2 < i1){
                throw new RuntimeException("i2 should be greater than i1");
            }
            else{
                return i2 - i1;
            }
        };
        // call the subtract(i1,i2) method
        System.out.println(calculator2.subtract(8,20));
    }
}
