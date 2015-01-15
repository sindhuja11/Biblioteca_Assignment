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
    public void ShouldCheckBookDetails() {
      ArrayList<Book> availablebooks=new ArrayList<Book>();
      availablebooks.add(new Book("Digital Fortress","Dan Brown","1998",true));
      availablebooks.add(new Book("Java The Complete Reference","Herbert Schildt","2005",true));
        availablebooks.add(new Book("Software Engineering","Zakkiuddin Ahmed","2012",true));

        ArrayList<Book> returnedlist=new Library(books).giveBookDetails();
          for(int noofbooks=0;noofbooks<availablebooks.size();noofbooks++) {
            assertEquals(availablebooks.get(noofbooks).getBookName(),returnedlist.get(noofbooks).getBookName());
            assertEquals(availablebooks.get(noofbooks).getAuthor(),returnedlist.get(noofbooks).getAuthor());
            assertEquals(availablebooks.get(noofbooks).getyearPublished(),returnedlist.get(noofbooks).getyearPublished());
        }
    }

    @Test
    public void shouldCheckOutBook() {
        Library library = new Library(books);
        library.checkOutBook(book);
        assertEquals(2, books.size());
    }

    @Test
    public void shouldCheckReturnOfABook() {
        Library book=new Library(books);
        Book book1=new Book("Digital Fortress","Dan Brown","1998",true);
        book.checkOutBook(book1);
        assertEquals(false,book.returnBook(book1));
    }

    @Test
    public void shouldCheckReturnAddtoList() {
        Library book1=new Library(books);
        book1.checkOutBook(book);
        book1.returnBook(book);
        assertEquals(3,books.size());
    }
    @Test
    public void shouldNotReturnOfABook() {
        Library book=new Library(books);
        Book book1=new Book("Digital Fortress","Dan Brown","1998",true);
        assertEquals(false,book.returnBook(book1));

    }

    @Test
    public void shouldCheckFindingBook() {
        Library library = new Library(books);
        assertEquals(book, library.find("Digital Fortress"));
    }
    @Test
    public void shouldCheckNotFindingBook() {
        Library library=new Library(books);
        assertEquals(null,library.find("Head First Java"));
    }


}

