package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {
    public ArrayList<String> bookList;

    public Books() {
        bookList = new ArrayList<String>();
        bookList.add("Only Time Will Tell");
        bookList.add("Cain and Abel");
    }

    public void display() {
        System.out.println(bookList);
    }

    public void processReservation(String bookName) {
        if (bookList.contains(bookName)) {
            System.out.println("Thank You! Enjoy the book.");
        } else {
           System.out.println("Sorry we don't have that book yet");
        }
    }
}
