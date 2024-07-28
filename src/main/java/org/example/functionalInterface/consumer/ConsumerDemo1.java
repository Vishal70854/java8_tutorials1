package org.example.functionalInterface.consumer;

// this is the traditional approach(lieman approach) to override accept method of Consumer<T> interface

import java.util.function.Consumer;

public class ConsumerDemo1 implements Consumer<Integer> {
    @Override
    public void accept(Integer integer) {   // accept method will accept and int value but it never returns anything(Consumer interface functionality)
        System.out.println("printing : " +integer);
    }
    // this class will demonstrate how to use Consumer<T> interface using lambda interface

    public static void main(String[] args) {
        // traditional approach to create object of ConsumerDemo and call accept(int) method
        // the accept(t) method accepts a value as argument but does not return any value.

        Consumer<Integer> consumerDemo1 = new ConsumerDemo1();
        consumerDemo1.accept(2);
    }
}
