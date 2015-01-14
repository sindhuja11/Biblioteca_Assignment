package com.twu.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 13/01/15.
 */
public class BookParserTest {
    @Test
    public void shouldCheckReadOfAFile() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Digital Fortress", "Dan Brown", "1998", 1));
        books.add(new Book("Java The Complete Reference", "Herbert Schildt", "2005", 1));
        books.add(new Book("Software Engineering", "Zakkiuddin Ahmed", "2012", 1));
        for (int noofbooks = 0; noofbooks < books.size(); noofbooks++) {
            assertEquals(books.get(noofbooks).getBookName(), new BookParser().readFile().get(noofbooks).getBookName());
            assertEquals(books.get(noofbooks).getAuthor(), new BookParser().readFile().get(noofbooks).getAuthor());
            assertEquals(books.get(noofbooks).getyearPublished(), new BookParser().readFile().get(noofbooks).getyearPublished());
        }
    }
}
