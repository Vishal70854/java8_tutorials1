package org.example.java8ProgrammingQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static javax.swing.UIManager.get;

public class NthHighestSalaryDemo {
    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil",6500);
        map1.put("raman",9100);
        map1.put("madan",1700);
        map1.put("sonu",7000);
        map1.put("kalu",4000);
        map1.put("raju",500);
        map1.put("keshav",2000);
        map1.put("mohan",3400);


        // get nth highest salary from map
        Map.Entry<String, Integer> nthHighestSalary = getNthHighestSalary(2, map1);
        System.out.println(nthHighestSalary);
        System.out.println("==========================");

        // problem 2 : what if we have duplicate values then how to find out nth highest salary which is unique

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil",6500);
        map2.put("raman",3400);
        map2.put("madan",1700);
        map2.put("sonu",7000);
        map2.put("kalu",6500);
        map2.put("raju",500);
        map2.put("keshav",1700);
        map2.put("mohan",3400);

        Map.Entry<Integer, List<String>> salaryResult = getDynamicNthHighestSalary(3,map2);

        System.out.println(salaryResult);

    }



    public static Map.Entry<String, Integer> getNthHighestSalary(int num, Map<String, Integer> map){
        return map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // sort map in descending order by value
                .collect(Collectors.toList())
                .get(num-1);    // get the 2nd highest salary
    }

    private static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(int num, Map<String, Integer> map2) {
        Map.Entry<Integer, List<String>> salaryResult = map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(num-1);
        return salaryResult;
    }
}
