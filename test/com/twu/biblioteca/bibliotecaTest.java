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
    public void shouldCheckQuit() {
        assertEquals("Thank You!", new BibliotecaApp().quit());
    }


}
