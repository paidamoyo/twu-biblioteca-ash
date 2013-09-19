package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoviesTest extends MenuTest {
    @Test
    public void shouldBeAbleToDisplayMovieList() throws IOException {
        Movies movies = new Movies();
        String expectedOutput = "Sarafina!" + " " + "1992" + " " + "Darell" + " " + "Roodt" + " " + "10";
        movies.display();
        assertThat(getContentLine(2), is(expectedOutput));
    }
}
