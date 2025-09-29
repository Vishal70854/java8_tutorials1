package org.example.functionalProgrammingExampleProjects;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// this class implements Predicate<Integer> which accepts Integer as input in test() method
class EvenNumberPredicate implements  Predicate<Integer>{

    //boolean test(T t) is the only unimplemented method since it is a Functional Interface
    @Override
    public boolean test(Integer number) {
        return number%2 == 0;   // condition to return boolean value either true or false
    }
}

// implementing Consumer<DataType> to see how lambda internally call Consumer<> when forEach() is called
class ForEachConsumerExample implements Consumer<Integer>{

    // accept(T t) is the only unimplemented method since it is a Functional Interface
    // this method accepts an input but does not return any value in return

    // when this class is called inside stream api then this method will automatically be called
    // since we have implemented Functional Interface i.e Consumer<T>
    // accept(T t) is the only unimplemented method so it will be called automatically
    @Override
    public void accept(Integer number) {
        System.out.println(number);
    }
}

//
class SquaresUsingFunction implements Function<Integer, Integer>{   // input is Integer and output is also Integer

    // below is the only unimplemented method of Function<T, R> functional interface
    // when we pass lambda in map() then automatically compiler will create implementaion of the below apply() method
    // it accepts an input and also returns and output as return value

    @Override
    public Integer apply(Integer number) {
        return number * number; // return the square of number provided in input
    }
}

public class LambdaBehindTheScreensRunner {
    public static void main(String[] args) {

        System.out.println("implementation of filter by implementing Predicate interface");
        List.of(23,43,34,45,36,48).stream()
                .filter(new EvenNumberPredicate())
                .forEach(e -> System.out.println(e));

        System.out.println("-----------------------------------------------------------");

        /*
        .filter(n -> n%2 == 0)
        when we pass logic inside filter() method or any stream api methods
        then java compiler internally creates an implementation of the required Functional Interface only unimplemented method i.e boolean test(T t)
        i.e in above case filter requires Predicate<DataType> as input and we had provided an input (n) for test() method of Predicate interface
        the return type of test() method is boolean i.e true or false
        and as per our logic we want even numbers to be printed i.e n%2 == 0
        this will check for each element in the list with condition n%2 == 0 and which are even it will be returned as output
        internally lambda will be converted to implementation of Function interface of every stream api methods which we use
        here filter() requires Predicate<T> Functional Interface so it is internally creating implementation of test() method and doing work automatically for us

        example of normal approach is above and using stream api with lambda is below

        by providing lambda, compiler will go and take the only method which is not implemented(Functional Interface has only one unimplemented method)
        and provide implementation according to the lambda provided
        i.e (n -> n%2 == 0) it will override the test method and provide implementation for that method
        where n will be input and returning boolean value as n%2== 0 for each element of the list
        in this way all even elements are printed by our lambda provided under filter method

         */

        System.out.println("implementation of filter method by using lambda to see internal working");

        List.of(23,43,34,45,36,48).stream()
                .filter(n -> n%2 == 0)
                .forEach(e -> System.out.println(e));

        // Stream<T> filter(Predicate<? super T> predicate);
        // boolean test(T t);

        System.out.println("=============================================");

        // ====================================================================
        // ====================================================================

        // creating implementation for forEach() method by
        // implementing Consumer<> interface and using forEach() under stream api

        System.out.println("implementation of forEach() method by implementing Consumer<> interface");

        List.of(34,45,21,66,78,99).stream().forEach(new ForEachConsumerExample());

        // void forEach(Consumer<? super T> action);
        // void accept(T t);

        // ------------------------------------------------------------------------
        // implementing forEach() method using lambda expression

        /*
        the forEach() method has lambda expression which has an input and some exprssion body. it does not return any value
        // since it accepts an Consumer<T> under forEach() so internally compiler will create an implementation of only unimplemented method
        in Consumer Functional Interface i.e (void accept(T t))
        the method accepts an input i.e in our lambda that is (e) and it does not return anything
        i.e our expression body has System.out.println(e) which prints the given input


        here below code is using an input e and printing out e as expression body in forEach() method
        we have provided lambda expression so it will call each element of the list and print out each element of the list
         */

        System.out.println("------------------------------------------------------");

        System.out.println("implementation of forEach() method using lambda expression to see internal working");

        List.of(34,45,21,66,78,99).stream()
                .forEach(e -> System.out.println(e));


        System.out.println("=================================================");

        /*
        ======================================================================
        ======================================================================
         */

        /*
        behind the scenes for map() method in stream api
        implementing Function(T t, R r)

         */


        System.out.println("example of map() by implementing Function<T,R> functional interface");

        List.of(34,45,21,66,78,99)
                .stream()
                .map(new SquaresUsingFunction())    // take each element and return square of each element using map()
                .forEach(e -> System.out.println(e));





        System.out.println("------------------------------------------------");

        System.out.println("implementing map() using lambda expression to see internal workings");
        /*
        when we call map() method and provide lambda expression then java compiler internally creates implementation of only unimplemented method
        since map() requires Function<T, R> (i.e Functional interface) as input so compiler will create
        implementation of (R apply(T)) method i.e only unimplemented method in Function<T,R>

        i.e map(n -> n*n) : here n is the input and it returns n*n as output(square of each number provided)
        it will create square of each number internally by calling apply() method internally and creating implemention of functinal interface


         */

        List.of(34,45,21,66,78,99)
                .stream()
                .map(n -> n * n)    // take each element and return square of each element using map()
                .forEach(e -> System.out.println(e));




    }
}
