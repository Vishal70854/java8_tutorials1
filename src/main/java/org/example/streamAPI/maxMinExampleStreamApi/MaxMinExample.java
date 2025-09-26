package org.example.streamAPI.maxMinExampleStreamApi;

import java.util.*;

public class MaxMinExample {
    public static void main(String[] args) {
        // get the maximum element from a list using java8

        List<Integer> numbers = Arrays.asList(10, 45, 32, 67, 23,90);
        Optional<Integer> max = numbers.stream().max(Integer::compare); // this will compare all elements and get maximum element
        System.out.println("maximum element : " + max.get());
        System.out.println("=========================================================");
        //========================================================================

        // get the minimum element from numbers list
        Optional<Integer> min = numbers.stream().min(Integer::compare); // this will compare all elements and get minimum element
        System.out.println("minimum element : " + min.get());
        System.out.println("=======================================================");
        //=======================================================================

        // get the third maximum element from numbers list
        Integer thirdMaxElement = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())  // sort in descending order //( we can use this also to sort in descending .sorted((a, b) -> b - a))
                .skip(2)    // skip the first 2 elements from list
                .findFirst()    // find the first element from list
                .get();

        System.out.println("third maximum element : " + thirdMaxElement);
        System.out.println("==========================================================");
        // ==========================================================================

        // get the third smallest element from numbers list
        Integer thirdMinElement = numbers.stream()
                .distinct() // get all the distinct elements of the list
                .sorted()   // sort in ascending order
                .skip(2)    // skip first 2 elements from list
                .findFirst()    // find the first element after skipping
                .get();

        System.out.println("third minimum element : " + thirdMinElement);
        System.out.println("======================================================");
        // =====================================================================

        // get max element of list of User object

        List<User> users = Arrays.asList(
                new User("Alice", 30),
                new User("Bob", 45),
                new User("Charlie", 28),
                new User("Vishal", 98),
                new User("kumar", 64),
                new User("Singh", 20)
        );

        // get max User object with max age
        Optional<User> maxUser = users.stream().max(Comparator.comparing(User::getAge));    // get max User object with max age

        System.out.println("maximum user object : " + maxUser.get());
        System.out.println("=================================================");

        //-----------------------------------
        // get min User object with max age
        Optional<User> minUser = users.stream()
                .min(Comparator.comparing(User::getAge));    // get max User object with max age

        System.out.println("minimum user object : " + minUser.get());
        System.out.println("==============================================");

        //-----------------------------------------------------\
        // get 3rd max element from user object
        User thirdMaxUser = users.stream()
                .sorted((a,b) -> b.getAge() - a.getAge())   // sort in descending order by user age
                .skip(2)    // skip first 2 elements
                .findFirst()    // find the first element after skipping 2 elements
                .get();
        System.out.println("third max user :" + thirdMaxUser);
        System.out.println("===================================================");

        // ---------------------------------------------------------------
        // third minimum user object
        User thirdMinUser = users.stream()
                .sorted((a,b) -> a.getAge() - b.getAge())   // sort in ascending order by user age
                .skip(2)    // skip first 2 elements
                .findFirst()    // find the first element after skipping 2 elements
                .get();
        System.out.println("third min user :" + thirdMinUser);



    }
}
