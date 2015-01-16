package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Librarian {
    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public void checkoutBook(String bookName) {
        Book book = library.findBook(bookName);
        if (library.checkOutBook(book))
            System.out.println("Book Checked Out");
        else
            System.out.println("That book is not available");
    }

    public void returnBook(String bookToReturn) {
        Book book = library.findBook(bookToReturn);
        if (library.returnBook(book))
            System.out.println("This is not a valid book to return");
        else
            System.out.println("Thank you for returning the book");

    }


    public void giveBookList() {
        ArrayList<Book> books=library.giveBookDetails();
        for(int noofbooks=0;noofbooks<books.size();noofbooks++)
        {
            System.out.println(books.get(noofbooks).getBookName()+","+books.get(noofbooks).getAuthor()+","+
                    books.get(noofbooks).getyearPublished());
        }
    }

    public void giveMovieList() {
        ArrayList<Movie> movies=library.giveMovieDetails();
        for(int noofmovies=0;noofmovies<movies.size();noofmovies++)
        {
            System.out.println(movies.get(noofmovies).getMovieName()+","+movies.get(noofmovies).getYearReleased()+","+
                    movies.get(noofmovies).getDirector()+","+ movies.get(noofmovies).getMovieRating());
        }
    }

    public void checkoutMovie(String movieName) {
        Movie movie=library.findMovie(movieName);
        if(library.checkoutMovie(movie))
            System.out.println("Movie Checked Out");
            else
            System.out.println("That movie is not available");


    }

    public void giveUserDetails(User user1) {
        User user=library.giveUserDetails(user1);
        if(user!=null)
        System.out.println("Details:\n"+user.getName()+","+user.getEmail()+","+user.getPhoneNumber());

    }

    }
