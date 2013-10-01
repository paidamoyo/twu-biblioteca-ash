package com.twu.biblioteca;


public class Movie {

    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie:" + name + " " +
                "Year:" + year + " " +
                "Director:" + director + " " +
                "Rating:" + rating;
    }
}
