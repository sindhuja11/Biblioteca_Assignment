package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by sindhum on 16/01/15.
 */
public class UserDetailsParserTest {
    @Test
    public void shouldCheckReadOfAFile() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Sindhu","sindhum@thoughtworks.com","8390419567","123-1234","hello"));
        users.add(new User("Aishwarya","aish@gmail.com","7986342156","154-1357","password"));
        ArrayList<User> returnedlist =new UserDetailsParser().readFile();
        for (int noofusers = 0; noofusers < users.size(); noofusers++) {
            assertEquals(users.get(noofusers).getName(), returnedlist.get(noofusers).getName());
            assertEquals(users.get(noofusers).getEmail(), returnedlist.get(noofusers).getEmail());
            assertEquals(users.get(noofusers).getPhoneNumber(), returnedlist.get(noofusers).getPhoneNumber());

        }
    }
}
