package org.example.streamAPI.mapSort;

import org.example.streamAPI.sort.example.Employee;

import java.util.*;

public class MapSortDemo {
    public static void main(String[] args) {
        // in this program we will sort map using Collections and then using stream api

        Map<String, Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("five",5);
        map.put("ten",10);
        map.put("eight",8);
        map.put("six",6);

        // convert map to List
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        System.out.println("Before sorting : " + entries);
        // sort map using Collections
        // approach 1 : using Comparator compare() method in Collections.sort(list, Comparator)
        /*
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());  // sort List<EntrySet> in ascending order of keys
            }
        });
        System.out.println("===================================================");
        */
        //=================================================================================
        // approach 2 :  using lambda expression of Comparator inplace of Comparator compare() method manual implementation
        // sort List<EntrySet> in ascending order of keys using lambda expression of compare() method of Comparator interface
        /*
        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

        System.out.println("After sorting : " + entries);
        System.out.println("===================================================");

        */
        //===========================================================================
        // sort map using stream() api based on key
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // compare each element by key
                .forEach(System.out::println);  // print each element in map
        System.out.println("===================================================");
        //===========================================================================

        // sort map using stream() api based on value
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()) // compare each element by value
                .forEach(System.out::println);  // print each element in map

        System.out.println("===================================================");
        //===========================================================================

        // sort a map of user defined object based on some salary of Employee1 object
        // we are providing comparator in Constructor of TreeMap<>() as the key is Employee Objectf
        // sort in descending order of salary of employee1
        Map<Employee1, Integer> employeeMap = new TreeMap<Employee1, Integer>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));

        employeeMap.put(new Employee1(1,"vishal","IT",600000),60);
        employeeMap.put(new Employee1(2,"rajan","mechanical",1000000),50);
        employeeMap.put(new Employee1(3,"prashant","civil",400000),70);
        employeeMap.put(new Employee1(4,"sourav","electrical",200000),30);
        employeeMap.put(new Employee1(5,"mehul","automobile",1500000),20);

        System.out.println(employeeMap);

        System.out.println("========================================================");

        // sort a map using stream() api
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee1::getSalary)))   // sort in ascending order based on salary of Employee1
                .forEach(System.out::println);  // print the map

        System.out.println("==========================================================");
    }
}

// Employee class definition
class Employee1 {
    private int id;
    private String name;
    private String dept;
    private long salary;

    public Employee1(int id, String name, String dept, long salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}

