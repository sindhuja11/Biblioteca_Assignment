package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by sindhum on 15/01/15.
 */
public class Login {
    private ArrayList<String> libraryId;
    private ArrayList<String> password;
    public Login(ArrayList<String> libraryId,ArrayList<String> password)
    {
        this.libraryId=libraryId;
        this.password=password;
    }
    public ArrayList<String> getID()
    {
        return libraryId;
    }
    public ArrayList<String> getPassword()
    {
        return password;
    }

   }
