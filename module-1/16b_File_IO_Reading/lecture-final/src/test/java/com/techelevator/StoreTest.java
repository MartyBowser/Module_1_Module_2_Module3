package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StoreTest {

    @Test
    public void init_store_test(){

        // Step 1 - Arrange
        Store myStore = new Store("Kroger", "123 Main St", 2);

        // Step 2 - Act
        String result = myStore.getAddress();

        // Step 3 - Assert
        Assert.assertEquals("123 Main St", result);
    }
}
