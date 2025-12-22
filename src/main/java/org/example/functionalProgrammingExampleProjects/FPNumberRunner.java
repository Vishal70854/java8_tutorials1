package org.example.functionalProgrammingExampleProjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FPNumberRunner {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(2,5,7,21,34,9,87,56,9,5,21);
        System.out.println(numbers);
        // get sum of numbers list
        normalSum(numbers);

        // get sum of numbers list using functional programming
        SumWithFP(numbers);

        // get sum of all odd numbers
        SumOfOddNumbers(numbers);

        // get squares of each number from numbers list
        squaresOfEachNumberInList(numbers);

        // get all distinct elements
        getAllDistinctElements(numbers);

        // get squares of distinct numbers
        getSquaresOfDistinctElements(numbers);

        // get squares of 1st 10 numbers
        getSquaresOfFirst10Numbers();

        // map all of the list elements to lowercase and print them
        List<String> names = List.of("Apple","Ant","Bat","Bowl","Cat","Elephant");
        convertAllElementsToLowerCase(names);

        // print the length of each element from the names list
        printLengthOfEachElementOfList(names);

        // get the maximum element using reduce
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        SumOfElementsUsingReduceMethod(list);

        // get maximum element using max() method in stream api
        maxElementOfList(list);

        // get maximum element using max() method in stream api
        minElementOfList(list);





    }

    private static void minElementOfList(List<Integer> list) {
        Optional<Integer> minElementOfList = list.stream()
                .min((n1, n2) -> Integer.compare(n1, n2));
        System.out.println("minimum element - " + minElementOfList.get());
        System.out.println("=============================================");
    }

    private static void maxElementOfList(List<Integer> list) {
        Optional<Integer> maxElementOfList = list.stream()
                .max((n1, n2) -> Integer.compare(n1, n2));
        System.out.println("maximum element - " + maxElementOfList.get());
        System.out.println("=============================================");
    }

    private static void SumOfElementsUsingReduceMethod(List<Integer> list) {
        Integer sum = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("sum is - " + sum);
        System.out.println("============================================");
    }

    private static void printLengthOfEachElementOfList(List<String> names) {
        List<Integer> lengthOfEachElement = names.stream()
                .map(e -> e.length())
                .collect(Collectors.toList());
        System.out.println(lengthOfEachElement);
        System.out.println("===============================================");
    }

    private static void convertAllElementsToLowerCase(List<String> names) {

        List<String> convertToLowerCase = names.stream()
                .map(e -> e.toLowerCase())
                .collect(Collectors.toList());
        System.out.println(convertToLowerCase);
        System.out.println("=================================================");
    }

    private static void getSquaresOfFirst10Numbers() {
        IntStream.range(1,11)
                .map(e -> e * e)
                .forEach(e -> System.out.println(e));
        System.out.println("==================================================");
    }

    private static void getSquaresOfDistinctElements(List<Integer> numbers) {
        List<Integer> getSquaresOfDistinctNumbers = numbers.stream()
                .distinct()
                .map(e -> e * e)
                .collect(Collectors.toList());
        System.out.println(getSquaresOfDistinctNumbers);
        System.out.println("==============================================");
    }

    private static void getAllDistinctElements(List<Integer> numbers) {
        List<Integer> distinctElements = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctElements);
        System.out.println("=============================================");
    }

    private static void squaresOfEachNumberInList(List<Integer> numbers) {
        List<Integer> squaresOfEachNumber = numbers.stream()
                .map(e -> e * e)
                .collect(Collectors.toList());
        System.out.println(squaresOfEachNumber);
        System.out.println("=================================================");
    }

    private static void SumOfOddNumbers(List<Integer> numbers) {
        Integer sumOfOddNumbers = numbers.stream()
                .filter(e -> e % 2 == 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println("sum of odd numbers - " + sumOfOddNumbers);
        System.out.println("====================================================");
    }

    private static void SumWithFP(List<Integer> numbers) {
        Integer sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);// reduce method add the sum of numbers and returns sum
        System.out.println("sum with FP - " + sum);
        System.out.println("======================================================");
    }

    private static void normalSum(List<Integer> numbers) {
        int sum = 0;
        for(Integer num : numbers){
            sum += num;
        }
        System.out.println("The sum using normal loop : " + sum);
        System.out.println("====================================================");
    }
}
