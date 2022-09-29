package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {

    private BankAccount ba;
    private BankAccount baWithNegativeNumbers;

    @Before
    public void setup(){
        ba = new CheckingAccount("123","MyAccount");
        ba.addSigner("Christopher");

        baWithNegativeNumbers = new CheckingAccount("123","MyAccount", -100);

    }

    @Test
    public void test_checking_account_fee_when_negative_balance_3days() {

        //Arrange
        // this is handled in the setup method now

        //Act
        double result = baWithNegativeNumbers.calculateOverdraftFee(3);

        //Assert
        // if we are testing if doubles are equal, because computers have trouble
        // keeping track of all decimals on a double and can soemtimes round, we want
        // to include a third parameter that is a tolerance level of how close the results
        // can be and still be considered equal
        Assert.assertEquals(BankAccount.OVERDRAFT_FEE_TIER1, result, .0001);

    }

    @Test
    public void test_checking_account_fee_when_positive_balance_3days() {

        //Arrange
        // this is handled in the setup method now

        //Act
        double result = ba.calculateOverdraftFee(3);

        //Assert
        // if we are testing if doubles are equal, because computers have trouble
        // keeping track of all decimals on a double and can soemtimes round, we want
        // to include a third parameter that is a tolerance level of how close the results
        // can be and still be considered equal
        Assert.assertEquals(0, result, .0001);

    }

    // for tests, you can typically always
    // just do public void since we do asserts
    // but don't really return any values
    @Test
    public void new_checking_account_saves_account_number(){

        //Arrange - where we initialize the variables
        //          we need for the test
        //BankAccount ba = new CheckingAccount("123","MyAccount");

        //Act - where we call a method to get an expected result back
        String result = ba.getAccountNumber();

        //Assert - where we use the Assert library from junit to confirm
        //         the result matches what we expect
        Assert.assertEquals("123", result);
    }

    @Test
    public void new_checking_account_saves_account_name(){

        //Arrange - where we initialize the variables
        //          we need for the test
        //BankAccount ba = new CheckingAccount("123","MyAccount");

        //Act - where we call a method to get an expected result back
        String result = ba.getAccountName();

        //Assert - where we use the Assert library from junit to confirm
        //         the result matches what we expect
        Assert.assertEquals("MyAccount", result);
    }
}
