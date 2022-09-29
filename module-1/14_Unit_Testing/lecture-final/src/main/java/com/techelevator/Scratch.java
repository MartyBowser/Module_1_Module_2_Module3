package com.techelevator;

public class Scratch {

    public static void main(String[] args) {

        BankAccount ba = new CheckingAccount("1234556789", "Primary Account");

        String bankAccountString = ba.toString();
        System.out.println(bankAccountString);
    }
}
