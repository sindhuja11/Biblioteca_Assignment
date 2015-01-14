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
    public void shouldCheckOption1() {
        new BibliotecaApp().displayBookList();
        assertEquals("Digital Fortress,Dan Brown,1998\n" +
                "Java The Complete Reference,Herbert Schildt,2005\n" +
                "Software Engineering,Zakkiuddin Ahmed,2012\n",outContent.toString());


    }
    @Test
    public void shouldCheckInvalidMenuOption() {
        new BibliotecaApp().invalidMenuOption(5);
        assertEquals("Select a valid option\n", outContent.toString());

    }
    @Test
    public void shouldCheckQuit() {
        assertEquals("Thank You!", new BibliotecaApp().quit());
    }

}
