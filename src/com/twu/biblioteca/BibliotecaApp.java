package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BibliotecaApp {


    public static void main(String[] args) {


    }


    public void CheckWelcomeMessage(String message) {
        System.out.print(message);
    }




    public void CheckDisplayOfBookList() {
        String line = "";
        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/com/twu/biblioteca/booklist");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
