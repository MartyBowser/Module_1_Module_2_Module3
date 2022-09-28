package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();


    public Accountable[] getAccounts() {

        Accountable[] accountList = new Accountable[accounts.size()];

        for (int i = 0; i < accounts.size(); i++) {
            accountList[i] = accounts.get(i);
        }

        return accountList;

    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip() {
        int balance = 0;
        for (Accountable Marty : accounts) {

            balance = Marty.getBalance() + balance;
        }
        if (balance >= 25000) {
            return true;
        }
        return false;
    }
}
