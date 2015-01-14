package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by Administrator on 11/01/15.
 */
public class Library {
    ArrayList<Book> books;


    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public void displayOfBookDetails() {
        for (Book book : books) {
            if (book.getAvailability() == 1) {
                System.out.println(book.getBookName() + "," + book.getAuthor() + "," + book.getyearPublished());

            }

        }

    }

    public void checkOutBook(String bookname) {
        int availability = 0;
        int book;
        for (book = 0; book < books.size(); book++) {
            if (books.get(book).getBookName().equals(bookname)) {
                availability = books.get(book).getAvailability();
                break;
            }
        }


        if (availability == 1) {
            System.out.println("Book Checked Out");
            books.get(book).setAvailability();

        }
        if (availability == 0) {
            System.out.println("That book is not available");
        }

    }


    public void returningBook(String bookname) {

        for (Book book : books) {
            if (book.getBookName().equals(bookname) && book.getAvailability() == 0) {
                System.out.println("Thank you for returning the book");

            }
            if (book.getBookName().equals(bookname) && book.getAvailability() == 1) {
                System.out.println("This is not a valid book to return");


            }
        }

    }
}

