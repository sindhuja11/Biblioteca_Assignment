package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        boolean login = false;
        String username="";
        bibliotecaApp.books = new BookParser().readFile();
        bibliotecaApp.movies = new MovieParser().readFile();
        bibliotecaApp.users=new UserDetailsParser().readFile();
        Library library = new Library(bibliotecaApp.books, bibliotecaApp.movies, bibliotecaApp.users);
        Librarian librarian = new Librarian(library);
        User user1;
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
                    if (login) {
                        System.out.println("Enter the bookname");
                        librarian.checkoutBook(new Scanner(System.in).nextLine(),username);
                    } else {
                        System.out.println("please login to checkout");
                    }
                    break;
                case 3:
                    if (login) {
                        System.out.println("Enter the bookname");
                        librarian.returnBook(new Scanner(System.in).nextLine());
                    } else
                        System.out.println("please login to return");
                    break;
                case 4:
                    bibliotecaApp.quit();
                    break;
                case 5:
                    librarian.giveMovieList();
                    break;
                case 6:
                    if (login) {
                        System.out.println("Enter the movie name");
                        librarian.checkoutMovie(new Scanner(System.in).nextLine(),username);
                    } else
                        System.out.println("please login to checkout");
                    break;
                case 7:
                    do {
                        System.out.println("Enter userId and Password for login");

                        user1 = new Login(bibliotecaApp.users).loginValidate(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine());
                        if (user1 != null) {
                            login = true;
                            username=user1.getName();
                            librarian.giveUserDetails(user1);
                        }
                    } while (!login);

                    break;
                case 8:
                    if (login) {
                        System.out.println("Enter the bookname");
                        librarian.returnMovie(new Scanner(System.in).nextLine());
                    }
                    break;
                case 9: if(login) {
                    System.out.println("Checkout List:");
                    librarian.displayCheckOutList();
                }
                    else
                System.out.println("please login to checkout");
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
