package com.techelevator.example;

public class BankAccount {

    private String accountNumber;
    private String accountName;
    private boolean locked;
    private int debits = 10;
    private int credits = 20;

    // An example of only revealing part of the variable even tho we are
    // providing a getter
    public String getAccountNumber(){
        if(!locked) {
            return "********" + accountNumber.substring(accountNumber.length() - 4);
        }
        else {
            return "We are sorry. Your account is locked.";
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    // when our property is a boolean, instead of saying "get"
    // say "is"
    public boolean isLocked() {
        return locked;
    }

    // derived property - we calculate it on the spot
    public int getBalance() {
        return credits - debits;
    }
}
