package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by Administrator on 11/01/15.
 */
public class Library {
    private ArrayList<Book> books;
    private static ArrayList<Book> borrowedbooks=new ArrayList<Book>();
    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> giveBookDetails() {
    return books;
    }

    public boolean checkOutBook(Book book1) {

            if(books.contains(book1)) {
                books.remove(book1);
                borrowedbooks.add(book1);
                return true;
            }
        return false;

    }


    public boolean returnBook(Book bookToReturn) {

            if(books.contains(bookToReturn)) {
                return true;
            }
            else
            {
                books.add(bookToReturn);
                borrowedbooks.remove(bookToReturn);
                return false;

            }

    }

    public Book find(String name) {
        for (Book book : books) {
            if (book.getBookName().equals(name))
                return book;
        }
        for (Book book : borrowedbooks) {
            if (book.getBookName().equals(name))
                return book;
        }

        return null;
    }
}

