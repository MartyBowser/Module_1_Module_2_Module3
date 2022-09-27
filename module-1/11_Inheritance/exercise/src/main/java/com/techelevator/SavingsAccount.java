package com.techelevator;


    public class SavingsAccount extends BankAccount {
        public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
            super(accountHolderName, accountNumber, balance);

        }

        public SavingsAccount(String accountHolderName, String accountNumber) {
            super(accountHolderName, accountNumber);
        }

        @Override
        public int withdraw(int amountToWithdraw) {

            int ending = getBalance() - amountToWithdraw;

            if ( ending < 150 && ending > 1 ) {
                super.withdraw(amountToWithdraw +2 );
            } if (ending >= 150 ){

                super.withdraw(amountToWithdraw);
            }
            return getBalance();

        }





}
