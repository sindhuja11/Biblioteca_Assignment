package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 11/01/15.
 */
public class Librarian {
    static ArrayList<String> BorrowedBooks=new ArrayList<String>();

    public void checkOutBook(Scanner input) {
        String bookname=input.nextLine();
        int borrowedbook=0;
        //BorrowedBooks.add("Digital Fortress");
        for(int noofbooks=0;noofbooks<BorrowedBooks.size();noofbooks++) {
            if (BorrowedBooks.get(noofbooks).equals(bookname))
            {
                borrowedbook=1;
            }

        }
        if(borrowedbook==0) {
            BorrowedBooks.add(bookname);

            System.out.println("Book Checked Out");
           // new Librarian().displayAfterCheckOutOfBook();
        }
        if(borrowedbook==1)
        {
            new Librarian().unsuccessfulCheckout(bookname);
        }

    }
    public void displayAfterCheckOutOfBook()
    {
        String line="";
        int flag=0;
        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/com/twu/biblioteca/booklist");
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
            while ((line = br.readLine()) != null) {
                for(int noofbooks=0;noofbooks<BorrowedBooks.size();noofbooks++) {
                    if ((line.startsWith(BorrowedBooks.get(noofbooks)))) {
                        flag=1;
                        //System.out.println(line);
                        //break;
                    }
//                    else
//                      break;
                }
                if(flag==0)
                    System.out.println(line);
                flag=0;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void unsuccessfulCheckout(String bookname) {
        for(int noofbooks=0;noofbooks<BorrowedBooks.size();noofbooks++) {

            String bookborrowed = BorrowedBooks.get(noofbooks);
            if (bookborrowed.equals(bookname)) {
                System.out.println("That book is not available");
            }
        }
    }
    public void returningBook(String bookname) {
        int flag=0;
        if(BorrowedBooks.size()==0)
        {
            return;
        }
        else {
            for(int noofbooks=0;noofbooks<BorrowedBooks.size();noofbooks++) {
                if (bookname.equals(BorrowedBooks.get(noofbooks))) {
                    flag=1;
                    BorrowedBooks.remove(bookname);
                    System.out.println("Thank you for returning the book");

                }
            }
        }
        if(flag==0)
        {
            new Librarian().unsuccessfullReturn(bookname);
        }
    }

    public void unsuccessfullReturn(String bookname) {
        for(int noofbooks=0;noofbooks<BorrowedBooks.size();noofbooks++) {
            if (!(bookname.equals(BorrowedBooks.get(noofbooks)))) {
                System.out.println("This is not a valid book to return");
            }
        }
    }
    }

