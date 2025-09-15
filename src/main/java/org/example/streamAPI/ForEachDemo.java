package org.example.streamAPI;

import java.util.*;

public class ForEachDemo {
    public static void main(String[] args) {
        // in this program we will work on stream API for forEach() and filter() methods

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("mango");
        list.add("orange");
        list.add("papaya");
        list.add("pineapple");

        // print list using normal for-loop
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("=====================================================");

        // iteration using stream API
        // list.stream() will convert list into stream and we will be able to use all stream api methods
        // forEach() internally uses Consumer interface which implements accept(t) method which takes a parameter but didn't return anything
        list.stream().forEach(t -> System.out.println(t));
        System.out.println("=====================================================");

        // ======================================================================
        // iterate over a map using forEach() and streamApi forEach() methods
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");

        // ======================================================================

        // print map using normal forEach() using lambda expression of Consumer interface
        // here we are not including stream api as of now
        map.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("=====================================================");
        // ======================================================================

        // print the map using stream api forEach()
        // to convert map to stream first convert it to entrySet() where entire key,value will be converted as a obj(entry set)
        map.entrySet().stream()
//                .forEach(obj -> System.out.println(obj));   // 1=a,2=b,3=c,4=d
                .forEach(obj1 -> System.out.println(obj1.getKey() + " -> " + obj1.getValue())); // 1->a,2->b,3->c,4->d // to get key and value separately use obj1.getKey(), obj1.getValue()

        System.out.println("=====================================================");
        // ======================================================================



    }
}
