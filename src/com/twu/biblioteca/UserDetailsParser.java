package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sindhum on 16/01/15.
 */
public class UserDetailsParser {
    ArrayList<User> users=new ArrayList<User>();
    public ArrayList<User> readFile() {
        String line="";
        try {
            FileReader fr = new FileReader("/Users/sindhum/Downloads/TWU_Biblioteca-master/src/files/userdetails");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                String userdetails[]=line.split(",");
                users.add(new User(userdetails[0], userdetails[1], userdetails[2],userdetails[3],userdetails[4]));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

}
