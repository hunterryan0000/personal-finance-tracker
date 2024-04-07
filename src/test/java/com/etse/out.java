package com.etse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class out {
    public static void main(String[] args) {
        TransactionManager manager = new TransactionManager();

        // Add some transactions
        manager.addTransactions(new Transaction("income", new BigDecimal("50"), LocalDate.parse("2024-03-28")));
        manager.addTransactions(new Transaction("expense", new BigDecimal("25"), LocalDate.parse("2024-03-28")));
        manager.printSummary();

        System.out.println();

        // Define the expected output
        String expectedOutput =
                "Total income: $50" + System.lineSeparator() +
                        "Total expense: $25" + System.lineSeparator() +
                        "Net Income: $25";

        System.out.println(expectedOutput);
    }
}
