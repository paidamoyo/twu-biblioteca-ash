package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksTest extends MenuTest {
    @Test
    public void shouldDisplayBookList() throws IOException {
        Books books = new Books();
        books.display();
        assertThat(getContentLine(1), is("[Only Time Will Tell, Cain and Abel]"));
    }
}
