package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by sindhum on 15/01/15.
 */
public class MovieParserTest {
    @Test
    public void shouldCheckReadOfAFile() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Harry Potter","2012","John Smith","9"));
        movies.add(new Movie("Inception","2009","Mike Tyson","-"));
        movies.add(new Movie("Happy days","2008","Prabhu","9"));
        ArrayList<Movie> returnedlist =new MovieParser().readFile();
        for (int noofmovies = 0; noofmovies < movies.size(); noofmovies++) {
            assertEquals(movies.get(noofmovies).getMovieName(), returnedlist.get(noofmovies).getMovieName());
            assertEquals(movies.get(noofmovies).getDirector(), returnedlist.get(noofmovies).getDirector());
            assertEquals(movies.get(noofmovies).getYearReleased(), returnedlist.get(noofmovies).getYearReleased());
            assertEquals(movies.get(noofmovies).getMovieRating(),returnedlist.get(noofmovies).getMovieRating());
        }
    }
}
