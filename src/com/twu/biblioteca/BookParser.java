package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 13/01/15.
 */
public class BookParser {
    ArrayList<Book> books=new ArrayList<Book>();
    public ArrayList<Book> readFile() {
        String line="";
        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/files/booklist");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                String bookdetails[]=line.split(",");
                books.add(new Book(bookdetails[0],bookdetails[1],bookdetails[2],1));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
