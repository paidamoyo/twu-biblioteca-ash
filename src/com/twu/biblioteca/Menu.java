package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Menu {
    private static final String WELCOME_MESSAGE = "Welcome To The Bangalore Public Library";
    private static final String OPTION_VIEW_BOOK_LIST = "1. view a list of all the books in the library";
    private static final String OPTION_RESERVE_A_BOOK = "2. reserve a book from collection";
    private static final String OPTION_CHECK_MEMBERSHIP = "3. check your membership details";
    private static final String OPTION_VIEW_MOVIE_LIST = "4. view a list of all movies";
    private static final int KEY_VIEW_BOOK_LIST = 1;
    private static final int KEY_RESERVE_A_BOOK = 2;
    private static final int KEY_CHECK_MEMBERSHIP = 3;
    private static final int KEY_VIEW_MOVIE_LIST = 4;

    private BufferedReader customerInput;
    public final HashMap<String, String> options;
    private Movies movie;
    private Books books;
    private UserAccounts userAccounts;
    private String username;
    private String password;

    public Menu() throws IOException {
        options = new HashMap<String, String>();
        options.put("1", OPTION_VIEW_BOOK_LIST);
        options.put("2", OPTION_RESERVE_A_BOOK);
        options.put("3", OPTION_CHECK_MEMBERSHIP);
        options.put("4", OPTION_VIEW_MOVIE_LIST);
        customerInput = new BufferedReader(new InputStreamReader(System.in));
        movie = new Movies();
        books = new Books();
        userAccounts = new UserAccounts();
    }

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.displayMenuItems();
        menu.selectMenu();
    }

    public void displayMenuItems() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("Main Menu:");
        for (String option : options.values()) {
            System.out.println(option);
        }
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
            case KEY_VIEW_BOOK_LIST:
                viewBooks();
                break;
            case KEY_RESERVE_A_BOOK:
                reserveBook();
                break;
            case KEY_CHECK_MEMBERSHIP:
                checkMembershipDetails();
                break;
            case KEY_VIEW_MOVIE_LIST:
                viewMovies();
        }
    }

    public void reserveBook() throws IOException {
        if (login()) {
            System.out.println("enter the title of the book you want to reserve:");
            String chosenBook = customerInput.readLine();
            books.processReservation(chosenBook);
        }
    }

    public void checkMembershipDetails() throws IOException {
        userAccounts.displayMembershipDetails(username, password);
    }

    public void viewBooks() {
        System.out.println("Below is a list of all the books in the Bangalore library:");
        books.display();
    }

    public void viewMovies() throws IOException {
        if (login()) {
            movie.display();
        }
    }

    public boolean login() throws IOException {
        System.out.println("Enter your username:");
        username = customerInput.readLine();
        System.out.println("Enter your password:");
        password = customerInput.readLine();
        return userAccounts.checkLoginDetails(username, password);
    }
}

