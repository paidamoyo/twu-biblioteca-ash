package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class MenuTest  {

    private BufferedReader mockBufferedReader;
    private PrintStream mockPrintStream;

    @Before
    public void setUp() {
        mockBufferedReader = mock(BufferedReader.class);
        mockPrintStream = mock(PrintStream.class);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() throws IOException {
        Menu menu = new Menu(mockPrintStream, mockBufferedReader);
        menu.displayMenuItems();
        verify(mockPrintStream).println("Welcome To The Bangalore Public Library");
        verify(mockPrintStream).println("Main Menu:");
    }

    @Test
    public void shouldSeeAListOfMenuOptionsAtTheStartOfTheApplication() throws IOException {
        Menu menu = new Menu(mockPrintStream, mockBufferedReader);
        menu.displayMenuItems();
        verify(mockPrintStream).println("3. check your membership details");
    }

    @Test
    public void shouldAllowCustomerToSelectMenuOptions() throws IOException {
        when(mockBufferedReader.readLine()).thenReturn("1");
        Menu menu = new Menu(mockPrintStream, mockBufferedReader);
        menu.selectMenu();
        verify(mockPrintStream).println("enter the number of your desired option:");
        verify(mockPrintStream).println("You want to:1. view a list of all the books in the library");
    }

    @Test
    public void shouldNotifyCustomerIfAnInvalidMenuOptionIsSelected() throws IOException {
        when(mockBufferedReader.readLine()).thenReturn("m");
        Menu menu = new Menu(mockPrintStream, mockBufferedReader);
        menu.selectMenu();
        verify(mockPrintStream).println(" Select a valid option!!");
    }

    @Test
    public void shouldBeAbleToCheckMembershipDetails() throws IOException {
        Menu menu = new Menu(mockPrintStream, mockBufferedReader);
        menu.checkMembershipDetails();
        verify(mockPrintStream).println("Please talk to a Librarian. Thank you.");
    }

    @Test
    public void shouldNotifyTheUserIfTheProgramIsQuit() throws IOException {
        Menu menu = new Menu(System.out, mockBufferedReader);
        menu.quit();
        assertTrue(menu.hasQuit());
    }
}
