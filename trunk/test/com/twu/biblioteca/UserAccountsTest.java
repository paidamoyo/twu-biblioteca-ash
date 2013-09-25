package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserAccountsTest extends ConsoleHelperTest {

    @Test
    public void shouldDisplayUserInformationIfLoggedIn() throws IOException {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.displayMembershipDetails("111-1111");
        assertThat(getContentLine(1), is("Name:Ash Phone:919 423 3888 email:tt@gmail.com"));
    }
}
