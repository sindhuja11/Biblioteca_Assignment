package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 11/01/15.
 */
public class BibliotecaBorrowedbooks {
    static ArrayList<String> BorrowedBooks=new ArrayList<String>();

    public void CheckOutBook(Scanner input) {
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
        }

            }

    public void DisplayAfterCheckOutOfBook()
    {
        String line="";

        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/com/twu/biblioteca/booklist");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if(!(line.startsWith(BorrowedBooks.get(0))))
                {
                    System.out.println(line);
                }

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void UnsuccessfulCheckout(String bookname) {
           String bookborrowed = BorrowedBooks.get(0);
            if (bookborrowed.equals(bookname)) {
                System.out.println("That book is not available");
            }
        }


    public void ReturningBook(String bookname) {
        if(BorrowedBooks.size()==0)
        {
            return;
        }
        else {
            for(int noofbooks=0;noofbooks<BorrowedBooks.size();noofbooks++) {
                if (bookname.equals(BorrowedBooks.get(noofbooks))) {
                    BorrowedBooks.remove(bookname);
                    System.out.println("Thank you for returning the book");

                }
            }
        }
    }

    public void UnsuccessfullReturn(String bookname) {
    if(bookname.equals(BorrowedBooks.get(0)))
    {
        System.out.println("This is not a valid book to return");
    }
    }
}
