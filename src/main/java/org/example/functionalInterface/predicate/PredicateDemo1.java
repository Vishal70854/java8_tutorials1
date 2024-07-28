package org.example.functionalInterface.predicate;

import java.util.function.Predicate;

public class PredicateDemo1 implements Predicate<Integer> {
    @Override
    public boolean test(Integer t) {
        if(t%2 == 0){   // t is even number
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        // we will follow the traditional approach to implement Predicate<T> where T can be any object
        // and override boolean test(t) that returns a boolean value

        Predicate<Integer> predicate= new PredicateDemo1();
        System.out.println(predicate.test(21));
    }

}
