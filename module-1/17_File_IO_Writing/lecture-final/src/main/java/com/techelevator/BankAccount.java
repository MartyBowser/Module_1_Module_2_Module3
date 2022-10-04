package com.techelevator;

public class BankAccount {

    private String accountName;
    private String accountNumber;
    private double balance;

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

    public double getBalance() {
        return balance;
    }
}
