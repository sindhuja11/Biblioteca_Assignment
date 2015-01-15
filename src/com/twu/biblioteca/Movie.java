package com.twu.biblioteca;

/**
 * Created by sindhum on 15/01/15.
 */
public class Movie {
    private String movieName;
    private String yearReleased;
    private String director;
    private String movieRating;

    public Movie(String movieName, String yearReleased, String director, String movieRating) {
        this.movieName=movieName;
        this.yearReleased=yearReleased;
        this.director=director;
        this.movieRating=movieRating;
    }

    public String getMovieName()
    {
        return movieName;
    }
    public String getYearReleased()
    {
        return yearReleased;
    }
    public String getDirector()
    {
        return director;
    }
    public String getMovieRating()
    {
        return movieRating;
    }



}

