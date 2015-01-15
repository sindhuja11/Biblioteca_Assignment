package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) {
        BibliotecaApp customer = new BibliotecaApp();
        customer.books = new BookParser().readFile();
        Library library = new Library(customer.books);
        Librarian librarian = new Librarian(library);
        customer.welcomeMessage();
        int option;
        do {
            customer.menuDisplay();
            option = new Scanner(System.in).nextInt();
            switch (option) {
                case 1:
                    librarian.giveBookList();
                    break;
                case 2:
                    System.out.println("Enter the bookname");
                    librarian.checkoutBook(new Scanner(System.in).nextLine());
                    break;
                case 3:
                    System.out.println("Enter the bookname");
                    librarian.returnBook(new Scanner(System.in).nextLine());
                    break;
                case 4:
                    customer.quit();
                    break;
                default:
                    System.out.println("Invalid Option");


            }

        } while (option != 4);

    }

    public void welcomeMessage() {
        System.out.println("hello!Welcome to Biblioteca");
    }


    public void menuDisplay() {
        System.out.println("Menu");
        System.out.println("Press 1 for Books List");
        System.out.println("Press 2 for CheckOut");
        System.out.println("Press 3 for Return");
        System.out.println("Press 4 for Quit");
    }


    public String quit() {
        return "Thank You!";
    }

}
