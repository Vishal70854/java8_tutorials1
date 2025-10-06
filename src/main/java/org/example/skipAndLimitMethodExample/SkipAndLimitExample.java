package org.example.skipAndLimitMethodExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SkipAndLimitExample {

    public static void main(String[] args) throws IOException {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // skip 1st element and print next 7 elements
        // we will be using skip() and limit() methods
        numbers.stream()
                .skip(2) // skip first 2 elements from numbers list. i.e here (1,2) will be skipped, counting will be started from 3 onwards
                .limit(7)   // get me 7 elements using limit(n)
                .forEach(System.out::print);

        System.out.println("\n======================================");

        // read a data.txt file to remove header and footer from java8
        // skip(1) will skip the header for files and we have mentioned skip(1) so only header will be removed
        // limit(n) will print n rows from file data.txt... below is the example

        List<String> fileData = Files.readAllLines(Paths.get("data.txt"));

        int size = fileData.size();
        System.out.println("size of data.txt file : " + size);

        fileData.stream()
                .skip(1)    // skip the header of file since we mentioned skip(1)
                .limit(size-2)   // limit(5) will print 5 rows from data.txt
                .forEach(System.out::println);


    }







}
