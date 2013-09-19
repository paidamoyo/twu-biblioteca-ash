package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

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
        Menu menu =simulateUserInputIntoConsole("1");
        menu.selectMenu();
        assertThat(getContentLine(2), is("You want to:" + menu.options.get("1")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotifyCustomerIfAnInvalidMenuOptionIsSelected() throws IOException {
        Menu menu = simulateUserInputIntoConsole("m");
        menu.selectMenu();
    }

    @Test
    public void shouldBeAbleToCheckMembershipDetails() throws IOException {
        Menu menu = new Menu();
        menu.checkMembershipDetails();
        assertThat(getContentLine(1), is("Please talk to a Librarian. Thank you."));
    }
    @Test
    public void shouldBeAbleToReserveABookForCollection() throws IOException {
        simulateUserInputIntoConsole("Only Time Will Tell");
       Menu menu = new Menu();
        menu.reserveBook();
        assertThat(getContentLine(2), is("Thank You! Enjoy the book."));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotifyCustomerIfSelectedBookIsNotAvailable() throws IOException {
        simulateUserInputIntoConsole("This Book Is Not Available");
        Menu menu = new Menu();
        menu.reserveBook();
    }

    public Menu simulateUserInputIntoConsole(String userInput) throws IOException {
        ByteArrayInputStream inContent = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inContent);
        return new Menu();
    }

    public String getContentLine(int num) {
        String display[] = outContent.toString().split("\n");
        return display[num - 1];
    }
}
