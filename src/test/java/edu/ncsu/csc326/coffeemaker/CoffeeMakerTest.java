package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import org.junit.After;
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

    @After
    /**
     *
     */
    public void resetCoffeeMaker() {
        cm = new CoffeeMaker();
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

    /* addInventory / checkInventory Tests */
    @Test
    /**
     * Test adding inventory. This should be fundamentally the same as the test in the Inventory class so we'll combine some cases.
     */
    public void testAddInventoryPosValues() {
        try {
            cm.addInventory("9", "8", "7", "6");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception was thrown!");
        } finally {
            String actualInventory = "Coffee: 24\nMilk: 23\nSugar: 22\nChocolate: 21\n";
            Assert.assertEquals("AddInventory Test - validating Inventory: 1", actualInventory, cm.checkInventory());
        }
    }

    @Test
    /**
     * Test adding inventory. This should be fundamentally the same as the test in the Inventory class so we'll combine
     * some cases. Note that the exception expected here enforce any consistency. It that's a requirement, we're in trouble.
     */
    public void testAddInventoryNegValues() {
        try {
            cm.addInventory("9", "8", "-7", "6");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("AddInventory Test - validating Exception: 1",
                    "Units of sugar must be a positive integer", e.getMessage());
        } finally {
            String actualInventory = "Coffee: 24\nMilk: 23\nSugar: 15\nChocolate: 15\n";
            Assert.assertEquals("AddInventory Test - validating Inventory: 2", actualInventory, cm.checkInventory());
        }
    }

    /* addRecipe and getRecipes Tests */
    @Test
    public void testAddRecipeThreeRecipes() {

    }

    @Test
    public void testAddRecipeDuplicateRecipe() {

    }

    @Test
    public void testAddRecipeFiveRecipes() {

    }

    @Test
    public void testAddRecipeNullRecipe() {

    }

    /* deleteRecipe and getRecipes Tests */
    @Test
    public void testDeleteRecipeThreeRecipes() {

    }

    @Test
    public void testDeleteRecipeDuplicateRecipe() {

    }

    @Test
    public void testDeleteRecipeNoRecipes() {

    }

    @Test
    public void testDeleteRecipeNullRecipe() {

    }

    @Test
    public void testDeleteRecipeNoRecipeToDelete() {

    }

    @Test
    public void testDeleteRecipeNegativeIndex() {

    }

    @Test
    public void testDeleteRecipeOOBIndex() {

    }

    /* editRecipe and getRecipes Tests */
    @Test
    public void testEditRecipeThreeRecipes() {

    }

    @Test
    public void testEditRecipeDuplicateRecipe() {

    }

    @Test
    public void testEditRecipeNoRecipes() {

    }

    @Test
    public void testEditRecipeNullRecipe() {

    }

    @Test
    public void testEditRecipeNoRecipeToDelete() {

    }

    @Test
    public void testEditRecipeNegativeIndex() {

    }

    @Test
    public void testEditRecipeOOBIndex() {

    }
    /* makeCoffee Tests */
    @Test
    public void testMakeCoffeeValidRecipeAndAmount() {

    }

    @Test
    public void testMakeCoffeeValidRecipeAndAmountNoIngredients() {

    }

    @Test
    public void testMakeCoffeeValidRecipeAmountLow() {

    }

    @Test
    public void testMakeCoffeeValidRecipeNegAmount() {

    }

    @Test
    public void testMakeCoffeeOOBRecipeValidAmount() {

    }

    @Test
    public void testMakeCoffeeNullRecipeValidAmount() {

    }

    @Test
    public void testMakeCoffeeNegRecipeValidAmount() {

    }
}
