package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 11/01/15.
 */
public class Library {
    static ArrayList<String> BorrowedBooks = new ArrayList<String>();
    ArrayList<Book> books;
    int noofbooks = 0;


    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public void displayOfBookDetails() {
        for (Book book : books) {
            if(book.getAvailability()==1) {
                System.out.println(book.getBookName() + "," + book.getAuthor() + "," + book.getyearPublished());

            }

        }

    }

    public void checkOutBook(String bookname) {
        int borrowedbook = 0;
        int availability = 0;
        int book;
        for ( book = 0; book <books.size(); book++) {
            if (books.get(book).getBookName().equals(bookname)) {
                availability = books.get(book).getAvailability();
                break;
            }
        }


        if (availability == 1) {
            //BorrowedBooks.add(bookname);
            System.out.println("Book Checked Out");
            books.get(book).setAvailability();

        }
        if (availability == 0) {
            System.out.println("That book is not available");
        }

    }

  /*  public void displayAfterCheckOutOfBook() {

        if(books.get(0).getAvailability()==1)
        {
            //System.out.pr
        }
        String line = "";
        int flag = 0;
        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/files/booklist");
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
            while ((line = br.readLine()) != null) {
                for (int noofbooks = 0; noofbooks < BorrowedBooks.size(); noofbooks++) {
                    if ((line.startsWith(BorrowedBooks.get(noofbooks)))) {
                        flag = 1;
                    }
                }
                if (flag == 0)
                    System.out.println(line);
                flag = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    */

//    public void unsuccessfulCheckout(String bookname) {
//        for (Book book:books) {
//            if(book.getBookName().equals(bookname)&&book.getAvailability()==0)
//            {
//                System.out.println("That book is not available");
//            }
//        }
//
//    }

    public void returningBook(String bookname) {

        for(Book book:books)
        {
            if(book.getBookName().equals(bookname)&&book.getAvailability()==0)
            {
                System.out.println("Thank you for returning the book");

            }
            if(book.getBookName().equals(bookname)&&book.getAvailability()==1)
            {                System.out.println("This is not a valid book to return");

//                new Library(books).unsuccessfullReturn(bookname);

            }
        }
       /* int flag = 0;
        if (BorrowedBooks.size() == 0) {
            return;
        } else {
            for (int noofbooks = 0; noofbooks < BorrowedBooks.size(); noofbooks++) {
                if (bookname.equals(BorrowedBooks.get(noofbooks))) {
                    flag = 1;
                    BorrowedBooks.remove(bookname);
                    System.out.println("Thank you for returning the book");

                }
            }
        }
        if (flag == 0) {
            new Library(books).unsuccessfullReturn(bookname);
        }
        */
    }

    /*
        for (int noofbooks = 0; noofbooks < BorrowedBooks.size(); noofbooks++) {
            if (!(bookname.equals(BorrowedBooks.get(noofbooks)))) {
                System.out.println("This is not a valid book to return");
            }
        }
    }*/
}

