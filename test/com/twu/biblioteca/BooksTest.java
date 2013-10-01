package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BooksTest extends ConsoleHelperTest {


    @Test
    public void shouldDisplayBookList() throws IOException {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Books books = new Books(mockPrintStream);
        books.display();
        verify(mockPrintStream).println("[Only Time Will Tell, Cain and Abel]");
    }

    @Test
    public void shouldBeAbleToReserveABookForCollection() throws IOException {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Books books = new Books(mockPrintStream);
        books.processReservation("Only Time Will Tell");
        verify(mockPrintStream).println("Thank You! Enjoy the book.");
    }

    @Test
    public void shouldNotifyCustomerIfSelectedBookIsNotAvailable() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Books books = new Books(mockPrintStream);
        books.processReservation("This Book Is Not Available");
        verify(mockPrintStream).println("Sorry we don't have that book yet");
    }
}
