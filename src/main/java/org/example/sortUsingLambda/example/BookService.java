package org.example.sortUsingLambda.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {
    // main method
    public static void main(String[] args) {
        BookService bookService = new BookService();
        System.out.println(bookService.getBooksInSort());
    }

    public List<Books> getBooksInSort(){
        List<Books> books = new BookDao().getBooks();
        // sort the List<Books> using custom comparator which we have created for sorting List<Objects>
        //======================================================
        // approach 1 create separate class for Comparator and create object in Collections.sort(Books, new MyNameComparator());*/
        /*Collections.sort(books, new MyNameComparator());
        //=======================================================
        // approach 2 : override the compare() method of Comparator in Collections.sort() method only as shown below
         */
       /* Collections.sort(books, new Comparator<Books>() {   // overridden Comparator<Object> which needs to sort
            @Override
            public int compare(Books o1, Books o2) {
                return o1.getName().compareTo(o2.getName());    // ascending order sort on the basis of name of Books
            }
        });
        */
        //================================================================
        // approach 3 :  using lambda expression in place of overriding Comparator<Object>
        Collections.sort(books, (i1,i2) -> i1.getName().compareTo(i2.getName()));   // ascending order sort on the basis of name of Books

        return books;

    }

}

// custom comparator class for sorting List<Objects>
/*
class MyNameComparator implements Comparator<Books>{
    @Override
    public int compare(Books b1, Books b2) {
//        return b1.getName().compareTo(b2.getName());    //  ascending order sort on the basis of name of Books
        return b2.getName().compareTo(b1.getName());    //  descending order sort on the basis of name of Books
    }
}
*/
