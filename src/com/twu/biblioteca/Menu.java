package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private static final String WELCOME_MESSAGE = "Welcome To The Bangalore Public Library";
    private static final String OPTION_VIEW_LIST = "1. view a list of all the books in the library";
    private static final String OPTION_RESERVE_A_BOOK = "2. reserve a book from collection";
    private static final String OPTION_CHECK_MEMBERSHIP = "3. check your membership details";

    BufferedReader customerInput;
    public final HashMap<String, String> options;
    ArrayList<String> bookList;


    public Menu() throws IOException {
        bookList = new ArrayList<String>();
        options = new HashMap<String, String>();
        options.put("1", OPTION_VIEW_LIST);
        options.put("2", OPTION_RESERVE_A_BOOK);
        options.put("3", OPTION_CHECK_MEMBERSHIP);
        bookList.add("Only Time Will Tell");
        customerInput = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.start();
        menu.selectMenu();
    }

    public void start() {
        System.out.println(WELCOME_MESSAGE);
        displayOptions();
    }

    private void displayOptions() {
        String menuItems = "";
        System.out.println("Main Menu:");
        for (String key : options.keySet()) {
            menuItems = options.get(key) + " " + menuItems;
        }
        System.out.println(menuItems);
    }

    public void selectMenu() throws IOException {

        System.out.println("enter the number of your desired option:");
        String chosenOption = customerInput.readLine();
        displayUserInputChoice(chosenOption);
    }

    private void displayUserInputChoice(String userInput) throws IOException {
        if (!options.containsKey(userInput)) {
            throw new IllegalArgumentException(" Select a valid option!!");
        }
        System.out.println("You want to:" + options.get(userInput));

        switch (Integer.parseInt(userInput)) {
            case 1:
                viewBooks();
                break;
            case 2:
                reserveBook();
                break;
            case 3:
                checkMembershipDetails();
                break;
        }
    }

    public void reserveBook() throws IOException {
        System.out.println("enter the title of the book you want to reserve:");
        String chosenBook = customerInput.readLine();
        if (bookList.contains(chosenBook)) System.out.println("Thank You! Enjoy the book.");
        else throw new IllegalArgumentException("Sorry we don't have that book yet");
    }

    public void checkMembershipDetails() {
        System.out.println("Please talk to a Librarian. Thank you.");
    }

    public void viewBooks() {
        System.out.println("Below is a list of all the books in the Bangalore library:");
        System.out.println(bookList);
    }
}

