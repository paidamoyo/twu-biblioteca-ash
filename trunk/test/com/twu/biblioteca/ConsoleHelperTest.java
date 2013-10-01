package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ConsoleHelperTest {
    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @Before
    public void setUpStreams() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(originalOut);
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
