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
        InputManager inputManager=new InputManager(librarian);
        User user1;
        String userName=null;
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
                    inputManager.checkoutBook(userName);
                    break;
                case 3:
                    inputManager.returnBook(userName);
                    break;
                case 4:
                    bibliotecaApp.quit();
                    break;
                case 5:
                    librarian.giveMovieList();
                    break;
                case 6:
                    inputManager.checkoutMovie(userName);
                    break;
                case 7:
                  //  inputManager.login();
                    do {
                        System.out.println("Enter userId and Password for login");

                        user1 = new Login(bibliotecaApp.users).loginValidate(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine());
                        if (user1 != null) {
                            userName=user1.getName();
                            librarian.giveUserDetails(user1);
                        }
                    } while (!(userName!=null));

                    break;
                case 8:
                    inputManager.returnMovie(userName);
                    break;
                case 9:
                    inputManager.displayCheckOutList(userName);
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

    }


    public String quit() {
        return "Thank You!";
    }


}
