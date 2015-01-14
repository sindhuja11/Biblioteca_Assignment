package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by Administrator on 11/01/15.
 */
public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> giveBookDetails() {
        ArrayList<Book> availablebooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAvailability()) {
                availablebooks.add(book);
            }

        }
        return availablebooks;

    }

    public boolean checkOutBook(Book book1) {
        for (Book book : books) {
            if (book.getBookName().equals(book1.getBookName())) {
                if (book.getAvailability()) {
                    book.setNotAvailable();
                    return true;
                }
            }
        }
        return false;
    }


    public boolean returningBook(String bookname) {

        for (Book book : books) {
            if (book.getBookName().equals(bookname) && !book.getAvailability()) {
                book.setAvailable();
                return book.getAvailability();
            }
            if (book.getBookName().equals(bookname) && book.getAvailability()) {
                return book.getAvailability();

            }
        }
        return false;
    }

    public Book find(String name) {
        for (Book book : books) {
            if (book.getBookName().equals(name))
                return book;
        }
        return null;
    }
}

