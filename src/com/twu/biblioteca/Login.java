package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by sindhum on 15/01/15.
 */
public class Login {
    private ArrayList<User> users;

    Login(ArrayList<User> users) {
        this.users = users;
    }

    public User loginValidate(String id, String password) {

        for (User user : users) {

            if (user.getUserID().equals(id) && user.getPassword().equals(password)) {
                System.out.println("login successfull");
                return user;
            }
        }

        System.out.println("login unsuccessfull");
        return null;
    }
}

