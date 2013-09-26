package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoviesCatalogTest extends ConsoleHelperTest {
    @Test
    public void shouldBeAbleToDisplayMovieList() throws IOException {
        MoviesCatalog movies = new MoviesCatalog();
        String expectedOutput = "Movie:Sarafina! Year:1992 Director:Darell Roodt Rating:10";
        movies.display();
        assertThat(getContentLine(1), is(expectedOutput));
    }
}
