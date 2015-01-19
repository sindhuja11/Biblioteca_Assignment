package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.books = new BookParser().readFile();
        bibliotecaApp.movies = new MovieParser().readFile();
        bibliotecaApp.users=new UserDetailsParser().readFile();
        Library library = new Library(bibliotecaApp.books, bibliotecaApp.movies, bibliotecaApp.users);
        Librarian librarian = new Librarian(library);
        LoginManager loginManager=new LoginManager(librarian);
        User user = null;
        bibliotecaApp.welcomeMessage();
        int option;
        do {
            bibliotecaApp.menuDisplay();
            option = new Scanner(System.in).nextInt();
            switch (option) {
                case 1:
                    librarian.giveBookList();
                    break;
                case 2:
                    loginManager.checkoutBook(user);
                    break;
                case 3:
                    loginManager.returnBook(user);
                    break;
                case 4:
                    bibliotecaApp.quit();
                    break;
                case 5:
                    librarian.giveMovieList();
                    break;
                case 6:
                    loginManager.checkoutMovie(user);
                    break;
                case 7:
                    while ((user==null)){
                        System.out.println("Enter userId and Password for login");

                        user = new Login(bibliotecaApp.users).loginValidate(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine());
                        if (user != null) {
                            librarian.giveUserDetails(user);
                        }
                   }

                    break;
                case 8:
                    loginManager.returnMovie(user);
                    break;
                case 9:
                    loginManager.displayCheckOutList(user);
                    break;
                case 10: user=null;
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
        System.out.println("Press 4 for Quit");
        System.out.println("Press 5 for  Movie List");
        System.out.println("Press 6 for Checkout Movie");
        System.out.println("Press 7 for Login");
        System.out.println("Press 8 for Return Movie");
        System.out.println("Press 9 for checkout list");
        System.out.println("Press 10 for logout");

    }


    public String quit() {
        return "Thank You!";
    }


}
