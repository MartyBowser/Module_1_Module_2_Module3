package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    @Test
    public void less_20_test(){
        //Arrange
        Less20 less20Test = new Less20();

        //Act
        boolean results = less20Test.isLessThanMultipleOf20(18);

        //Assert
        Assert.assertEquals(true, results);

    }

}
