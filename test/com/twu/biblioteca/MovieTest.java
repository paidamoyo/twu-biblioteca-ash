package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieTest {

    @Test
    public void shouldDisplayAMovieWithNameYearDirectorAndRating() {
     Movie movie = new Movie ("Sarafina!", "1992" ,"Darell Roodt", "10");
        assertThat (movie.toString(), is( "Movie:Sarafina! Year:1992" +
                " Director:Darell Roodt Rating:10"));
    }
}
