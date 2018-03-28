package edu.ncsu.csc326.coffeemaker.exceptions;

import edu.ncsu.csc326.coffeemaker.Inventory;

import org.junit.Assert;
import org.junit.Test;

public class InventoryExceptionTest {
    @Test
    /**
     * Test that an Inventory Exception is thrown and contains the expected message.
     */
    public void testInventoryException() {
        try {
            Inventory inv = new Inventory();
            //Add negative inventory. This should trigger an exception.
            inv.addChocolate("-5");
            Assert.fail("No exception was thrown!");
        }
        catch(InventoryException e) {
            Assert.assertEquals( "Validating Inventory Exception: ",
                    "Units of chocolate must be a positive integer", e.getMessage());
        }
    }
}
