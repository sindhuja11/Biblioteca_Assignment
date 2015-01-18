package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by sindhum on 16/01/15.
 */
public class LoginTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    ArrayList<User> users=new ArrayList<User>();
    private User user=new User("Sindhu","sindhum@thoughtworks.com","8390419567","123-1234","hello");

    @Before
    public void setUpStreams() {
        users.add(user);
        users.add(new User("Aishwarya","aish@gmail.com","7986342156","154-1357","password"));
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
        new Login(users).loginValidate("123-1234", "hello");
        assertEquals("login successfull\n", outContent.toString());
    }
    @Test
    public void shouldCheckUnsuccessfulluserLogin() {
        new Login(users).loginValidate("123-123", "hello");
        assertEquals("login unsuccessfull\n", outContent.toString());
    }
}
