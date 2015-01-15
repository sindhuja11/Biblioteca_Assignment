package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Movie> movies=new ArrayList<Movie>();

    public static void main(String[] args) {
        BibliotecaApp customer = new BibliotecaApp();
        customer.books = new BookParser().readFile();
        customer.movies=new MovieParser().readFile();
        Library library = new Library(customer.books,customer.movies);
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
                case 5:librarian.giveMovieList();
                    break;
                case 6:System.out.println("Enter the movie name");
                    librarian.checkoutMovie(new Scanner(System.in).nextLine());
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
        System.out.println("Press 2 for CheckOut Book");
        System.out.println("Press 3 for Return book");
        System.out.println("Press 5 for  Movie List");
        System.out.println("Press 6 for Checkout Movie");
        System.out.println("Press 4 for Quit");
    }


    public String quit() {
        return "Thank You!";
    }

}
