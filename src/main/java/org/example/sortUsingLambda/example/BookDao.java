package org.example.sortUsingLambda.example;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public List<Books> getBooks(){
        List<Books> books = new ArrayList<>();
        books.add(new Books(5,"Groovy",67));
        books.add(new Books(4,"Kotlin",78));
        books.add(new Books(3,"C#",12));
        books.add(new Books(1,"Java",45));
        books.add(new Books(2,"Python",32));

        return books;
    }

}
