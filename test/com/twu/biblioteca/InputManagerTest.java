package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by sindhum on 19/01/15.
 */
public class InputManagerTest {
    ArrayList<Book> books=new ArrayList<Book>();
    ArrayList<Movie> movies=new ArrayList<Movie>();
    ArrayList<User> users=new ArrayList<User>();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Book book =new Book("Digital Fortress","Dan Brown","1998");
    private Movie movie =new Movie("Harry Potter","2012","John Smith","9");
    private User user=new User("Sindhu","sindhum@thoughtworks.com","8390419567","123-1234","hello");
    private Library library;
    private Librarian librarian;

    @Before

    public void setUpStreams() {
        books.add(book);
        books.add(new Book("Java The Complete Reference","Herbert Schildt","2005"));
        books.add(new Book("Software Engineering","Zakkiuddin Ahmed","2012"));
        movies.add(movie);
        movies.add(new Movie("Inception","2009","Mike Tyson","-"));
        movies.add(new Movie("Happy days","2008","Prabhu","9"));
        users.add(user);
        users.add(new User("Aishwarya","aish@gmail.com","7986342156","154-1357","password"));
        library = new Library(books,movies, users);
        librarian=new Librarian(library);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldCheckoutBook() {
        new InputManager(librarian).checkoutBook(null);
        assertEquals("Please login to checkout\n",outContent.toString());
    }
    /*@Test
    public void shouldCheckOutBook() {
        new InputManager(librarian).checkoutBook("sindhu");
        assertEquals("enter the bookname\n",outContent.toString());
    }*/
}
