package org.example.streamAPI.mapAndFlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EKartDatabase {
    public static List<Customer> getAll(){
        return Stream.of(
                new Customer(1,"vishal","vishal@gmail.com", Arrays.asList("12312","45467")),
                new Customer(2,"rajan","rajan@gmail.com", Arrays.asList("353","8729")),
                new Customer(3,"roshan","roshan@gmail.com", Arrays.asList("5668","2443")),
                new Customer(4,"deepak","deepak@gmail.com", Arrays.asList("070","783"))
        ).collect(Collectors.toList());
    }
}
