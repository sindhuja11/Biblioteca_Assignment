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
    ArrayList<Movie> movies=new ArrayList<Movie>();
    ArrayList<User> users=new ArrayList<User>();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Book book =new Book("Digital Fortress","Dan Brown","1998");
    private Movie movie =new Movie("Harry Potter","2012","John Smith","9");
    private User user=new User("Sindhu","sindhum@thoughtworks.com","8390419567","123-1234","hello");
    private Library library;

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
        Library lib=new Library(books,movies,users);
        lib.checkOutBook(book);
        new Librarian(library).checkoutBook("Digital Fortress");
        assertEquals("That book is not available\n",outContent.toString());

    }
    @Test
    public void shouldCheckReturnBook() {
        Library lib=new Library(books,movies,users);
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
    @Test
    public void shouldGiveMovieList() {
        new Librarian(library).giveMovieList();
        assertEquals("Harry Potter,2012,John Smith,9\n"+
                "Inception,2009,Mike Tyson,-\n"+
                "Happy days,2008,Prabhu,9\n",outContent.toString());
    }
    @Test
    public void shouldCheckoutMovie() {
        new Librarian(library).checkoutMovie("Harry Potter");
        assertEquals("Movie Checked Out\n",outContent.toString());

    }
    @Test
    public void shouldNotCheckoutMovie() {
        new Librarian(library).checkoutMovie("Harry Potter");
        outContent.reset();
        new Librarian(library).checkoutMovie("Harry Potter");
        assertEquals("That movie is not available\n",outContent.toString());

    }
    @Test
    public void shouldGiveUserDetails() {
        new Librarian(library).giveUserDetails(user);
        assertEquals("Details:\n"+"Sindhu"+","+"sindhum@thoughtworks.com"+","+"8390419567\n",outContent.toString());
    }
}
