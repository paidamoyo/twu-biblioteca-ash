package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    public static final String welcome_Message = "Welcome To The Bangalore Public Library";
    private static Scanner customer_Input = new Scanner(System.in);
    private static String chosen_Option;
    public static final String option_One = "1. view a list of all the books in the library";
    public static final String option_Two = "2. reserve a book for collection";
    public static final String option_Three = "3. check your membership details";
    public static final String options = option_One + " " + option_Two + " "+ option_Three;


    public Menu() {
        start();
    }

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println(welcome_Message);
        displayOptions();
    }

    private  static void options (){

    }
    public static void displayOptions() {

        System.out.println("Main Menu:");
        System.out.println(options);


    }
}

