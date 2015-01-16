package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by sindhum on 15/01/15.
 */
public class LoginValidation {
    private ArrayList<User> users;
    LoginValidation(ArrayList<User> users) {
    this.users=users;
    }
    public User loginValidation(String id, String p) {

            for (User user : users) {

                if(user.getUserID().equals(id)&&user.getPassword().equals(p))
                {
                    return user;
                }
            }
           return null;

    }
}
