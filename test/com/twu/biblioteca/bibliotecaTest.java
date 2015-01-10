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
    public void ShouldCheckListOfBooks() {
        new BibliotecaApp().CheckDisplayOfBookList();
        assertEquals("Digital Fortress\n" +
                "Java The Complete Reference\n" +
                "Software Engineering\n", outContent.toString());
           }



}
