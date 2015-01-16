package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by sindhum on 16/01/15.
 */
public class LoginTest {
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
    public void shouldCheckSuccessfulluserLogin() {
        new Login().userLogin("123-1234","hello");
        assertEquals("login successfull\n", outContent.toString());
    }
    @Test
    public void shouldCheckUnsuccessfulluserLogin() {
        new Login().userLogin("123-123","hello");
        assertEquals("login unsuccessfull\n", outContent.toString());
    }
}
