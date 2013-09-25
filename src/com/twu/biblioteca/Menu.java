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
    private static final int VIEW_BOOK_LIST_CHOICE = 1;
    private static final int RESERVE_A_BOOK_CHOICE = 2;
    private static final int CHECK_MEMBERSHIP_CHOICE = 3;
    private static final int VIEW_MOVIE_LIST_CHOICE = 4;
    private boolean successfullyLoggedIn;

    private BufferedReader customerInput;
    public final HashMap<String, String> options;
    private Movies movie;
    private Books books;
    private UserAccounts userAccounts;
    private String currentUser;

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
        successfullyLoggedIn = false;
    }

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.displayMenuItems();
    }

    public void displayMenuItems() throws IOException {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("Main Menu:");
        for (String option : options.values()) {
            System.out.println(option);
        }
        selectMenu();
    }

    public void selectMenu() throws IOException {
        System.out.println("enter the number of your desired option:");
        String chosenOption = customerInput.readLine();
        displayUserInputChoice(chosenOption);
    }

    private void displayUserInputChoice(String choice) throws IOException {
        if (!options.containsKey(choice)) {
            throw new IllegalArgumentException(" Select a valid option!!");
        }
        System.out.println("You want to:" + options.get(choice));
        switch (Integer.parseInt(choice)) {
            case VIEW_BOOK_LIST_CHOICE:
                viewBooks();
                break;
            case RESERVE_A_BOOK_CHOICE:
                reserveBook();
                break;
            case CHECK_MEMBERSHIP_CHOICE:
                checkMembershipDetails();
                break;
            case VIEW_MOVIE_LIST_CHOICE:
                viewMovies();
        }
    }

    public void reserveBook() throws IOException {
        login();
        System.out.println("enter the title of the book you want to reserve:");
        String chosenBook = customerInput.readLine();
        books.processReservation(chosenBook);
       displayMenuItems();
    }

    public void checkMembershipDetails() throws IOException {
        if (successfullyLoggedIn) {
            userAccounts.displayMembershipDetails(currentUser);
        } else {
            System.out.println("Please talk to a Librarian. Thank you.");
        }
       displayMenuItems();
    }

    public void viewBooks() throws IOException {
        System.out.println("Below is a list of all the books in the Bangalore library:");
        books.display();
        displayMenuItems();
    }

    public void viewMovies() throws IOException {
        login();
        movie.display();
        displayMenuItems();

    }

    private void login() throws IOException {
        if (!successfullyLoggedIn) {
            System.out.println("Enter your username:");
            String username = customerInput.readLine();
            System.out.println("Enter your password:");
            String password = customerInput.readLine();
            authenticate(username, password);
        }
    }

    private void authenticate(String username, String password) throws IllegalArgumentException {
        if (userAccounts.checkLoginDetails(username, password)) {
            currentUser = username;
            successfullyLoggedIn = true;
        } else {
            throw new IllegalArgumentException("should be logged in to use library resources");
        }
    }
}

