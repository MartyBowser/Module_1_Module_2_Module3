package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    @Test
    public void get_herd_empty_string(){

    //Step 1 - Arrange
    String animal = "";
    AnimalGroupName agn = new AnimalGroupName();

    //Step 2 - Act
        String result = agn.getHerd(animal);

     //Step 3 - Assert
        Assert.assertEquals("unknown",result);


    }

    @Test
    public void get_herd_giraffe(){

        //Step 1 - Arrange
        String animal = "giraffe";
        AnimalGroupName agn = new AnimalGroupName();

        //Step 2 - Act
        String result = agn.getHerd(animal);

        //Step 3 - Assert
        Assert.assertEquals("Tower",result);


    }
}
