package com.techelevator;

import com.techelevator.Lucky13;
import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
    @Test
    public void lucky_number_13_Test(){
   //Arrange
        Lucky13 lucky13TestUno = new Lucky13();

        //Act
        boolean result = lucky13TestUno.getLucky(new int[]{0,2,4});

        //Assert
        Assert.assertEquals(true, result);


    }

    @Test
    public void lucky_number_13_the_Sequel_Test(){

    //Arrange
        Lucky13 lucky13TestDous = new Lucky13();


       // Act
        boolean result = lucky13TestDous.getLucky(new int[]{1,2,3});

        //Assert
        Assert.assertEquals(false, result);

    }

    @Test
    public void lucky_number_13_the_Trilogy_Test(){

    //Arrange
        Lucky13 lucky13TestTres = new Lucky13();

        //Act
        boolean result = lucky13TestTres.getLucky(new int[]{1,2,4});

    //
        Assert.assertEquals(false, result);

    }



}
