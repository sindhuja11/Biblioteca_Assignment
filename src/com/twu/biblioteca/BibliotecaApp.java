package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {


    }


    public void WelcomeMessage(String message) {
        System.out.print(message);
    }





    public void DisplayOfBookDetails() {
        String line = "";
        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/com/twu/biblioteca/booklist");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void MenuDisplay() {
        String line = "";
        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/com/twu/biblioteca/menu");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int OptionChosen(Scanner input) {
        int menunumber=input.nextInt();
        return menunumber;
    }
    public void DisplayOfBooks(int menunumber) {
            String line = "";
            try {
                FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/com/twu/biblioteca/booklist");
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {

                    System.out.println(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }



    }

    public void InvalidMenuOption(int menunumber) {
        int count=0;
        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/com/twu/biblioteca/menu");
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null) {

                ++count;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
         if(count-1!=menunumber)
         {
             System.out.println("Select a valid option");
         }

    }

    public String Quit(Scanner input) {
        String menuinput=input.next();
        if(menuinput.equals("Quit")) {
            return "Thank You!";
        }
        return null;
    }
}
