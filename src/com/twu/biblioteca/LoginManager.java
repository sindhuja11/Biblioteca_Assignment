package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by sindhum on 18/01/15.
 */
public class LoginManager {
    private Librarian librarian;
    public LoginManager(Librarian librarian) {
        this.librarian=librarian;
    }

    public void checkoutBook(User user)
    {
        if(user!=null)
        {
            System.out.println("enter the bookname");
            librarian.checkoutBook(new Scanner(System.in).nextLine(), user.getName());
        }
        else
            System.out.println("Please login to checkout");
    }

    public void returnBook(User user) {
        if(user!=null)
        {
            System.out.println("Enter the bookname");
            librarian.returnBook(new Scanner(System.in).nextLine());
        }
        else
            System.out.println("please login to return");

    }

    public void checkoutMovie(User user) {
        if(user!=null)
        {
            System.out.println("Enter the movie name");
            librarian.checkoutMovie(new Scanner(System.in).nextLine(),user.getName());
        }
        else
            System.out.println("Please login to checkout");

    }

    public void returnMovie(User userName) {
        if(userName!=null)
        {
            System.out.println("Enter the bookname");
            librarian.returnMovie(new Scanner(System.in).nextLine());
        }
        else
            System.out.println("please login to return");
    }

    public void displayCheckOutList(User userName) {
        if(userName!=null)
        {
            System.out.println("Checkout List:");
            librarian.displayCheckOutList();
        }
        else
            System.out.println("please login to view checkoutlist");
    }
}
