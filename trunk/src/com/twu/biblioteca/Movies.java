package com.twu.biblioteca;

import java.util.ArrayList;

public class Movies {
    private ArrayList<String> list;


    public Movies() {
        list = new ArrayList<String>();
        list.add("Sarafina!" + "/n" + "1992" + "/n" + "Darell Roodt" + "/n" + "10");
        list.add("Avatar" + "/n" + "2009" + "/n" + "James Cameroon" + "/n" + "10");
        list.add("Inception" + "/n" + "2010" + "/n" + "Christopher Nolan" + " " + "9");
        list.add("The Hunger Games" + "/n" + "2012" + "/n" + "Gary Ross" + "/n" + "10");
        list.add("Neria" + "/n" + "1993" + "/n" + "Godwin Mawuru" + "/n" + "8");
        list.add("Tsosti" + "/n" + "2005" + "/n" + "Gavin Hood" + "/n" + "6");
        list.add("Titanic" + "/n" + "1997" + "/n" + "James Cameroon" + "/n" + "10");
        list.add("Mission Impossible" + "/n" + "1996" + "/n" + "Brian Palma" + "/n" + "5");
        list.add("Skin" + "/n" + "2009" + "/n" + "Anthony Fabian" + "/n" + "6");
        list.add("Yellow Card" + "/n" + "2000" + "/n" + "John Ribber" + "/n" + "7");
        list.add("More Time" + "/n" + "1994" + "/n" + "Isaac Mabikwa" + "/n" + "7");
        list.add("Slumdog Millionaire" + "/n" + "1975" + "/n" + "Danny Boyle" + "/n" + "6");
        list.add("The Kite Runner" + "/n" + "2007" + "/n" + "Marc Foster" + "/n" + "7");
        list.add("Half of a Yellow Sun" + "/n" + "2013" + "/n" + "Biyi Bandele" + "/n" + "N/A");
        list.add("Mandela: Long Walk to Freedom" + "/n" + "2013" + "/n" + "Justin Chadwick" + "/n" + "N/A");
    }

    public void display() {
        for (String movie : list) {
            String[] array = movie.split("/n");
            System.out.println(addHeaders(array));
        }
    }

    private String addHeaders(String[] array) {
        String[] headers = {"Movie:", "Year:", "Director:", "Rating:"};
        String movie = "";
        for (int i = 0; i < array.length; i++) {
            movie = movie + "  " + headers[i] + array[i];
        }
        return movie;
    }
}
