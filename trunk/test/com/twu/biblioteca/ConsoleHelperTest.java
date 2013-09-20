package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ConsoleHelperTest {
    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    public void simulateUserInputIntoConsole(String userInput) throws IOException {
        ByteArrayInputStream inContent = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inContent);
    }

    public String getContentLine(int num) {
        String display[] = outContent.toString().split("\n");
        return display[num - 1];
    }
}
