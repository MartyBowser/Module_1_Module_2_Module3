package com.techelevator;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);

    }

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {

    int ending = getBalance() - amountToWithdraw;

    if( ending >= 0){
            super.withdraw(amountToWithdraw);
        }else if(ending< 0 && ending > -100);{

            super.withdraw(amountToWithdraw + 10);
        }
        return getBalance();

    }

}

