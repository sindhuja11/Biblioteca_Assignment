package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by sindhum on 18/01/15.
 */
public class InputManager {
    private Librarian librarian;
    public InputManager(Librarian librarian) {
        this.librarian=librarian;
    }

    public void checkoutBook(String userName)
    {
        if(userName!=null)
        {
            System.out.println("enter the bookname");
            librarian.checkoutBook(new Scanner(System.in).nextLine(),userName);
        }
        else
            System.out.println("Please login to checkout");
    }

    public void returnBook(String userName) {
        if(userName!=null)
        {
            System.out.println("Enter the bookname");
            librarian.returnBook(new Scanner(System.in).nextLine());
        }
        else
            System.out.println("please login to return");

    }

    public void checkoutMovie(String userName) {
        if(userName!=null)
        {
            System.out.println("Enter the movie name");
            librarian.checkoutMovie(new Scanner(System.in).nextLine(),userName);
        }
        else
            System.out.println("Please login to checkout");

    }

    public void returnMovie(String userName) {
        if(userName!=null)
        {
            System.out.println("Enter the bookname");
            librarian.returnMovie(new Scanner(System.in).nextLine());
        }
        else
            System.out.println("please login to return");
    }

    public void displayCheckOutList(String userName) {
        if(userName!=null)
        {
            System.out.println("Checkout List:");
            librarian.displayCheckOutList();
        }
        else
            System.out.println("please login to view checkoutlist");
    }
}
