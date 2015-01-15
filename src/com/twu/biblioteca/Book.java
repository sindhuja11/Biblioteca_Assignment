package com.twu.biblioteca;

/**
 * Created by Administrator on 13/01/15.
 */
public class Book {
   private String bookname;
   private String  author;
   private String yearpublished;


    Book(String bookname,String author,String yearpublished)
    {
        this.bookname=bookname;
        this.author=author;
        this.yearpublished=yearpublished;

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

}
