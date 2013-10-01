package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class MoviesCatalog {
    private ArrayList<Movie> list;
    private PrintStream printStream;

    public MoviesCatalog(PrintStream printStream) {
        this.printStream = printStream;
        list = new ArrayList<Movie>();
        list.add(new Movie("Sarafina!", "1992", "Darell Roodt", "10"));
        list.add(new Movie("Avatar", "2009", "James Cameroon", "10"));
        list.add(new Movie("Inception", "2010", "Christopher Nolan", "9"));
        list.add(new Movie("The Hunger Games", "2012", "Gary Ross", "10"));
        list.add(new Movie("Neria", "1993", "Godwin Mawuru", "8"));
        list.add(new Movie("Tsosti", "2005", "Gavin Hood", "6"));
        list.add(new Movie("Titanic", "1997", "James Cameroon", "10"));
        list.add(new Movie("Mission Impossible", "1996", "Brian Palma", "5"));
        list.add(new Movie("Skin", "2009", "Anthony Fabian", "6"));
        list.add(new Movie("Yellow Card", "2000", "John Ribber", "7"));
        list.add(new Movie("More Time", "1994", "Isaac Mabikwa", "7"));
        list.add(new Movie("Slumdog Millionaire", "1975", "Danny Boyle", "6"));
        list.add(new Movie("The Kite Runner", "2007", "Marc Foster", "7"));
        list.add(new Movie("Half of a Yellow Sun", "2013", "Biyi Bandele", "N/A"));
        list.add(new Movie("Mandela: Long Walk to Freedom", "2013", "Justin Chadwick", "N/A"));
    }

    public void display() {
        for (Movie movie : list) {
           printStream.println(movie.toString());
        }
    }
}