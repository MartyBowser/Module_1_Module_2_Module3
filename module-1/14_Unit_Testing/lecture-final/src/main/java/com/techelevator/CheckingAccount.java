package com.techelevator;

public class CheckingAccount extends BankAccount{

    private static final double INTEREST_RATE = .0001;

    public CheckingAccount(String accountNumber, String accountName) {
        super(accountNumber, accountName);
    }

    public CheckingAccount(String accountNumber, String accountName, int balance) {
        super(accountNumber, accountName, balance);
    }

    @Override
    public double calculateOverdraftFee(int daysOverdrafted) {
        if(daysOverdrafted < 5 && getBalance() < 0) {
            return OVERDRAFT_FEE_TIER1;
        } else if (getBalance() < 0) {
            return OVERDRAFT_FEE_TIER2;
        }

        return 0;
    }

    @Override
    public double generateInterest() {

        return getBalance() * INTEREST_RATE;

    }

    @Override
    public String toString(){
        return getAccountName() + " (" + getAccountNumber().substring(getAccountNumber().length()-4) + ")";
    }
}
