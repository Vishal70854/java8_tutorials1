package org.example.streamAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class FilterDemo {
    public static void main(String[] args) {
        // here we will discuss filter() method in stream API

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("mango");
        list.add("orange");
        list.add("papaya");
        list.add("pineapple");

        // iterate over the list using normal for loop and filter out things using if-else
        for(String s : list){
            if(s.startsWith("p")){
                System.out.println(s);
            }
        }
        System.out.println("====================================================");

        // iterate over the list using stream and filter out the stream using filter(Predicate)
//        t -> t.startsWith("p");   // lambda expression of test method of Predicate interface filtering out list which starts with letter "p"
        list.stream()
                .filter(t -> t.startsWith("p")) // filter out element which starts with "p"
                .forEach(t -> System.out.println(t)); // print the filtered out element

        System.out.println("====================================================");

        // iterate over a map using filter(), forEach() and streamApi forEach() methods
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");

        map.entrySet().stream()
                .filter(k -> k.getKey()%2 == 0)
                .forEach(obj -> System.out.println(obj));

    }
}
