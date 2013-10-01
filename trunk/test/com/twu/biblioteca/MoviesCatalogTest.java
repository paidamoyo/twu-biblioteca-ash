package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MoviesCatalogTest extends ConsoleHelperTest {
    @Test
    public void shouldBeAbleToDisplayMovieList() throws IOException {
        PrintStream mockPrintStream = mock(PrintStream.class);
        MoviesCatalog movies = new MoviesCatalog(mockPrintStream);
        String expectedOutput = "Movie:Sarafina! Year:1992 Director:Darell Roodt Rating:10";
        movies.display();
        verify(mockPrintStream).println(expectedOutput);
    }
}
