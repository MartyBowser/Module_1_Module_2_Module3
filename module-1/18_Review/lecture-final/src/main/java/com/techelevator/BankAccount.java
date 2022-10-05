package com.techelevator;

import java.math.BigDecimal;

public class BankAccount implements Accountable {

    private String accountName;
    private String accountNumber;
    private BigDecimal balance;

    public BankAccount(String accountName, String accountNumber){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public String getAccountName(){
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amountToWithrdraw){
        balance = balance.subtract(amountToWithrdraw);
        return balance;
    }

    public BigDecimal deposit(BigDecimal amountToDeposit) {
        balance = balance.add(amountToDeposit);
        return balance;
    }
}
