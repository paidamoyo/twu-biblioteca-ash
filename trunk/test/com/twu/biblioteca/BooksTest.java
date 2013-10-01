package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksTest extends ConsoleHelperTest {
    @Test
    public void shouldDisplayBookList() throws IOException {
        Books books = new Books();
        books.display();
        assertThat(getContentLine(1), is("[Only Time Will Tell, Cain and Abel]"));
    }

    @Test
    public void shouldBeAbleToReserveABookForCollection() throws IOException {
        Books books = new Books();
        books.processReservation("Only Time Will Tell");
        assertThat(getContentLine(1), is("Thank You! Enjoy the book."));
    }

    @Test
    public void shouldNotifyCustomerIfSelectedBookIsNotAvailable() {
        Books books = new Books();
        books.processReservation("This Book Is Not Available");
        assertThat(getContentLine(1), is("Sorry we don't have that book yet"));
    }
}
