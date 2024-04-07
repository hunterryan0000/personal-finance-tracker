package com.etse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    List<Transaction> transactionList = new ArrayList<>();

    public void addTransactions(Transaction t) {
        transactionList.add(t);
    }

    public String printSummary() {
        BigDecimal income = new BigDecimal(BigInteger.ZERO);
        BigDecimal expense = new BigDecimal(BigInteger.ZERO);

        for (Transaction t : transactionList) {

            if (t.getType().equalsIgnoreCase("income")) {
                income = income.add(t.getAmount());
            } else if (t.getType().equalsIgnoreCase("expense")) {
                expense = expense.add(t.getAmount());
            }

        }

        return (
                "Total income: $" + income + System.lineSeparator() +
                        "Total expense: $" + expense + System.lineSeparator() +
                        "Net Income: $" + income.subtract(expense)
        );
    }
}
