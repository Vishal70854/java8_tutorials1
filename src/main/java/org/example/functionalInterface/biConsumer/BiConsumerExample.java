package org.example.functionalInterface.biConsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
// this class implements BiConsumer<String, Integer> to show basic implementation
public class BiConsumerExample implements BiConsumer<String, Integer> {
    @Override
    public void accept(String i1, Integer i2) {
        System.out.println("input 1 " + i1 + " : input 2 " + i2);
    }

    public static void main(String[] args) {
        BiConsumer<String, Integer> biConsumer = new BiConsumerExample();
        biConsumer.accept("vishalKumar",530);

        System.out.println("=================================================");

        //====================================================
        // anonymous implementation of BiConsumer interface

        BiConsumer<String, Integer> biConsumer1 = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String i1, Integer i2) {
                System.out.println(i1 + " : " + i2);

            }
        };
        System.out.print("anonymous impl -> ");
        biConsumer1.accept("kumar",234);

        System.out.println("==============================================");

        //===================================================

        // using lambda expression

        BiConsumer<String, Integer> biConsumer2 = (i1,i2) -> System.out.println("key " + i1 + " : value " + i2);

        System.out.print("lambda expression example -> ");
        biConsumer2.accept("welcome",48);

        System.out.println("================================================");
        // ===================================================

        // real time example of BiConsumer is map.forEach()
        Map<String, Integer> map = new HashMap<>();
        map.put("basant",5000);
        map.put("vishal",7000);
        map.put("kumar",3000);
        map.put("rohan",4500);

//        map.forEach(biConsumer1);
        // using lambda expression
        map.forEach((k,v) -> System.out.println("key " + k + " , value " + v));

    }
}
