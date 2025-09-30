package org.example.functionalInterface.biFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// this class implements BiFunction<T,U,R> and override the apply() method to showcase traditional approach
// of BiFunction interface
public class BiFunctionExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {
    @Override
    public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
        return Stream.of(list1, list2)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

    }

    public static void main(String[] args){

        // traditional approach of implementing BiFunction<T,U,R> and overriding apply(T,R)
        BiFunction biFunction = new BiFunctionExample();
        List<Integer> list1 = Stream.of(1,23,4,6,7,9,19).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(11,3,43,6,7,19).collect(Collectors.toList());
        Object result = biFunction.apply(list1, list2);
        System.out.println("Traditional approach : " + result);

        System.out.println("==================================================");

        // anonymous implementation

        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction1 = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> integers, List<Integer> integers2) {
                return Stream.of(list1, list2)
                        .flatMap(List::stream)
                        .distinct()
                        .collect(Collectors.toList());
            }
        };

        System.out.println("anonymous impl : " + biFunction1.apply(list1, list2));

        System.out.println("===========================================================");

        // lambda expression implementation

        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction2 = (l1,  l2) -> {
            return Stream.of(l1, l2)
                    .flatMap(List::stream)
                    .distinct()
                    .collect(Collectors.toList());
        };

        System.out.println("lambda expression impl : " + biFunction2.apply(list1,list2));

        System.out.println("========================================================");

        // ================================================================
        System.out.println("real time implementation of BiFunction Interface !!!");

        Map<String, Integer> map = new HashMap<>();
        map.put("basant",5000);
        map.put("vishal",7000);
        map.put("kumar",3000);
        map.put("rohan",4500);

        BiFunction<String, Integer, Integer> increaseSalaryByFunction = new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String key, Integer value) {
                return value + 1000;
            }
        };

//        map.replaceAll(increaseSalaryByFunction);
//        System.out.println("BiFunctional real time example using map : " + map);

        System.out.println("------------------------------------");
        // example using lambda of BiFunction in map.replaceAll()


//        BiFunction<String, Integer, Integer> increaseSalByFunction = (key,  value) ->  value + 2000;
        map.replaceAll((key,  value) ->  value + 2000);  // same as         map.replaceAll(increaseSalByFunction);


        System.out.println("BiFunctional real time lambda example using map : " + map);
        System.out.println("===========================================================");






    }
}
