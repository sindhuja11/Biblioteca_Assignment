package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> books=new ArrayList<Book>();

    public static void main(String[] args) {
        BibliotecaApp customer = new BibliotecaApp();
        customer.books=new BookParser().readFile();
        customer.welcomeMessage();
        int option;
        do {
            customer.menuDisplay();
            Scanner input = new Scanner(System.in);
            option = customer.optionChosen(input);
            customer.invalidMenuOption(option);
            if (option == 2 || option == 3) {
                System.out.println("Enter the bookname");
                Scanner bookinput = new Scanner(System.in);
                String bookname = bookinput.nextLine();
                customer.bookTransaction(option, bookname);

            } else
                customer.selectedOption(option);

        } while (option != 4);


    }

    public void bookTransaction(int option, String bookname) {
        if(option==2)
        {
            new Library(books).checkOutBook(bookname);
        }
        if(option==3)
        {
              new Library(books).returningBook(bookname);
        }
    }


    public void welcomeMessage() {
        System.out.println("hello!Welcome to Biblioteca");
    }


    public void menuDisplay() {
        String line = "";
        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/files/menu");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int optionChosen(Scanner input) {
        int menunumber=input.nextInt();
        return menunumber;
          }
    public void selectedOption(int menunumber) {
           if(menunumber==1) {

           new Library(books).displayOfBookDetails();
           }
        if(menunumber==4)
        {
            new BibliotecaApp().quit(menunumber);
        }

    }

    public void invalidMenuOption(int menunumber) {
        int count=0;
        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/files/menu");
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null) {

                ++count;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        count--;
         if(menunumber>count||menunumber<1)
         {
             System.out.println("Select a valid option");
         }

    }

    public String quit(int menuinput) {
        if(menuinput==4) {
            return "Thank You!";
        }
        return null;
    }

}
