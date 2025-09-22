package org.example.streamAPI.mapReduceExample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

        // iterative approach
        int sum = 0;
        for(int no: numbers){
            sum += no;
        }
        System.out.println(sum);
        System.out.println("===============================================================");

        // using stream api to get sum() of numbers list elements
        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);
        System.out.println("===============================================================");

        // using reduce() method in stream api to get sum of numbers list elements
        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);
        System.out.println("===============================================================");

        // using method reference along with reduce() method to get the sum of numbers list
        Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceSumWithMethodReference.get());
        System.out.println("===============================================================");

        // use reduce() method to perform multiplication
        Integer reduceMultiply = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(reduceMultiply);
        System.out.println("===============================================================");

        // get maximum element using reduce()
        Integer maxValue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxValue);
        System.out.println("===============================================================");

        // get minimum element using reduce()
        Integer minValue = numbers.stream().reduce(0, (a, b) -> a < b ? a : b);
        System.out.println(minValue);
        System.out.println("===============================================================");

        // getting max element using Method Reference
        Integer maxValueWithMethodReference = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxValueWithMethodReference);
        System.out.println("===============================================================");

        // ===========================================================================
        List<String> words = Arrays.asList("core java","spring","hibernate","java programming");

        // find longest string using reduce() method
        String maxLengthString = words.stream().reduce("", (a, b) -> a.length() > b.length() ? a : b);
        System.out.println(maxLengthString);
        System.out.println("===============================================================");

        // find shortest string using reduce() method
        String minLengthString = words.stream().reduce("", (a, b) -> a.length() < b.length() ? a : b);
        System.out.println(minLengthString);
        System.out.println("===============================================================");






    }

}
