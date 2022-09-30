package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    @Test
    public void non_starter() {

        //step 1 - Arrange
        NonStart noStarter = new NonStart();

        //Step 2 - Act - call a method to get a result back


        //Step 3 - Assert - check to get back what you expected
        Assert.assertEquals("ellohere", noStarter.getPartialString("Hello", "There"));
    }

    @Test
    public void no_start_for_you() {

        //step 1 - Arrange
        NonStart nopeNope = new NonStart();

        //Step 2 - Act - call a method to get a result back


        //Step 3 - Assert - check to get back what you expected
        Assert.assertEquals("avaode", nopeNope.getPartialString("java", "code"));
    }

    @Test
    public void non_starting_again() {

        //step 1 - Arrange
        NonStart fireEmUp = new NonStart();

        //Step 2 - Act - call a method to get a result back


        //Step 3 - Assert - check to get back what you expected
        Assert.assertEquals("hotlava", fireEmUp.getPartialString("shotl", "java"));
    }
}