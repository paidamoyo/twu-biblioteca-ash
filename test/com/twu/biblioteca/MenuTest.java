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
        Menu menu = new Menu();
        menu.start();
        assertThat(getContentLine(1), is("Welcome To The Bangalore Public Library"));
    }

    @Test
    public void shouldSeeAListOfMenuOptionsAtTheStartOfTheApplication() throws IOException {
        Menu menu = new Menu();
        menu.start();
        assertThat(getContentLine(3), is("1. view a list of all the books in the library " +
                "2. reserve a book from collection " +
                "3. check your membership details "));
    }

    @Test
    public void shouldAllowCustomerToSelectMenuOptions() throws IOException {
        ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);
        Menu menu = new Menu();
        menu.selectMenu();
        assertThat(getContentLine(2), is("You want to:" + menu.options.get("1")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotifyCustomerIfAnInvalidMenuOptionIsSelected() throws IOException {
        ByteArrayInputStream inContent = new ByteArrayInputStream("m".getBytes());
        System.setIn(inContent);
        Menu menu = new Menu();
        menu.selectMenu();
    }

    @Test
    public void shouldViewAListOfAllBooksWhenTheViewBooksOptionIsSelected() throws IOException {
        Menu menu = new Menu();
        menu.viewBooks();
        assertThat(getContentLine(2), is("[Only Time Will Tell]"));
    }

    @Test
    public void shouldBeAbleToCheckMembershipDetails() throws IOException {
        Menu menu = new Menu();
        menu.checkMembershipDetails();
        assertThat(getContentLine(1), is("Please talk to a Librarian. Thank you."));
    }

    @Test
    public void shouldBeAbleToReserveABookForCollection() throws IOException {
        ByteArrayInputStream inContent = new ByteArrayInputStream("Only Time Will Tell".getBytes());
        System.setIn(inContent);
        Menu menu = new Menu();
        menu.reserveBook();
        assertThat(getContentLine(2), is("Thank You! Enjoy the book."));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotifyCustomerIfSelectedBookIsNotAvailable() throws IOException {
        ByteArrayInputStream inContent = new ByteArrayInputStream("This Book Is Not Available".getBytes());
        System.setIn(inContent);
        Menu menu = new Menu();
        menu.reserveBook();
    }

    public String getContentLine(int num) {
        String display[] = outContent.toString().split("\n");
        return display[num - 1];
    }
}