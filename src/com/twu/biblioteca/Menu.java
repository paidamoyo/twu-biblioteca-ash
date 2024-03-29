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
    private final HashMap<String, String> options;
    private MoviesCatalog movie;
    private Books books;
    private UserAccounts userAccounts;
    private String currentUser;
    private boolean quitProgram;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Menu(PrintStream printStream, BufferedReader bufferedReader) throws IOException {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        options = new HashMap<String, String>();
        options.put("1", OPTION_VIEW_BOOK_LIST);
        options.put("2", OPTION_RESERVE_A_BOOK);
        options.put("3", OPTION_CHECK_MEMBERSHIP);
        options.put("4", OPTION_VIEW_MOVIE_LIST);
        options.put("5", OPTION_QUIT);
        options.put("6", OPTION_LOG_IN);

        movie = new MoviesCatalog(printStream);
        books = new Books(printStream);
        userAccounts = new UserAccounts(printStream);
        successfullyLoggedIn = false;

    }

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu(System.out, new BufferedReader(new InputStreamReader(System.in)));
        while (!menu.hasQuit()) {
            menu.displayMenuItems();
            menu.selectMenu();
        }
    }

    public boolean hasQuit() {
        return quitProgram;
    }

    public void displayMenuItems() throws IOException {
        printStream.println(WELCOME_MESSAGE);
        printStream.println("Main Menu:");
        for (String option : options.values()) {
            printStream.println(option);
        }
    }

    public void selectMenu() throws IOException {
        printStream.println("enter the number of your desired option:");
        String chosenOption = bufferedReader.readLine();
        displayUserInputChoice(chosenOption);
    }

    private void displayUserInputChoice(String choice) throws IOException {
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
            printStream.println("enter the title of the book you want to reserve:");
            String chosenBook = bufferedReader.readLine();
            books.processReservation(chosenBook);
        }
    }

    public void checkMembershipDetails() throws IOException {
        if (successfullyLoggedIn) {
            userAccounts.displayMembershipDetails(currentUser);
        } else {
            printStream.println("Please talk to a Librarian. Thank you.");
        }
    }

    public void viewBooks() throws IOException {
        printStream.println("Below is a list of all the books in the Bangalore library:");
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
            printStream.println("Enter your username:");
            String username = bufferedReader.readLine();
            printStream.println("Enter your password:");
            String password = bufferedReader.readLine();
            authenticate(username, password);
        }
    }

    private void authenticate(String username, String password) throws IOException {
        if (userAccounts.checkLoginDetails(username, password)) {
            currentUser = username;
            successfullyLoggedIn = true;
        } else {
            printStream.println("should be logged in to use library resources");
        }
    }

    public void quit() {
        quitProgram = true;
    }
}

