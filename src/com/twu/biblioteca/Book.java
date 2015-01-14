package com.twu.biblioteca;

/**
 * Created by Administrator on 13/01/15.
 */
public class Book {
   private String bookname;
   private String  author;
   private String yearpublished;
   private int availability;


    Book(String bookname,String author,String yearpublished,int availability)
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

    public int getAvailability() {

    return availability;
    }

    public void setAvailability() {
        availability=0;
    }



}
