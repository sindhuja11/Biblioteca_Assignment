package com.twu.biblioteca;

public class Librarian {
    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public void callCheckoutBook(String bookName) {
        Book book = library.find(bookName);
        if (library.checkOutBook(book))
            System.out.println("Book Checked Out");
        else
            System.out.println("That book is not available");
    }

    public void callReturnBook(String bookToReturn) {
        Book book = library.find(bookToReturn);
        if (library.returnBook(book))
            System.out.println("This is not a valid book to return");
        else
            System.out.println("Thank you for returning the book");

    }
}
