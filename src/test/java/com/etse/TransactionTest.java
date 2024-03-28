package com.etse;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    Transaction incomeTransaction = new Transaction("Income", new BigDecimal(100), LocalDate.of(2024, 3, 27));
    Transaction expenseTransaction = new Transaction("Expense", new BigDecimal(50), LocalDate.parse("2024-03-27"));



    @Test
    void getType() {
        String type = "Income";
        assertNotNull(type);
        assertNotNull(incomeTransaction.getType());
        assertEquals(type, incomeTransaction.getType());
        type = "Expense";
        assertNotNull(type);
        assertNotNull(expenseTransaction.getType());
        assertEquals(type, expenseTransaction.getType());

    }

    @Test
    void getAmount() {
        BigDecimal amount = new BigDecimal(100);
        assertNotNull(amount);
        assertNotNull(incomeTransaction.getAmount());
        assertEquals(amount, incomeTransaction.getAmount());
        amount = new BigDecimal(50);
        assertNotNull(amount);
        assertNotNull(expenseTransaction.getAmount());
    }

    @Test
    void getDate() {
        LocalDate date = LocalDate.parse("2024-03-27");
        assertNotNull(date);
        assertNotNull(incomeTransaction.getDate());
        assertEquals(date, incomeTransaction.getDate());
        date = LocalDate.of(2024, 3, 27);
        assertNotNull(date);
        assertNotNull(expenseTransaction.getDate());
        assertEquals(date, expenseTransaction.getDate());
    }
}