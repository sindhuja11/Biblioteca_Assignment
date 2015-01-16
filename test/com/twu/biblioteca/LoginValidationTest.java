package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by sindhum on 15/01/15.
 */
public class LoginValidationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
   // ArrayList<String> libraryId=new ArrayList<String>();
    //ArrayList<String> password=new ArrayList<String>();
    ArrayList<User> users =new ArrayList<User>();
    private User user=new User("Sindhu","sindhum@thoughtworks.com","8390419567","123-1234","hello");

    // Login user=new Login("123-1234","hello");
    @Before
    public void setUpStreams() {

        /*libraryId.add("123-1234");
        libraryId.add("154-1357");
        password.add("hello");
        password.add("password");
        */
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
    public void shouldValidateUser()
    {
        LoginValidation user1=new LoginValidation(users);
        assertEquals(user.getUserID(), user1.loginValidation("123-1234","hello").getUserID());
        assertEquals(user.getPassword(), user1.loginValidation("123-1234", "hello").getPassword());

    }
    @Test
    public void shouldNotValidateUser()
    {
        LoginValidation user=new LoginValidation(users);
        assertEquals(null, user.loginValidation("12-1234","hello"));

    }
}