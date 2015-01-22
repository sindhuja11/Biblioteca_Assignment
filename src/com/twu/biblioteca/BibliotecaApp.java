package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> menu=new ArrayList<String>();
    public BibliotecaApp() {
        menu.add("Menu");
        menu.add("Press 1 for Books List");
        menu.add("Press 2 for CheckOut Book");
        menu.add("Press 3 for Return book");
        menu.add("Press 4 for Quit");
        menu.add("Press 5 for  Movie List");
        menu.add("Press 6 for Checkout Movie");
        menu.add("Press 7 for Login");
        menu.add("Press 8 for Return Movie");
        menu.add("Press 9 for checkout list");

    }
    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.books = new BookParser().readFile();
        bibliotecaApp.movies = new MovieParser().readFile();
        bibliotecaApp.users=new UserDetailsParser().readFile();
        Library library = new Library(bibliotecaApp.books, bibliotecaApp.movies, bibliotecaApp.users);
        Librarian librarian = new Librarian(library);
        Login login=new Login(bibliotecaApp.users);
        User user = null;
        bibliotecaApp.welcomeMessage();
        MenuController menuController;
        int option;
        MenuObject menu=new MenuObject(librarian,bibliotecaApp,login,user);

            do {
                bibliotecaApp.menuDisplay();
                option = new Scanner(System.in).nextInt();

                    menuController = (MenuController) menu.giveObject(option);
                    if(menuController==null)
                    {
                        System.out.println("invalid option");
                    }

                else
                menuController.doAction();
            } while (option != 4);


    }



    public void welcomeMessage() {
        System.out.println("hello!Welcome to Biblioteca");
    }


    public void menuDisplay() {
        for(int noOfOptions=0;noOfOptions<menu.size();noOfOptions++)
        {
            System.out.println(menu.get(noOfOptions));
        }
    }


    public String quit() {
        return "Thank You!";
    }


}
