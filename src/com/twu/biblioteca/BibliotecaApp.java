package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
   // static ArrayList<String> BorrowedBooks=new ArrayList<String>();

    public static void main(String[] args) {
        BibliotecaApp customer=new BibliotecaApp();
       // Librarian librarian=new Librarian();
        customer.welcomeMessage();
        int option;
        do {
            customer.menuDisplay();
            Scanner input = new Scanner(System.in);
            option = customer.optionChosen(input);
            customer.invalidMenuOption(option);
            if(option==2||option==3) {
                System.out.println("Enter the bookname");
                Scanner bookname= new Scanner(System.in);
                customer.bookTransaction(option, bookname);
                if(option==2)
                {
                    new Librarian().displayAfterCheckOutOfBook();
                }
            }
            else
            customer.selectedOption(option);

           }while(option!=4);


    }

    private void bookTransaction(int option, Scanner input) {
        if(option==2)
        {
            new Librarian().checkOutBook(input);
        }
        if(option==3)
        {
            String bookname=input.nextLine();
            new Librarian().returningBook(bookname);
        }
    }


    public void welcomeMessage() {
        System.out.println("hello!Welcome to Biblioteca");
    }

   public void displayOfBookDetails() {
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


    public void menuDisplay() {
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

    public int optionChosen(Scanner input) {
        int menunumber=input.nextInt();
        return menunumber;
          }
    public void selectedOption(int menunumber) {
           if(menunumber==1) {

               new BibliotecaApp().displayOfBookDetails();
           }
        if(menunumber==4)
        {
            new BibliotecaApp().quit(menunumber);
        }

    }

    public void invalidMenuOption(int menunumber) {
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
   /* public void checkOutBook(Scanner input) {
        String bookname=input.nextLine();
        int borrowedbook=0;
        //BorrowedBooks.add("Digital Fortress");
        for(int noofbooks=0;noofbooks<BorrowedBooks.size();noofbooks++) {
            if (BorrowedBooks.get(noofbooks).equals(bookname))
            {
                borrowedbook=1;
            }

        }
        if(borrowedbook==0) {
            BorrowedBooks.add(bookname);

            System.out.println("Book Checked Out");
            //new BibliotecaApp().displayAfterCheckOutOfBook();
        }
        if(borrowedbook==1)
        {
            new BibliotecaApp().unsuccessfulCheckout(bookname);
        }

    }
    public void displayAfterCheckOutOfBook()
    {
        String line="";

        try {
            FileReader fr = new FileReader("/Users/Administrator/Downloads/TWU_Biblioteca-master/src/com/twu/biblioteca/booklist");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if(!(line.startsWith(BorrowedBooks.get(0))))
                {
                    System.out.println(line);
                }

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void unsuccessfulCheckout(String bookname) {
        String bookborrowed = BorrowedBooks.get(0);
        if (bookborrowed.equals(bookname)) {
            System.out.println("That book is not available");
        }
    }
    public void returningBook(String bookname) {
        int flag=0;
        if(BorrowedBooks.size()==0)
        {
            return;
        }
        else {
            for(int noofbooks=0;noofbooks<BorrowedBooks.size();noofbooks++) {
                if (bookname.equals(BorrowedBooks.get(noofbooks))) {
                    flag=1;
                    BorrowedBooks.remove(bookname);
                    System.out.println("Thank you for returning the book");

                }
            }
        }
        if(flag==0)
        {
            new BibliotecaApp().unsuccessfullReturn(bookname);
        }
    }

    public void unsuccessfullReturn(String bookname) {
        for(int noofbooks=0;noofbooks<BorrowedBooks.size();noofbooks++) {
            if (!(bookname.equals(BorrowedBooks.get(noofbooks)))) {
                System.out.println("This is not a valid book to return");
            }
        }
    }
*/

}
