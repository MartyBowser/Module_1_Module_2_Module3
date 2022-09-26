package com.techelevator;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);

    }
    public CheckingAccount(String accountHolderName,String accountNumber, int balance){
        super(accountHolderName,accountNumber, balance);
    }
}
