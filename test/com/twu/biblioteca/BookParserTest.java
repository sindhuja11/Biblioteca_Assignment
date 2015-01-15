package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 13/01/15.
 */
public class BookParserTest {
    @Test
    public void shouldCheckReadOfAFile() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Digital Fortress", "Dan Brown", "1998"));
        books.add(new Book("Java The Complete Reference", "Herbert Schildt", "2005"));
        books.add(new Book("Software Engineering", "Zakkiuddin Ahmed", "2012"));
        ArrayList<Book> returnedlist =new BookParser().readFile();
        for (int noofbooks = 0; noofbooks < books.size(); noofbooks++) {
            assertEquals(books.get(noofbooks).getBookName(), returnedlist.get(noofbooks).getBookName());
            assertEquals(books.get(noofbooks).getAuthor(), returnedlist.get(noofbooks).getAuthor());
            assertEquals(books.get(noofbooks).getyearPublished(), returnedlist.get(noofbooks).getyearPublished());
        }
    }
}
