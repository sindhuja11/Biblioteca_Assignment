package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by sindhum on 15/01/15.
 */
public class Login {
    User user1;
    ArrayList<User> users=new ArrayList<User>();

    public User userLogin(String id,String password)
    {
        users=new UserDetailsParser().readFile();
        LoginValidation user=new LoginValidation(users);
        user1=user.loginValidation(id, password);
        if(user1!=null) {
            System.out.println("login successfull");
            return user1;

        }
        else {
            System.out.println("login unsuccessfull");
            return null;
        }
    }
   }
