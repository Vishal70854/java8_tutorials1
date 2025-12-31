package org.example.java8ProgrammingQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8ProgrammingQuestions {
    public static void main(String[] args) {

        // 1. count occurences of each character in a string
        countOccurenceOfEachCharacterInAString();

        // 2. find all duplicate element from a given string
        findAllDuplicateElementsInAString();

        // 3. find all unique elements from a given string
        findUniqueElementOccurenceInAString();

        // 4. find first non-repeat element from a given string

        findFirstNonRepeatingElementFromAString();

        // 5. find 2nd highest number from given array
        findSecondLargestElementFromArray();

        // 6. find longest string from given array
        findLongestStringOfArray();

        // 7. find all elements from array who starts with 1
        findAllElementStartingWith1();

        // 8. String.join() example // convert list to string using join() method

        joinMethodDemo();


    }

    private static void joinMethodDemo() {
        List<String> nos = Arrays.asList("1", "2", "3", "4");
        String joinString = String.join("-", nos);
        System.out.println("joining all values with delimiter '-' -> " + joinString);
    }

    private static void findAllElementStartingWith1() {
        int[] numbers= {5,9,11,2,8,21,1};

        List<String> elementStartsWith1 = Arrays.stream(numbers).boxed()  // boxed() will create wrapper class of int
                .map(s -> s+"")
                .filter(e -> e.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println("elements starts with 1 : " + elementStartsWith1);
        System.out.println("================================");
    }

    private static void findLongestStringOfArray() {
        System.out.println("Find longest string of array : ");

        String[] strArray = {"java","techie","springboot","microservices","dockerk8samazonwebservice"};
        String longestStringOfArray = Arrays.stream(strArray)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get(); // .reduce("", (w1, w2) -> w1.length() > w2.length() ? w1 : w2); // if we dont want to use get() then we can use the commented code with identity value initially marked as "" in this example
        System.out.println("longest string : " + longestStringOfArray);
        System.out.println("================================");


        // approach 2
//        String longestString = Arrays.stream(strArray)
//                .sorted((a, b) -> b.length() - a.length())
//                .findFirst()
//                .get();
//        System.out.println("longest string : " + longestString);
    }

    private static void findSecondLargestElementFromArray() {
        System.out.println("find second largest element of array : ");

        int[] numbers = {5,9,11,2,8,21,1};

        Integer secondLargestElement = Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())   // sort in descending order
                .skip(1)    // skip the 1st element from list
                .findFirst()
                .get();
        System.out.println("second largest element : " +secondLargestElement);
        System.out.println("===============================");
    }

    private static void findFirstNonRepeatingElementFromAString() {
        System.out.println("find first non-repeating elements in a string");
        String s1 = "ilovejavatechie";
        String[] result = s1.split("");

//        System.out.println(Arrays.toString(result));

        String firstNonRepeatingElement = Arrays.stream(result)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,     // we want the map to be in the order as of in the string
                        Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println("first non-repeating element : " +firstNonRepeatingElement);
        System.out.println("===========================");
    }

    private static void findUniqueElementOccurenceInAString() {
        System.out.println("find unique elements in a string");
        String s1 = "ilovejavatechie";
        String[] result = s1.split("");

//        System.out.println(Arrays.toString(result));

        List<String> duplicateMap = Arrays.stream(result)
                .collect(Collectors.groupingBy(     // find occurence of each character in string
                        Function.identity(),
                        Collectors.counting()))
                .entrySet().stream()    // converted stream to map
                .filter(x -> x.getValue() == 1)  // get all elements whose occurence > 1
                .map(Map.Entry::getKey)     // get all keys of the map i.e the characters
                .collect(Collectors.toList());  // convert map to list
        System.out.println(duplicateMap);

        System.out.println("============================");
    }

    private static void findAllDuplicateElementsInAString() {
        System.out.println("find all duplicate elements in a string");
        String s1 = "ilovejavatechie";
        String[] result = s1.split("");

//        System.out.println(Arrays.toString(result));

        List<String> duplicateMap = Arrays.stream(result)
                .collect(Collectors.groupingBy(     // find occurence of each character in string
                        Function.identity(),
                        Collectors.counting()))
                .entrySet().stream()    // converted stream to map
                .filter(x -> x.getValue() > 1)  // get all elements whose occurence > 1
                .map(Map.Entry::getKey)     // .map(entry -> entry.getKey()) this will also work // get all keys of the map i.e the characters
                .collect(Collectors.toList());  // convert map to list
        System.out.println(duplicateMap);

        System.out.println("============================");
    }

    private static void countOccurenceOfEachCharacterInAString() {
        System.out.println("count all occurences of a character in a string");
        String s = "ILoveVishalKumarSingh";
        String[] results = s.split("");
        //        System.out.println(Arrays.toString(result));

        Map<String, Long> map = Arrays.stream(results)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(map);
        System.out.println("==========================");
    }
}
