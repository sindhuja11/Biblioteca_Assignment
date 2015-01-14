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

            }
                if(option==1)
                customer.displayBookList();
                if(option==4)
                customer.quit();

        } while (option != 4);


    }

    public void bookTransaction(int option, String bookname) {
        Library library = new Library(books);
        if(option==2)
        {
            Book book = library.find(bookname);
            boolean availablility= library.checkOutBook(book);
            if(availablility)
            {
                System.out.println("Book Checked Out");
            }
            else
            System.out.println("That book is not available");
        }
        if(option==3)
        {
              boolean availability= library.returningBook(bookname);
            if(availability)
            {
                System.out.println("Thank you for returning the book");


            }
            else
                System.out.println("This is not a valid book to return");

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
    public void displayBookList() {

            ArrayList<Book> booklist;
              // books=new BookParser().readFile();
               booklist = new Library(books).giveBookDetails();
               for(int noofbooks=0;noofbooks<booklist.size();noofbooks++)
               {
                   System.out.println(booklist.get(noofbooks).getBookName()+","+booklist.get(noofbooks).getAuthor()+","+booklist.get(noofbooks).getyearPublished());
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

    public String quit() {

            return "Thank You!";


    }

}
