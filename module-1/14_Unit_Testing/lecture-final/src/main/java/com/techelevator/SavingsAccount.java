package com.techelevator;

public class SavingsAccount extends BankAccount{

    private int monthlyNumberOfWithdraws;

    private static final int MAX_MONTHLY_WITHDRAWS = 6;
    private static final double RECURRING_OVERDRAFT_FEE = 28.50;
    private static final double SAVINGS_ACCOUNT_INTEREST_RATE = .0005;

    public SavingsAccount(String accountNumber, String accountName) {
        super(accountNumber, accountName);
    }

    public SavingsAccount(String accountNumber, String accountName, int balance) {
        super(accountNumber, accountName, balance);
    }

    public double calculateOverdraftFee(int daysOverdrafted) {
        if(daysOverdrafted > 5) {
            return OVERDRAFT_FEE_TIER1;
        } else {
            return RECURRING_OVERDRAFT_FEE;
        }
    }

    public double generateInterest() {
        return getBalance() * SAVINGS_ACCOUNT_INTEREST_RATE;
    }
}
