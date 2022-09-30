package com.techelevator;

import com.techelevator.StringBits;
import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    @Test
    public void string_bits_get_bits(){
        //Arrange
        StringBits itsyBitsy = new StringBits();

        //Act
        String hello = "hello";
        String result=itsyBitsy.getBits(hello);

        //Assert
        Assert.assertEquals("hlo",result);







    }

}
