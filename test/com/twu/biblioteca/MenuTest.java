package com.twu.biblioteca;


import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        Menu menu = new Menu();
        menu.selectMenu();
        assertThat(getContentLine(2), is("You want to:" + menu.options.get("1")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotifyCustomerIfAnInvalidMenuOptionIsSelected() throws IOException {
        simulateUserInputIntoConsole("m");
        Menu menu = new Menu();
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
}
