package com.twu.biblioteca;

/**
 * Created by Administrator on 13/01/15.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 13/01/15.
 */
public class LibraryTest {
    ArrayList<Book> books=new ArrayList<Book>();
    ArrayList<Movie> movies=new ArrayList<Movie>();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Book book =new Book("Digital Fortress","Dan Brown","1998");
    private Movie movie =new Movie("Harry Potter","2012","John Smith","9");


    @Before
    public void setUpStreams() {
        books.add(book);
        books.add(new Book("Java The Complete Reference","Herbert Schildt","2005"));
        books.add(new Book("Software Engineering","Zakkiuddin Ahmed","2012"));
        movies.add(movie);
        movies.add(new Movie("Inception","2009","Mike Tyson","-"));
        movies.add(new Movie("Happy days","2008","Prabhu","9"));

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    @Test
    public void ShouldCheckBookDetails() {
      ArrayList<Book> availablebooks=new ArrayList<Book>();
      availablebooks.add(new Book("Digital Fortress","Dan Brown","1998"));
      availablebooks.add(new Book("Java The Complete Reference","Herbert Schildt","2005"));
        availablebooks.add(new Book("Software Engineering","Zakkiuddin Ahmed","2012"));

        ArrayList<Book> returnedlist= new Library(books,movies).giveBookDetails();
          for(int noofbooks=0;noofbooks<availablebooks.size();noofbooks++) {
            assertEquals(availablebooks.get(noofbooks).getBookName(),returnedlist.get(noofbooks).getBookName());
            assertEquals(availablebooks.get(noofbooks).getAuthor(),returnedlist.get(noofbooks).getAuthor());
            assertEquals(availablebooks.get(noofbooks).getyearPublished(),returnedlist.get(noofbooks).getyearPublished());
        }
    }

    @Test
    public void shouldCheckOutBook() {
        Library library = new Library(books,movies);
        library.checkOutBook(book);
        assertEquals(2, books.size());
    }

    @Test
    public void shouldCheckReturnOfABook() {
        Library book=new Library(books,movies);
        Book book1=new Book("Digital Fortress","Dan Brown","1998");
        book.checkOutBook(book1);
        assertEquals(false,book.returnBook(book1));
    }

    @Test
    public void shouldCheckReturnAddtoList() {
        Library book1=new Library(books,movies);
        book1.checkOutBook(book);
        book1.returnBook(book);
        assertEquals(3,books.size());
    }
    @Test
    public void shouldNotReturnOfABook() {
        Library book=new Library(books,movies);
        Book book1=new Book("Digital Fortress","Dan Brown","1998");
        assertEquals(false,book.returnBook(book1));

    }

    @Test
    public void shouldCheckFindingBook() {
        Library library = new Library(books,movies);
        assertEquals(book, library.findBook("Digital Fortress"));
    }
    @Test
    public void shouldCheckNotFindingBook() {
        Library library=new Library(books,movies);
        assertEquals(null,library.findBook("Head First Java"));
    }
    @Test
    public void ShouldCheckMovieDetails() {
        ArrayList<Movie> availablemovies=new ArrayList<Movie>();
        availablemovies.add(new Movie("Harry Potter","2012","John Smith","9"));
        availablemovies.add(new Movie("Inception","2009","Mike Tyson","-"));
        availablemovies.add(new Movie("Happy days","2008","Prabhu","9"));

        ArrayList<Movie> returnedlist= new Library(books,movies).giveMovieDetails();
        for(int noofmovies=0;noofmovies<availablemovies.size();noofmovies++) {
            assertEquals(availablemovies.get(noofmovies).getMovieName(),returnedlist.get(noofmovies).getMovieName());
            assertEquals(availablemovies.get(noofmovies).getYearReleased(),returnedlist.get(noofmovies).getYearReleased());
            assertEquals(availablemovies.get(noofmovies).getDirector(),returnedlist.get(noofmovies).getDirector());
            assertEquals(availablemovies.get(noofmovies).getMovieRating(),returnedlist.get(noofmovies).getMovieRating());
        }
    }
    @Test
    public void shouldFindMovie() {
        Library library=new Library(books,movies);
        assertEquals(movie,library.findMovie("Harry Potter"));
    }
    @Test
    public void shouldNotFindMovie() {
        Library library=new Library(books,movies);
        assertEquals(null,library.findMovie("Harry Pottr"));
    }
    @Test
    public void shouldCheckOutMovie() {
        Library library=new Library(books,movies);
        assertEquals(true, library.checkoutMovie(movie));

    }
    @Test
    public void shouldNotCheckOutMovie() {
        Library library=new Library(books,movies);
        assertEquals(false,library.checkoutMovie(new Movie("Starwars","2011","cameroon","10")));
    }



}

