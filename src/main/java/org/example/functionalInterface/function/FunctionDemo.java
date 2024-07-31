package org.example.functionalInterface.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        // in this class we will perform operation on Function<T,R> interface

        // function which takes string as input and returns int as output
        Function<String, Integer> function = x -> x.length();
        // call the function apply method
        System.out.println(function.apply("vishal"));

        // function which takes String as input and returns a string which contains only 1st 3 characters of that string
        Function<String, String> function2 = s -> s.substring(0,3);
        System.out.println(function2.apply("manav"));

        // function which takes List<Student> as input and returns List<Student> as output based on "vip" as prefix for each student name
        Function<List<Student>, List<Student>> studentsWithVipAsPrefix = li ->{
            List<Student> result = new ArrayList<>();   // output array list
            for(Student s : li){
                if(function2.apply(s.getName()).equalsIgnoreCase("vip")){
                    result.add(s);  // add the Student object in result arraylist
                }
            }
            return result;
        };

        Student student1 = new Student(1, "vipul");
        Student student2 = new Student(2, "viplav");
        Student student3 = new Student(3, "manav");
        List<Student> students = Arrays.asList(student1, student2, student3);
        List<Student> filteredStudents = studentsWithVipAsPrefix.apply(students);

        System.out.println(filteredStudents);
        System.out.println("========================================================");

        //===================================================================
        // function chaining using andThen() and compose() methods
        // function chaining means run a function after another function
        Function<String, String> function3 = x -> x.toUpperCase();  // change string to upper case
        Function<String, String> function4 = x -> x.substring(0,3); // get the 1st 3 characters of the string

        Function<String, String> stringStringFunction = function3.andThen(function4);   // first execute function3 then execute function4
        System.out.println(stringStringFunction.apply("vishal"));
        // it can also be written as function3.andThen(function4).apply("vishal");

        // example 2 of function chaining
        Function<Integer, Integer> function5 = x -> 2 * x;      // return 2 * x
        Function<Integer, Integer> function6 = x -> x * x * x;  // return x*x*x
        System.out.println(function5.andThen(function6).apply(3));

        //================================================================
        // in the above example if we want 2nd function to run 1st and then run 1st function then we use compose()
        // i.e first run function6 and then run function5 using compose() as shown below
        // this is the slight difference between andThen() and compose() method in Function
        System.out.println(function5.compose(function6).apply(3));

        // identity() method in Function
        // identity() is a static method which takes an input and returns the same input as the output
        // there is no change in input and output as identity() is just used to return the input as output to the user

        Function<String, String> identity = Function.identity();    // take String as input and return String as output(return the same value which is input as output to the user)
        System.out.println(identity.apply("vishal"));   // print "vishal" as output

    }

    // static inner class
    private static class Student{
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
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

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
