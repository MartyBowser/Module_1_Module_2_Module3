package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankCustomer {

    public static final String CHECKING = "checking";
    public static final String SAVINGS = "savings";
    public static final String HSA = "hsa";

    private Map<String, BankAccount> accounts = new HashMap<>();

    public BankCustomer() {
        accounts.put(CHECKING, new BankAccount("Checking","123"));
        accounts.put(SAVINGS, new BankAccount("Savings","789"));
        accounts.put(HSA, new BankAccount("My Hsa","456"));
    }

    public BankAccount getChecking() {
        return accounts.get(CHECKING);
    }

    public BankAccount getSavings(){
        return accounts.get(SAVINGS);
    }

    public BankAccount getHSA(){
        return accounts.get(HSA);
    }
}
