package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class bibliotecaTest {
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
    public void test() {
        assertEquals(1, 1);
    }
    @Test
    public void ShouldCheckWelcomeMessage() {
        new BibliotecaApp().CheckWelcomeMessage("hello!Welcome to Biblioteca");
        assertEquals("hello!Welcome to Biblioteca", outContent.toString());
    }
    @Test
    public void ShouldCheckBookDetails() {
        new BibliotecaApp().CheckDisplayOfBookDetails();
        assertEquals("Bookname                                  Author                        Year Published\n" +
                "Digital Fortress                         Dan Brown                       1998\n" +
                "Java The Complete Reference              Herbert Schildt                 2005\n" +
                "Software Engineering                     Zakkiuddin Ahmed                2012\n",outContent.toString());
    }


    @Test
    public void ShouldCheckMenu() {

    new BibliotecaApp().CheckMenu();
    assertEquals("Menu\n" +
            "Press 1 for Books List\n",outContent.toString());
    }
    @Test
    public void ShouldCheckOptionChosen() {
        Scanner input = new Scanner("1");
        assertEquals(1, new BibliotecaApp().CheckOptionChosen(input));
    }
    @Test
    public void ShouldCheckDisplayOfBooks() {
        new BibliotecaApp().CheckDisplayOfBooks(1);
        assertEquals("Bookname                                  Author                        Year Published\n" +
                "Digital Fortress                         Dan Brown                       1998\n" +
                "Java The Complete Reference              Herbert Schildt                 2005\n" +
                "Software Engineering                     Zakkiuddin Ahmed                2012\n",outContent.toString());

    }
    @Test
    public void ShouldCheckInvalidMenuOption() {
        new BibliotecaApp().CheckInvalidMenuOption(2);
        assertEquals("Select a valid option\n", outContent.toString());

    }
    @Test
    public void ShouldCheckQuit() {
        Scanner input =new Scanner("Quit");
        assertEquals("Thank You!", new BibliotecaApp().CheckQuit(input));
    }
    @Test
    public void ShouldCheckOutBook() {
        Scanner input=new Scanner("Digital Fortress");
        assertEquals("Book Checked Out",new BibliotecaBorrowedbooks().CheckOutBook(input));
    }
    @Test
    public void ShouldCheckDisplayOfBooksAfterCheckOut() {
        Scanner input=new Scanner("Digital Fortress");
        new BibliotecaBorrowedbooks().CheckOutBook(input);
        new BibliotecaBorrowedbooks().DisplayAfterCheckOutOfBook();
        assertEquals("Bookname                                  Author                        Year Published\n" +
                "Java The Complete Reference              Herbert Schildt                 2005\n" +
                "Software Engineering                     Zakkiuddin Ahmed                2012\n", outContent.toString());
    }
    @Test
    public void ShouldCheckUnsuccessfullCheckout() {
        Scanner input=new Scanner("Digital Fortress");
        new BibliotecaBorrowedbooks().CheckOutBook(input);
        new BibliotecaBorrowedbooks().UnsuccessfulCheckout("Digital Fortress");
        assertEquals("That book is not available\n",outContent.toString());
    }
    @Test
    public void ShouldCheckReturnOfABook() {
        Scanner input=new Scanner("Digital Fortress");
        new BibliotecaBorrowedbooks().CheckOutBook(input);
        new BibliotecaBorrowedbooks().ReturningBook("Digital Fortress");
        assertEquals("Thank you for returning the book\n",outContent.toString());
    }
    @Test
    public void ShouldCheckUnsuccessfullReturn() {
        Scanner input=new Scanner("Digital Fortress");
        new BibliotecaBorrowedbooks().CheckOutBook(input);
        new BibliotecaBorrowedbooks().UnsuccessfullReturn("Digital Fortress");
        assertEquals("This is not a valid book to return\n",outContent.toString());
    }

}
