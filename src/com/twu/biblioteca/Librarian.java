package com.twu.biblioteca;

import java.util.ArrayList;

public class Librarian {
    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public void checkoutBook(String bookName) {
        Book book = library.find(bookName);
        if (library.checkOutBook(book))
            System.out.println("Book Checked Out");
        else
            System.out.println("That book is not available");
    }

    public void returnBook(String bookToReturn) {
        Book book = library.find(bookToReturn);
        if (library.returnBook(book))
            System.out.println("This is not a valid book to return");
        else
            System.out.println("Thank you for returning the book");

    }


    public void giveBookList() {
        ArrayList<Book> books=library.giveBookDetails();
        for(int noofbooks=0;noofbooks<books.size();noofbooks++)
        {
            System.out.println(books.get(noofbooks).getBookName()+","+books.get(noofbooks).getAuthor()+","+books.get(noofbooks).getyearPublished());
        }
    }
}
