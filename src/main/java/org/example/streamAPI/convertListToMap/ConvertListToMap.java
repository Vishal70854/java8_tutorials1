package org.example.streamAPI.convertListToMap;

// Java program for list convert  in map
// with the help of Collectors.toMap() method

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// create a list
class Student {

    // id will act as Key
    private Integer id;

    // name will act as value
    private String name;

    // create curstuctor for reference
    public Student(Integer id, String name)
    {

        // assign the value of id and name
        this.id = id;
        this.name = name;
    }

    // return private variable id
    public Integer getId()
    {
        return id;
    }

    // return private variable name
    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

// main class and method
public class ConvertListToMap {

    // main Driver
    public static void main(String[] args)
    {

        // create a list
        List<Student> lt = new ArrayList<>();

        // add the member of list
        lt.add(new Student(1, "Vishal"));
        lt.add(new Student(2, "Vicky"));
        lt.add(new Student(3, "Gaurav"));

        // create map with the help of
        // Collectors.toMap() method

        Map<Integer, String>
                map = lt.stream()
                .collect(Collectors.toMap(
                                        Student::getId,
                                        Student::getName));

        // print map
        map.forEach((x, y) -> System.out.println(x + "=" + y));

        // example 2
        // using key as name of Student and value as Student object

        Map<String, Student> collect = lt.stream()
                .collect(Collectors.toMap(Student::getName, Function.identity()));  // Function.identity() will give the same Student object as value field
        System.out.println(collect);
    }
}
