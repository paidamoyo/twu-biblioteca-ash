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

}
