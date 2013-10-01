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
        setApplicationToStart();
        assertThat(getContentLine(1), is("Welcome To The Bangalore Public Library"));
    }

    private void setApplicationToStart() throws IOException {
        Menu menu = new Menu();
        menu.displayMenuItems();
    }

    @Test
    public void shouldSeeAListOfMenuOptionsAtTheStartOfTheApplication() throws IOException {
        setApplicationToStart();
        assertThat(getContentLine(3), is("3. check your membership details"));
    }

    @Test
    public void shouldAllowCustomerToSelectMenuOptions() throws IOException {
        simulateUserInputIntoConsole("1");
        PrintStream mockPrintStream = mock(PrintStream.class);
        Menu menu = new Menu();
        menu.selectMenu(mockPrintStream);
        verify(mockPrintStream).println("You want to:1. view a list of all the books in the library");
    }

    @Test
    public void shouldNotifyCustomerIfAnInvalidMenuOptionIsSelected() throws IOException {
        simulateUserInputIntoConsole("m");
        Menu menu = new Menu();
        menu.selectMenu(System.out);
        assertThat(getContentLine(2), is(" Select a valid option!!"));
    }

    @Test
    public void shouldBeAbleToCheckMembershipDetails() throws IOException {
        Menu menu = new Menu();
        menu.checkMembershipDetails();
        assertThat(getContentLine(1), is("Please talk to a Librarian. Thank you."));
    }

    @Test
    public void shouldNotifyTheUserIfTheProgramIsQuit() throws IOException {
        Menu menu = new Menu();
        menu.quit();
        assertTrue(menu.hasQuit());
    }
}
