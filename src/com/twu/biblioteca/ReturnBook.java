package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by sindhum on 21/01/15.
 */
public class ReturnBook extends MenuController{
    Librarian librarian;
    Login login;
    public ReturnBook(Librarian librarian,Login login) {
        this.librarian = librarian;
        this.login=login;
    }

    @Override
    public void doAction() {
        User currentUser=login.getCurrentUser();
        if(currentUser!=null) {
            System.out.println("enter the bookname");
            librarian.returnBook(new Scanner(System.in).nextLine());
        }
        else
            System.out.println("please log in");
    }
}
