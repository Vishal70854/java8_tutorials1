package org.example.streamAPI.mapSort;

import java.util.*;
import java.util.stream.Collectors;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}


public class MapSortInterviewQuestions {
    public static void main(String[] args) {

        // Example 1: Using TreeMap (natural ascending order)

        Map<String, Integer> map = Map.of("b", 2, "a", 1, "c", 3);

// TreeMap automatically sorts by keys
        Map<String, Integer> sortedByKeys = new TreeMap<>(map);

        System.out.println("Keys sorted ascending: " + sortedByKeys.keySet());

        System.out.println("============================================================");

        // Example 2: Using Streams (descending order)
        Map<String, Integer> map1 = Map.of("b", 2, "a", 1, "c", 3);

        List<String> keysDesc = map1.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Keys sorted descending: " + keysDesc);

        System.out.println("============================================================");

        // Sorting a Map by Values
        //Example 1: Using Streams (ascending order)
        Map<String, Integer> map2 = Map.of("b", 2, "a", 3, "c", 1);

        List<Integer> sortValuesInAscending = map2.values().stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("values() sorted ascending : " +sortValuesInAscending);


                        // OR
        /*
        List<Map.Entry<String, Integer>> sortedByValuesAsc = map2.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toList());
        System.out.println(sortedByValuesAsc);
        */
        System.out.println("============================================================");


        // sort user defined object in Map based on keys and values
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(3, new User("Alice", 30));
        userMap.put(1, new User("Bob", 25));
        userMap.put(2, new User("Charlie", 35));

        // Sort entries by key (ascending)
        List<Integer> keysAsc = userMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())   // natural order
                .map(Map.Entry::getKey) // .map(entry -> entry.getKey())    // both method reference and lambda styles are written for understanding
                .collect(Collectors.toList());
        System.out.println(keysAsc);

                    //OR
        /*
        // ✅ Extract only keys sorted by User age
        List<Integer> keysByAge = userMap.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().getAge()))
                .map(Map.Entry::getKey)   // <-- this extracts only keys    // // .map(entry -> entry.getKey())    // both method reference and lambda styles are written for understanding
                .collect(Collectors.toList());

         */
        System.out.println("============================================================");

        // Sort entries by key (descending)
        List<Integer> keysDesc1 = userMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .map(Map.Entry::getKey) // .map(entry -> entry.getKey())    // both method reference and lambda styles are written for understanding
                .collect(Collectors.toList());
        System.out.println(keysDesc1);

        System.out.println("============================================================");


        // sort values (User object) in map using stream api
        // Sort entries by User age
        List<Integer> keysByAge = userMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(User::getAge)))
                .map(Map.Entry::getKey) // // .map(entry -> entry.getKey())    // both method reference and lambda styles are written for understanding
                .collect(Collectors.toList());

        System.out.println("Keys sorted by age: " + keysByAge);

        System.out.println("============================================================");


        // Sort entries by User name
        List<Integer> keysByName = userMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(User::getName)))
                .map(Map.Entry::getKey)     // // .map(entry -> entry.getKey())    // both method reference and lambda styles are written for understanding
                .collect(Collectors.toList());

        System.out.println("Keys sorted by name: " + keysByName);

    }
}
