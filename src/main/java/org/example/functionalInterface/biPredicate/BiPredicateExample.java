package org.example.functionalInterface.biPredicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {

        // anonymous implementation of BiPredicate
        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s1, String s2) {
                return s1.equals(s2);
            }
        };

        System.out.print(" anonymous implementation : ");
        System.out.println(biPredicate.test("madam","madam"));

        System.out.println("============================================");

        // lambda expression example
        BiPredicate<String, String> equalsPredicate = (s1,s2) -> s1.equals(s2);
        BiPredicate<String, String> lengthPredicate = (s1,s2) -> s1.length() == s2.length();

        // and() method implementation
        System.out.print("lambda expression implementation : ");
        boolean andOutput = equalsPredicate.and(lengthPredicate).test("madam","madam");

        System.out.println("output : " + andOutput);

        // or() method implementation
        boolean orOutput = equalsPredicate.or(lengthPredicate).test("abc","def");
        System.out.println("OrOutput : " + orOutput);

        System.out.println("================================================");




    }
}
