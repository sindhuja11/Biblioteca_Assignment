import com.twu.biblioteca.Librarian;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 13/01/15.
 */
public class LibrarianTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void shouldCheckOutBook() {
        Scanner input=new Scanner("Digital Fortress");
        outContent.reset();
        new Librarian().checkOutBook(input);
        assertEquals("Book Checked Out\n", outContent.toString());
    }
    @Test
    public void shouldCheckDisplayOfBooksAfterCheckOut() {
        Scanner input=new Scanner("Digital Fortress");
        new Librarian().checkOutBook(input);
        Scanner nextInput=new Scanner("Java The Complete Reference");
        new Librarian().checkOutBook(nextInput);
        outContent.reset();
        new Librarian().displayAfterCheckOutOfBook();
        assertEquals("Bookname                                  Author                        Year Published\n" +
                "Software Engineering                     Zakkiuddin Ahmed                2012\n", outContent.toString());
    }
    @Test
    public void shouldCheckUnsuccessfullCheckout() {
        Scanner input=new Scanner("Digital Fortress");
        new Librarian().checkOutBook(input);
        outContent.reset();
        new Librarian().unsuccessfulCheckout("Digital Fortress");
        assertEquals("That book is not available\n", outContent.toString());
    }
    @Test
    public void shouldCheckReturnOfABook() {
        Scanner input=new Scanner("Digital Fortress");
        new Librarian().checkOutBook(input);
        outContent.reset();
        new Librarian().returningBook("Digital Fortress");
        assertEquals("Thank you for returning the book\n",outContent.toString());
    }
    @Test
    public void shouldCheckUnsuccessfullReturn() {
        Scanner input=new Scanner("Java The Complete Reference");
        new Librarian().checkOutBook(input);
        outContent.reset();
        new Librarian().unsuccessfullReturn("Digital Fortress");
        assertEquals("This is not a valid book to return\n", outContent.toString());
    }



}
