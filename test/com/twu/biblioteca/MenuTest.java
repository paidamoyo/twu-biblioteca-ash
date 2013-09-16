package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        Menu menu = new Menu();
        assertThat(menu.welcome_Message, is(getContentLine(0)));

    }
      @Test
      public void shouldSeeAListOfMenuOptionsAtTheStartOfTheApplication(){
          Menu menu = new Menu();
          assertThat(menu.options, is (getContentLine(2)))  ;
      }

    public String getContentLine(int num) {
        String display []   = outContent.toString().split("\n")  ;
      return display[num]  ;
    }



    @After
    public void cleanUpStreams() {
        System.setOut(null);

    }
}
