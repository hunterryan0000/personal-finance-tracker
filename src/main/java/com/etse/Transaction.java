package com.etse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private String type;
    private BigDecimal amount;
    private LocalDate date;

    public Transaction(String type, BigDecimal amount, LocalDate date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
