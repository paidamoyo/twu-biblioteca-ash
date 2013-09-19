package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserAccountsTest extends  ConsoleHelperTest{

    @Test
    public void shouldDisplayUserInformationIfLoggedIn() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.displayMembershipDetails("111-1111", "1");
        assertThat(getContentLine(1), is("Name:Ash Phone:919 423 3888 email:tt@gmail.com"));
    }

    @Test
    public void shouldDisplayAskLibrarianMessageIfNotLoggedIn() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.displayMembershipDetails("111-1111", "5");
        assertThat(getContentLine(1), is("Please talk to a Librarian. Thank you."));
    }
}
