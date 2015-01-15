package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sindhum on 15/01/15.
 */
public class MovieParser {
    ArrayList<Movie> movies=new ArrayList<Movie>();
    public ArrayList<Movie> readFile() {
        String line="";
        try {
            FileReader fr = new FileReader("/Users/sindhum/Downloads/TWU_Biblioteca-master/src/files/movie");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                String moviedetails[]=line.split(",");
                movies.add(new Movie(moviedetails[0], moviedetails[1], moviedetails[2],moviedetails[3]));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

}
