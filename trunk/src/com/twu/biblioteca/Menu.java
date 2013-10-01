package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;

public class Menu {
    private static final String WELCOME_MESSAGE = "Welcome To The Bangalore Public Library";
    private static final String OPTION_VIEW_BOOK_LIST = "1. view a list of all the books in the library";
    private static final String OPTION_RESERVE_A_BOOK = "2. reserve a book from collection";
    private static final String OPTION_CHECK_MEMBERSHIP = "3. check your membership details";
    private static final String OPTION_VIEW_MOVIE_LIST = "4. view a list of all movies";
    private static final String OPTION_QUIT = "5. quit ";
    private static final String OPTION_LOG_IN = "6. log in";
    private static final int VIEW_BOOK_LIST_CHOICE = 1;
    private static final int RESERVE_A_BOOK_CHOICE = 2;
    private static final int CHECK_MEMBERSHIP_CHOICE = 3;
    private static final int VIEW_MOVIE_LIST_CHOICE = 4;
    private static final int LOG_OUT_CHOICE = 5;
    private static final int LOG_IN_CHOICE = 6;

    private boolean successfullyLoggedIn;
    private BufferedReader customerInput;
    private final HashMap<String, String> options;
    private MoviesCatalog movie;
    private Books books;
    private UserAccounts userAccounts;
    private String currentUser;
    private boolean quitProgram;

    public Menu() throws IOException {
        options = new HashMap<String, String>();
        options.put("1", OPTION_VIEW_BOOK_LIST);
        options.put("2", OPTION_RESERVE_A_BOOK);
        options.put("3", OPTION_CHECK_MEMBERSHIP);
        options.put("4", OPTION_VIEW_MOVIE_LIST);
        options.put("5", OPTION_QUIT);
        options.put("6", OPTION_LOG_IN);

        customerInput = new BufferedReader(new InputStreamReader(System.in));
        movie = new MoviesCatalog();
        books = new Books();
        userAccounts = new UserAccounts();
        successfullyLoggedIn = false;
    }

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        while (!menu.hasQuit()) {
            menu.displayMenuItems();
            menu.selectMenu(System.out);
        }
    }

    public boolean hasQuit() {
        return quitProgram;
    }

    public void displayMenuItems() throws IOException {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("Main Menu:");
        for (String option : options.values()) {
            System.out.println(option);
        }
    }

    public void selectMenu(PrintStream printStream) throws IOException {
        System.out.println("enter the number of your desired option:");
        String chosenOption = customerInput.readLine();
        displayUserInputChoice(chosenOption, printStream);
    }

    private void displayUserInputChoice(String choice, PrintStream printStream) throws IOException {
        if (!options.containsKey(choice)) {
            printStream.println(" Select a valid option!!");
        } else {
            printStream.println("You want to:" + options.get(choice));
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
                    break;
                case LOG_OUT_CHOICE:
                    quit();
                    break;
                case LOG_IN_CHOICE:
                    login();
                    break;
            }
        }
    }

    public void reserveBook() throws IOException {
        viewBooks();
        login();
        if (successfullyLoggedIn) {
            System.out.println("enter the title of the book you want to reserve:");
            String chosenBook = customerInput.readLine();
            books.processReservation(chosenBook);
        }
    }

    public void checkMembershipDetails() throws IOException {
        if (successfullyLoggedIn) {
            userAccounts.displayMembershipDetails(currentUser);
        } else {
            System.out.println("Please talk to a Librarian. Thank you.");
        }
    }

    public void viewBooks() throws IOException {
        System.out.println("Below is a list of all the books in the Bangalore library:");
        books.display();
    }

    public void viewMovies() throws IOException {
        login();
        if (successfullyLoggedIn) {
            movie.display();
        }
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

    private void authenticate(String username, String password) throws IOException {
        if (userAccounts.checkLoginDetails(username, password)) {
            currentUser = username;
            successfullyLoggedIn = true;
        } else {
            System.out.println("should be logged in to use library resources");
        }
    }

    public void quit() {
        quitProgram = true;
    }
}

