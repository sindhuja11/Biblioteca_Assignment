package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by Administrator on 11/01/15.
 */
public class Library {
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private static ArrayList<Book> borrowedbooks=new ArrayList<Book>();
    private static ArrayList<Movie> borrowedmovies=new ArrayList<Movie>();
    public Library(ArrayList<Book> books,ArrayList<Movie> movies) {
        this.books = books;
        this.movies=movies;
    }

    public ArrayList<Book> giveBookDetails() {
    return books;
    }

    public boolean checkOutBook(Book book1) {

            if(books.contains(book1)) {
                books.remove(book1);
                borrowedbooks.add(book1);
                return true;
            }
        return false;

    }


    public boolean returnBook(Book bookToReturn) {

            if(books.contains(bookToReturn)) {
                return true;
            }
            else
            {
                books.add(bookToReturn);
                borrowedbooks.remove(bookToReturn);
                return false;

            }

    }

    public Book findBook(String name) {
        for (Book book : books) {
            if (book.getBookName().equals(name))
                return book;
        }
        for (Book book : borrowedbooks) {
            if (book.getBookName().equals(name))
                return book;
        }

        return null;
    }

    public ArrayList<Movie> giveMovieDetails() {
        return movies;
    }

    public Movie findMovie(String movieName) {
        for (Movie movie : movies) {
            if(movie.getMovieName().equals(movieName))
                return movie;
        }
        for (Movie movie : borrowedmovies) {
            if(movie.getMovieName().equals(movieName))
                return movie;
        }
        return null;
    }

    public boolean checkoutMovie(Movie movie) {
        if(movies.contains(movie))
        {
            movies.remove(movie);
            borrowedmovies.add(movie);
            return true;
        }
        return false;
    }
}

