package edu.ncsu.csc326.coffeemaker.expections;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import org.junit.Assert;
import org.junit.Test;

public class InventoryExceptionTest {
    @Test
    public void testInventoryException() {
        try {
            Inventory inv = new Inventory();
            //Add negative inventory. This should trigger an exception.
            inv.addChocolate("-5");
            //TODO: Add something here to make a test fail
        }
        catch(InventoryException e) {
            Assert.assertEquals( "Validating Inventory Exception: ",
                    "Units of chocolate must be a positive integer", e.getMessage());
        }
    }
}
