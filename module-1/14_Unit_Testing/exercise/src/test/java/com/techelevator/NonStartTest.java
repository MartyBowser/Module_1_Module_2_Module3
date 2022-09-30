package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    @Test
    public void bench_warmer() {
    String a = "";
    String b = "in";

        //step 1 - Arrange
        NonStart noStarter = new NonStart();

        //Step 2 - Act - call a method to get a result back
        String result = noStarter.getPartialString(a ,b);

        //Step 3 - Assert - check to get back what you expected
        Assert.assertEquals("ellohere", noStarter.getPartialString("Hello", "There"));
    }

    @Test
    public void no_start_for_you() {
    String C = "";
    String D = "in";


        //step 1 - Arrange
        NonStart nopeNope = new NonStart();

        //Step 2 - Act - call a method to get a result back
        String result = nopeNope.getPartialString(C ,D);

        //Step 3 - Assert - check to get back what you expected
        Assert.assertEquals("avaode", nopeNope.getPartialString("java", "code"));
    }

    @Test
    public void non_starting_again() {
       String a = "doubleDutch";
       String b = "cujoFierce";

        //step 1 - Arrange
        NonStart fireEmUp = new NonStart();

        //Step 2 - Act - call a method to get a result back
        String result = fireEmUp.getPartialString( b,a );

        //Step 3 - Assert - check to get back what you expected
        Assert.assertEquals("hotlava", fireEmUp.getPartialString("shotl", "java"));
    }
}