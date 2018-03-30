package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest {

    private static CoffeeMaker cm;
    private static Recipe r1;
    private static Recipe r2;
    private static Recipe r3;
    private static Recipe r4;

    @BeforeClass
    public static void setUp() throws Exception {
        cm = new CoffeeMaker();

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        //Set up for r2
        r2 = new Recipe();
        r2.setName("Mocha");
        r2.setAmtChocolate("20");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("75");

        //Set up for r3
        r3 = new Recipe();
        r3.setName("Latte");
        r3.setAmtChocolate("0");
        r3.setAmtCoffee("3");
        r3.setAmtMilk("3");
        r3.setAmtSugar("1");
        r3.setPrice("100");

        //Set up for r4
        r4 = new Recipe();
        r4.setName("Hot Chocolate");
        r4.setAmtChocolate("4");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("1");
        r4.setAmtSugar("1");
        r4.setPrice("65");
    }

    /* Constructors Tests */
    @Test
    /**
     * Test the default constructor to ensure that a default Inventory and RecipeBook are created.
     */
    public void testDefaultConstructor() {
        String actualInventory = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        Assert.assertNotNull( "Constructor Test - validating not null: 1", cm);
        Assert.assertEquals("Constructor Test - validating Inventory: 2", actualInventory, cm.checkInventory());
        Assert.assertEquals("Constructor Test - validating RecipeBook: 3", 4, cm.getRecipes().length);
        for (Recipe r: cm.getRecipes()) {
            Assert.assertNull("RecipeBook - validating Constructor: 2", r);
        }
    }

    /* checkInventory Tests */
    @Test
    /**
     * Test adding inventory. This should be fundamentally the same as the test in the Inventory class so we'll combine some cases.
     */
    public void testCheckInventoryAddInventoryPosValues() {

    }


    /* getRecipes Tests */

    /* addRecipe Tests */

    /* deleteRecipe Tests */

    /* editRecipe Tests */

    /* addInventory Tests */

    /* makeCoffee Tests */
}
