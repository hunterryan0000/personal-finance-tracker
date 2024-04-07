package com.etse;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TransactionManagerTest {

    List<Transaction> transactionList = new ArrayList<>();
    TransactionManager tm = new TransactionManager();
    Transaction t1 = new Transaction("Income", new BigDecimal(100), LocalDate.parse("2024-03-28"));
    Transaction t2 = new Transaction("Income", new BigDecimal(10), LocalDate.parse("2024-03-28"));
    Transaction t3 = new Transaction("Expense", new BigDecimal(50), LocalDate.parse("2024-03-28"));

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    void addTransactions() {
        Collections.addAll(transactionList, t1,t2,t3);

        tm.addTransactions(t1);
        tm.addTransactions(t2);
        tm.addTransactions(t3);

        assertNotNull(transactionList);
        assertNotNull(tm.transactionList);
        assertEquals(transactionList, tm.transactionList);
        assertEquals(transactionList.size(), tm.transactionList.size());
        assertEquals(3, tm.transactionList.size());
        assertEquals(t1, tm.transactionList.get(0));
        assertEquals(new BigDecimal(BigInteger.TEN), tm.transactionList.get(1).getAmount());
        assertEquals("Expense", tm.transactionList.get(2).getType());

    }

    @Test
    public void testAddTransactions() {
        Transaction incomeTransaction = new Transaction("income", new BigDecimal("100.00"), LocalDate.parse("2024-04-07"));
        Transaction expenseTransaction = new Transaction("expense", new BigDecimal("50.00"), LocalDate.parse("2024-04-07"));

        tm.addTransactions(incomeTransaction);
        tm.addTransactions(expenseTransaction);

        // Assuming transactionList is package-private or a getter is provided for testing
        List<Transaction> transactions = tm.transactionList;

        assertNotNull(transactions);
        assertEquals(2, transactions.size());
        assertTrue(transactions.contains(incomeTransaction));
        assertTrue(transactions.contains(expenseTransaction));
    }

    @Test
    public void testPrintSummary() {
        // Setup: Adding an income and an expense transaction
        tm.addTransactions(new Transaction("income", new BigDecimal("200.00"), LocalDate.parse("2024-04-07")));
       tm.addTransactions(new Transaction("expense", new BigDecimal("50.00"), LocalDate.parse("2024-04-07")));

        // Action: Call printSummary and capture the result
        String summary = tm.printSummary();

        // Assert: Verify that the summary string matches expected output
        String expectedSummary = "Total income: $200.00" + System.lineSeparator() +
                "Total expense: $50.00" + System.lineSeparator() +
                "Net Income: $150.00";
        assertEquals(expectedSummary, summary);
    }

}