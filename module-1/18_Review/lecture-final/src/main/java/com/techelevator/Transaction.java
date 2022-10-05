package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private BigDecimal beginningBalance;
    private BigDecimal endingBalance;

    private BigDecimal amountOfTransaction;
    private String merchantName;
    private LocalDate dateOfTransaction;

    public Transaction(BigDecimal amount, String merchant, LocalDate date) {
        this.amountOfTransaction = amount;
        this.merchantName = merchant;
        this.dateOfTransaction = date;
    }

    public BigDecimal getBeginningBalance() {
        return beginningBalance;
    }

    public BigDecimal getEndingBalance() {
        return endingBalance;
    }

    public BigDecimal getAmountOfTransaction() {
        return amountOfTransaction;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }
}
