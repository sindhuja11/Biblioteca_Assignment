package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by sindhum on 14/01/15.
 */
public class LibrarianTest {
    ArrayList<Book> books=new ArrayList<Book>();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Book book =new Book("Digital Fortress","Dan Brown","1998",true);

    @Before
    public void setUpStreams() {
        books.add(book);
        books.add(new Book("Java The Complete Reference","Herbert Schildt","2005",true));
        books.add(new Book("Software Engineering","Zakkiuddin Ahmed","2012",true));

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void shouldCheckoutBook()
    {
        new Librarian(books).callCheckoutBook("Digital Fortress");
        assertEquals("Book Checked Out\n",outContent.toString());

    }
    @Test
    public void shouldNotCheckoutBook()
    {
        Library lib=new Library(books);
        lib.checkOutBook(book);
        new Librarian(books).callCheckoutBook("Digital Fortress");
        assertEquals("That book is not available\n",outContent.toString());

    }
    @Test
    public void shouldCheckReturnBook() {
        Library lib=new Library(books);
        lib.checkOutBook(book);
        new Librarian(books).callReturnBook("Digital Fortress");
        assertEquals("Thank you for returning the book\n",outContent.toString());
    }
    @Test
    public void shouldNotReturnBook() {
        new Librarian(books).callReturnBook("Digital Fortress");
        assertEquals("This is not a valid book to return\n",outContent.toString());
    }

}
