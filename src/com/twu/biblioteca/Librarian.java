package com.twu.biblioteca;

import org.junit.Before;

import java.util.ArrayList;

/**
 * Created by sindhum on 14/01/15.
 */
public class Librarian {
    private ArrayList<Book> books;
    public Librarian(ArrayList<Book> books) {
        this.books = books;
    }
    public void callCheckoutBook(String bookname) {
        Library lib=new Library(books);
        Book book = lib.find(bookname);


            if(lib.checkOutBook(book))
            System.out.println("Book Checked Out");

        else
            System.out.println("That book is not available");
    }

    public void callReturnBook(String bookToReturn) {
        Library library=new Library(books);
        Book book = library.find(bookToReturn);
            if(library.returnBook(book))
                System.out.println("This is not a valid book to return");
            else
            System.out.println("Thank you for returning the book");

    }
}
