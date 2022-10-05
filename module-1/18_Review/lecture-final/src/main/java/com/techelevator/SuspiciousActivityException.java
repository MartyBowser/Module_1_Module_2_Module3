package com.techelevator;

public class SuspiciousActivityException extends Exception{

    private BankAccount account;

    public SuspiciousActivityException(String message, BankAccount account){
        super(message);
        this.account = account;
    }

    public BankAccount getBankAccount(){
        return account;
    }
}
