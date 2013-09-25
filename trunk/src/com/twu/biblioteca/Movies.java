package com.twu.biblioteca;

import java.util.ArrayList;

public class Movies {
    private ArrayList<String> list;

    public Movies() {
        list = new ArrayList<String>();
        list.add("Sarafina!" + " " + "1992" + " " + "Darell" + " " + "Roodt" + " " + "10");
        list.add("Avatar" + " " + "2009" + " " + "James" + " " + "Cameroon" + " " + "10");
        list.add("Inception" + " " + "2010" + " " + "Christopher" + " " + "Nolan" + " " + "9");
        list.add("The Hunger Games" + " " + "2012" + " " + "Gary" + " " + "Ross" + " " + "10");
        list.add("Neria" + " " + "1993" + " " + "Godwin" + " " + "Mawuru" + " " + "8");
        list.add("Tsosti" + " " + "2005" + " " + "Gavin" + " " + "Hood" + " " + "6");
        list.add("Titanic" + " " + "1997" + " " + "James" + " " + "Cameroon" + " " + "10");
        list.add("Mission Impossible" + " " + "1996" + " " + "Brian " + " " + "Palma" + " " + "5");
        list.add("Skin" + " " + "2009" + " " + "Anthony" + " " + "Fabian" + " " + "6");
        list.add("Yellow Card" + " " + "2000" + " " + "John" + " " + "Ribber" + " " + "7");
        list.add("More Time" + " " + "1994" + " " + "Isaac" + " " + "Mabikwa" + " " + "7");
        list.add("Slumdog Millionaire" + " " + "1975" + " " + "Danny" + " " + "Boyle" + " " + "6");
        list.add("The Kite Runner" + " " + "2007" + " " + "Marc" + " " + "Foster" + " " + "7");
        list.add("Half of a Yellow Sun" + " " + "2013" + " " + "Biyi" + " " + "Bandele" + " " + "N/A");
        list.add("Mandela: Long Walk to Freedom" + " " + "2013" + " " + "Justin" + " " + "Chadwick" + " " + "N/A");
    }

    public void display() {
        System.out.println("Movie" + "   " + "Year" + "   " + "Director" + "   " + "Rating:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //for (String movie : list)
    }
}
