package org.example.streamAPI.convertListToMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurencesUsingCounting {
    public static void main(String[] args) {
        // example 1

        List<Integer> arr = Arrays.asList(1, 2, 2, 3, 3, 3);

        // approach 1
        Map<Integer, Long> occurrenceMap = arr.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); //Function.identity() will give the same String object values as key field
        System.out.println("Printing occurence of each words in arr ArrayList");
        System.out.println(occurrenceMap);
        // The map will contain {1=1, 2=2, 3=3}.

        System.out.println("============================================================");

        // example 2
        List<String> list = new ArrayList<>(Arrays.asList("Foo", "Bar", "Bar", "Bar", "Foo"));

        Map<String, Long> countingList = list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())); //Function.identity() will give the same String object values as key field
        System.out.println("Printing occurence of each words in list ArrayList");
        System.out.println(countingList);

        System.out.println("==================================================");

        // example 3
        List<String> list1 = new ArrayList<>(Arrays.asList("Adam", "Bill", "Jack", "Joe", "Ian","Vish","Vick","Shiv","Gau"));

        Map<Integer, Long> countingList2 = list1.stream()
                .collect(Collectors.groupingBy(String::length,Collectors.counting()));
        System.out.println("Printing occurence of each words in list1 ArrayList");
        System.out.println(countingList2);


    }
}
