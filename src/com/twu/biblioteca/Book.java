package com.twu.biblioteca;

/**
 * Created by Administrator on 13/01/15.
 */
public class Book {
   private String bookname;
   private String  author;
   private String yearpublished;
   private boolean availability;


    Book(String bookname,String author,String yearpublished,boolean availability)
    {
        this.bookname=bookname;
        this.author=author;
        this.yearpublished=yearpublished;
        this.availability=availability;
    }

    public String getBookName() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public String getyearPublished() {
        return yearpublished;
    }

    public boolean getAvailability() { return availability; }



    public void setNotAvailable() {
        availability=false;
    }

    public void setAvailable() {
        availability=true;
    }
}
