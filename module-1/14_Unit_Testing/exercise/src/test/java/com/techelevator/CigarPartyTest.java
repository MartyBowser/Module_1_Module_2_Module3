package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    @Test
    public void test_for_cuban_cigars_false() {

        //Arrange

        CigarParty cp = new CigarParty();

        //Act
        boolean results = cp.haveParty(30, false);
        //Assert

        Assert.assertEquals(false, results);
    }
        @Test
        public void test_for_cuban_cigars_true() {

            //arrange
            CigarParty cp = new CigarParty();

            //Act
            boolean results = cp.haveParty(50, false);


            //Assert
            Assert.assertEquals(true, results);


    }

    @Test
    public void test_for_cuban_cigars_T_T(){
        //arrange
        CigarParty cp = new CigarParty();

        //ACT
        boolean results = cp.haveParty(70,true);

        //Assert

        Assert.assertEquals(true, results);




    }


}
