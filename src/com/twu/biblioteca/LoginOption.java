package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by sindhum on 21/01/15.
 */
public class LoginOption extends MenuController {
    User user;
    Login login;
    Librarian librarian;
    public LoginOption(User user,Login login,Librarian librarian) {
        this.user = user;
        this.login=login;
        this.librarian=librarian;
    }

    @Override
    public void doAction() {
        while ((user==null)) {
            System.out.println("Enter userId and Password for login");

            user = login.loginValidate(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine());
            if (user != null) {
                librarian.giveUserDetails(user);
            }
        }
    }
}
