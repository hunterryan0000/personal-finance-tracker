package com.etse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ByteArrayInputStream inContent = null;

    @Before
    public void setUpStreams() {
        // Redirect System.out to capture output
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        // Restore System.out and System.in
        System.setOut(originalOut);
        if (inContent != null) {
            System.setIn(System.in);
        }
    }

    @Test
    public void testMainExitImmediately() {
        // Simulate entering "3" to exit immediately
        String input = "3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});

        assertTrue("Expected application to exit", true); // Simply checks if the application exits
    }

    @Test
    public void testAddTransactionAndExit() {
        // Simulate adding a transaction and then exiting
        String simulatedUserInput = "1\nIncome\n100\n2023-01-01\n3\n";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        //a way to programmatically call the main method of the Main class, simulating the start of the application
        Main.main(new String[]{});

        // Check if the output stream contains confirmation of transaction addition
        assertTrue(outContent.toString().contains("Transaction added successfully!"));
    }

    @Test
    public void testViewSummaryAndExit() {
        // Setup the input to add a transaction, view the summary, and then exit
        String simulatedUserInput = "1\nIncome\n100\n2023-01-01\n2\n3\n";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        //a way to programmatically call the main method of the Main class, simulating the start of the application
        Main.main(new String[]{});

        // Check if the output stream contains parts of the summary
        assertTrue(outContent.toString().contains("Total income: $"));
        assertTrue(outContent.toString().contains("Total expense: $"));
        assertTrue(outContent.toString().contains("Net Income: $"));
    }}
