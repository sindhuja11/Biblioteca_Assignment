package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
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
    public void shouldCheckMenu() {

        new BibliotecaApp().menuDisplay();
        assertEquals("Menu\n" +
                "Press 1 for Books List\n" +
                "Press 2 for CheckOut Book\n"+
                "Press 3 for Return book\n" +
                "Press 4 for Quit\n"+
                "Press 5 for  Movie List\n" +
                "Press 6 for Checkout Movie\n"+
                "Press 7 for Login\n"+
                "Press 8 for Return Movie\n"+
                "Press 9 for checkout list\n"
                , outContent.toString());
    }

    @Test
    public void shouldCheckQuit() {
        assertEquals("Thank You!", new BibliotecaApp().quit());
    }


}
