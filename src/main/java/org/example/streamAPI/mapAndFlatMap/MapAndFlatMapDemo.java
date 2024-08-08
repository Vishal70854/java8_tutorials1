package org.example.streamAPI.mapAndFlatMap;

import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMapDemo {
    public static void main(String[] args) {
        // this program is a demo of map() and flatMap() methods in stream api in java8

        // get List<Customer> in customers variable below
        List<Customer> customers = EKartDatabase.getAll();

//        =============================================================================
//        List<Customer> convert to List<String> -> Data Transformation
//        it means we are mapping emails only from List<Customer> using map() in stream() api
        List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
        System.out.println(emails);

//        =================================================================================
        // fetch List<phoneNumber> from List<Customer>
        List<List<String>> phoneNumbers = customers.stream()
                .map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);

//        ================================================================================
        // using flatMap() to flatten List<List<>> into List<>
        // when we have to convert nested list to list then we use flatMap() in stream api
        // here we will convert List<List<String>>(phoneNumber) into List<String> using flatMap()
        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phones);

    }
}
