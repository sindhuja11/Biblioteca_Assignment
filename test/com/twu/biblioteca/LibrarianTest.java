package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibrarianTest {
    ArrayList<Book> books=new ArrayList<Book>();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Book book =new Book("Digital Fortress","Dan Brown","1998");
    private Library library;

    @Before
    public void setUpStreams() {
        books.add(book);
        books.add(new Book("Java The Complete Reference","Herbert Schildt","2005"));
        books.add(new Book("Software Engineering","Zakkiuddin Ahmed","2012"));
        library = new Library(books);

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
        new Librarian(library).checkoutBook("Digital Fortress");
        assertEquals("Book Checked Out\n",outContent.toString());

    }
    @Test
    public void shouldNotCheckoutBook()
    {
        Library lib=new Library(books);
        lib.checkOutBook(book);
        new Librarian(library).checkoutBook("Digital Fortress");
        assertEquals("That book is not available\n",outContent.toString());

    }
    @Test
    public void shouldCheckReturnBook() {
        Library lib=new Library(books);
        lib.checkOutBook(book);
        new Librarian(library).returnBook("Digital Fortress");
        assertEquals("Thank you for returning the book\n",outContent.toString());
    }
    @Test
    public void shouldNotReturnBook() {
        new Librarian(library).returnBook("Digital Fortress");
        assertEquals("This is not a valid book to return\n",outContent.toString());
    }
    @Test
    public void shouldGiveBookList() {
        new Librarian(library).giveBookList();
        assertEquals("Digital Fortress,Dan Brown,1998\n"+
                "Java The Complete Reference,Herbert Schildt,2005\n" +
                "Software Engineering,Zakkiuddin Ahmed,2012\n",outContent.toString());
    }

}
