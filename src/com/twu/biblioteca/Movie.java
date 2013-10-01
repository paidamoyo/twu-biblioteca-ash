package com.twu.biblioteca;

import java.io.PrintStream;

public class Movie {

    private String name;
    private String year;
    private String director;
    private String rating;
    private PrintStream printStream;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.printStream = printStream;
    }

    @Override
    public String toString() {
        return "Movie:" + name + " " +
                "Year:" + year + " " +
                "Director:" + director + " " +
                "Rating:" + rating;
    }
}
