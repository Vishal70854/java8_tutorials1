package org.example.streamAPI.maxMinExampleStreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LimitExample {
    public static void main(String[] args) {
        // find max three elements from User object using limit()
        List<User> users = Arrays.asList(
                new User("Alice", 11),
                new User("Bob", 45),
                new User("Charlie", 28),
                new User("Vishal", 98),
                new User("kumar", 64),
                new User("Singh", 20)
        );

        List<User> maxThreeUsers = users.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())  // sort in descending order by age of user
                .limit(3)   // get 3 elements
                .collect(Collectors.toList());

        System.out.println("max three users : " + maxThreeUsers);
        System.out.println("=================================================");

        // ===========================================================

        // get the minimum 3 user objects using limit()
        List<User> minThreeUsers = users.stream()
                .sorted(Comparator.comparing(User::getAge)) // sort in ascending order by age of user
                .limit(3)   // get 3 elements
                .collect(Collectors.toList());

        System.out.println("minimum three users : " +minThreeUsers);
        System.out.println("================================================");


        // ========================================================================
    }
}
