package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserAccountsTest {

    @Test
    public void shouldDisplayUserInformationIfLoggedIn() throws IOException {
        PrintStream mockPrintStream = mock(PrintStream.class);
        UserAccounts userAccounts = new UserAccounts(mockPrintStream);
        userAccounts.displayMembershipDetails("111-1111");
        verify(mockPrintStream).println("Name:Ash Phone:919 423 3888 email:tt@gmail.com");
    }
}
