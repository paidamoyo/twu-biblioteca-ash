package com.twu.biblioteca;


import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest extends ConsoleHelperTest {

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() throws IOException {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Menu menu = new Menu(mockPrintStream);
        menu.displayMenuItems(mockPrintStream);
        verify(mockPrintStream).println("Welcome To The Bangalore Public Library");
    }

    @Test
    public void shouldSeeAListOfMenuOptionsAtTheStartOfTheApplication() throws IOException {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Menu menu = new Menu(mockPrintStream);
        menu.displayMenuItems(mockPrintStream);
        verify(mockPrintStream).println("3. check your membership details");
    }

    @Test
    public void shouldAllowCustomerToSelectMenuOptions() throws IOException {
        simulateUserInputIntoConsole("1");
        PrintStream mockPrintStream = getPrintStreamForMenuSelection();
        verify(mockPrintStream).println("You want to:1. view a list of all the books in the library");
    }

    private PrintStream getPrintStreamForMenuSelection() throws IOException {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Menu menu = new Menu(mockPrintStream);
        menu.selectMenu(mockPrintStream);
        return mockPrintStream;
    }

    @Test
    public void shouldNotifyCustomerIfAnInvalidMenuOptionIsSelected() throws IOException {
        simulateUserInputIntoConsole("m");
        PrintStream mockPrintStream = getPrintStreamForMenuSelection();
        verify(mockPrintStream).println(" Select a valid option!!");
    }

    @Test
    public void shouldBeAbleToCheckMembershipDetails() throws IOException {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Menu menu = new Menu(mockPrintStream);
        menu.checkMembershipDetails();
        verify(mockPrintStream).println("Please talk to a Librarian. Thank you.");
    }

    @Test
    public void shouldNotifyTheUserIfTheProgramIsQuit() throws IOException {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Menu menu = new Menu(mockPrintStream);
        menu.quit();
        assertTrue(menu.hasQuit());
    }
}
