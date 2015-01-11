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
    public String CheckOutBook(Scanner input) {
        String bookname=input.next();
        BorrowedBooks.add(bookname);

        return "Book Checked Out";
    }
    public void DisplayAfterCheckOutOfBook()
    {
        String line="";

        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/com/twu/biblioteca/booklist");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if(line.startsWith(BorrowedBooks.get(0)))
                {

                }
                else
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
