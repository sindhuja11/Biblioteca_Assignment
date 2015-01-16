package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Movie> movies=new ArrayList<Movie>();
    ArrayList<User> users=new ArrayList<User>();
    public static void main(String[] args) {
//        ArrayList<String> libraryId=new ArrayList<String>();
//        ArrayList<String> password=new ArrayList<String>();
//        libraryId.add("123-1234");
//        libraryId.add("154-1357");
//        password.add("hello");
//        password.add("password");
        BibliotecaApp customer = new BibliotecaApp();
        customer.users=new UserDetailsParser().readFile();
        customer.books = new BookParser().readFile();
        customer.movies=new MovieParser().readFile();
        Library library = new Library(customer.books,customer.movies,customer.users);
        Librarian librarian = new Librarian(library);
        LoginValidation user=new LoginValidation(customer.users);
        User user1;
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
                case 7:System.out.println("Enter userId and Password for login");
                    Scanner userid=new Scanner(System.in);
                    String id=userid.nextLine();
                    user1=user.loginValidation(id, new Scanner(System.in).nextLine());
                     if(user1!=null) {
                        System.out.println("login successfull");
                        librarian.giveUserDetails(user1);
                    }
                    else
                     System.out.println("login unsuccessful");
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
        System.out.println("Press 7 for Login");
        System.out.println("Press 4 for Quit");
    }


    public String quit() {
        return "Thank You!";
    }


}
