package org.example.streamAPI.mapAndFlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static Customer getCustomerByEmailId(String email) throws Exception {
        List<Customer> customers = EKartDatabase.getAll();
        return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().orElseThrow(() -> new Exception("no customer found with the given email id " + email));

    }

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer(101,"john",null, Arrays.asList("2425","6647","23957239"));

        // empty
        //of
        //ofNullable

        // demo for empty() method in Optional class
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

//        ================================================================================
        // demo for of() method in Optional class
        // we will use Optional.of(value) when we are sure that the value we are searching for is not null
        // otherwise it will throw null pointer exception
//        Optional<String> emailOptional = Optional.of(customer.getEmail());
//        System.out.println(emailOptional);


//        ================================================================================

        // demo for ofNullable(value) of Optional class
        // Optional.ofNullable(value) consists of both of() and empty() method and we can use it if our value is null
        Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
//        if(emailOptional2.isPresent()){
//            System.out.println(emailOptional2.get());
//        }

//        ================================================================================



        // if value doesnot exists then we can return manual values using orElse() method
        System.out.println(emailOptional2.orElse("default@gmail.com")); // print default@gmail.com if email is null

        // throw IllegalArgumentException using orElseThrow() method in Optional class if value is not found
//        System.out.println(emailOptional2.orElseThrow(() -> new IllegalArgumentException("value doesn't exists!"))); // print default@gmail.com if email is null


        // we will change the value to upper case if value is present otherwise orElseGet() method will be executed
        // which expects a Supplier interface lambda expression
        System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(() -> "default email..."));


        // call the getCustomerByEmailId() method
        System.out.println(getCustomerByEmailId("john@gmail.com"));

    }
}
