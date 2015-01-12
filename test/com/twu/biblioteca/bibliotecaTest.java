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
    public void shouldCheckWelcomeMessage() {
        new BibliotecaApp().welcomeMessage();
        assertEquals("hello!Welcome to Biblioteca\n", outContent.toString());
    }
    @Test
    public void ShouldCheckBookDetails() {
        new BibliotecaApp().displayOfBookDetails();
        assertEquals("Bookname                                  Author                        Year Published\n" +
                "Digital Fortress                         Dan Brown                       1998\n" +
                "Java The Complete Reference              Herbert Schildt                 2005\n" +
                "Software Engineering                     Zakkiuddin Ahmed                2012\n",outContent.toString());
    }


    @Test
    public void shouldCheckMenu() {

    new BibliotecaApp().menuDisplay();
    assertEquals("Menu\n"+
            "Press 1 for Books List\n"+
        "Press 2 for CheckOut\n"+
        "Press 3 for Return\n"+
        "Press 4 for Quit\n",outContent.toString());
    }
    @Test
    public void shouldCheckOptionChosen() {
        Scanner input = new Scanner("1");
        assertEquals(1, new BibliotecaApp().optionChosen(input));
    }
    @Test
    public void shouldCheckSelectedOption() {
        new BibliotecaApp().selectedOption(1);
        assertEquals("Bookname                                  Author                        Year Published\n" +
                "Digital Fortress                         Dan Brown                       1998\n" +
                "Java The Complete Reference              Herbert Schildt                 2005\n" +
                "Software Engineering                     Zakkiuddin Ahmed                2012\n",outContent.toString());

    }
    @Test
    public void shouldCheckInvalidMenuOption() {
        new BibliotecaApp().invalidMenuOption(5);
        assertEquals("Select a valid option\n", outContent.toString());

    }
    @Test
    public void shouldCheckQuit() {
        assertEquals("Thank You!", new BibliotecaApp().quit(4));
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
