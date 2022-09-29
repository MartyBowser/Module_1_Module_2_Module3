package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    private int overdraftFees;
    private String accountNumber;
    private String accountName;
    private int balance;
    private List<String> signers = new ArrayList<>();

    public static final int OVERDRAFT_FEE_TIER1 = 25;
    public static final int OVERDRAFT_FEE_TIER2 = 33;

    public BankAccount(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public BankAccount(String accountNumber, String accountName, int balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance= balance;
    }

    //getters
    public int getOverdraftFees(){
        return overdraftFees;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountName(){
        return accountName;
    }

    public int getBalance(){
        return balance;
    }

    public List<String> getSigners() {
        return signers;
    }

    //setters

    public void setSigners(List<String> signers){
        this.signers = signers;
    }

    // other methods
    public void addSigner(String name) {
        this.signers.add(name);
    }

    public abstract double calculateOverdraftFee(int daysOverdrafted);

    public abstract double generateInterest();

}
