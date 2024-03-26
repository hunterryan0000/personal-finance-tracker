package com.etse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    List<Transaction> transactionList = new ArrayList<>();

    public void addTransactions(String type,
                                BigDecimal amount,
                                LocalDate date) {
        transactionList.add(new Transaction(type, amount, date));
    }

    public void printSummary() {
        BigDecimal income = new BigDecimal(BigInteger.ZERO);
        BigDecimal expense = new BigDecimal(BigInteger.ZERO);

        for (Transaction t : transactionList) {

            if (t.getType().equalsIgnoreCase("income")) {
                income = income.add(t.getAmount());
            } else if (t.getType().equalsIgnoreCase("expense")) {
                expense = expense.add(t.getAmount());
            }

        }

        System.out.println("Total income: $" + income);
        System.out.println("Total expense: $" + expense);
        System.out.println("Net Income: $" + income.subtract(expense));
    }
}
