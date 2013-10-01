package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class Books {
    private ArrayList<String> bookList;
    private PrintStream printStream;

    public Books(PrintStream printStream) {
        this.printStream = printStream;
        bookList = new ArrayList<String>();
        bookList.add("Only Time Will Tell");
        bookList.add("Cain and Abel");
    }

    public void display() {
        printStream.println(bookList.toString());
    }

    public void processReservation(String bookName) {
        if (bookList.contains(bookName)) {
            printStream.println("Thank You! Enjoy the book.");
        } else {
            printStream.println("Sorry we don't have that book yet");
        }
    }
}
