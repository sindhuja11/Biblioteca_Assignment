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
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 13/01/15.
 */
public class LibraryTest {
    ArrayList<Book> books=new ArrayList<Book>();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        Book b=new Book("Digital Fortress","Dan Brown","1998",1);
        books.add(b);
        books.add(new Book("Java The Complete Reference","Herbert Schildt","2005",1));

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
      new Library(books).displayOfBookDetails();
        assertEquals("Digital Fortress,Dan Brown,1998\n"+
                "Java The Complete Reference,Herbert Schildt,2005\n",outContent.toString());
    }

    @Test
    public void shouldCheckOutBook() {

        outContent.reset();
        new Library(books).checkOutBook("Digital Fortress");
        assertEquals("Book Checked Out\n", outContent.toString());
    }

    @Test
    public void shouldNotCheckOutBook() {

        outContent.reset();
        new Library(books).checkOutBook("Digital Fortress");
        outContent.reset();
        new Library(books).checkOutBook("Digital Fortress");
        assertEquals("That book is not available\n", outContent.toString());
    }
//    @Test
//    public void shouldCheckDisplayOfBooksAfterCheckOut() {
//        new Library(books).checkOutBook("Digital Fortress");
//        outContent.reset();
//        new Library(books).displayAfterCheckOutOfBook();
//        assertEquals("Java The Complete Reference,Herbert Schildt,2005\n" +
//                "Software Engineering,Zakkiuddin Ahmed,2012\n", outContent.toString());
//    }
//    @Test
//    public void shouldCheckUnsuccessfullCheckout() {
      // Scanner input=new Scanner("Digital Fortress");
//        new Library(books).checkOutBook("Digital Fortress");
//        outContent.reset();
//        new Library(books).unsuccessfulCheckout("Digital Fortress");
//        assertEquals("That book is not available\n", outContent.toString());
//    }
    @Test
    public void shouldCheckReturnOfABook() {
        new Library(books).checkOutBook("Digital Fortress");
        outContent.reset();
        new Library(books).returningBook("Digital Fortress");
        assertEquals("Thank you for returning the book\n",outContent.toString());
    }
    @Test
    public void shouldNotReturnOfABook() {
       // new Library(books).checkOutBook("Digital Fortress");
        outContent.reset();
        new Library(books).returningBook("Digital Fortress");
        assertEquals("This is not a valid book to return\n", outContent.toString());
    }
//    @Test
//    public void shouldCheckUnsuccessfullReturn() {
//        new Library(books).checkOutBook("Java The Complete Reference");
//        outContent.reset();
//        new Library(books).unsuccessfullReturn("Digital Fortress");
//        assertEquals("This is not a valid book to return\n", outContent.toString());
//    }



}

