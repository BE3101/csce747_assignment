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

    @Test
    /**
     * Add three recipes. Make sure they all are present.
     */
    public void testAddRecipeThreeRecipes() {
        boolean bSuccess1 = cm.addRecipe(r1);
        Assert.assertTrue(bSuccess1);
        boolean bSuccess2 = cm.addRecipe(r2);
        Assert.assertTrue(bSuccess2);
        boolean bSuccess3 = cm.addRecipe(r3);
        Assert.assertTrue(bSuccess3);
    }

    @Test
    /**
     * Test adding duplicate recipes.
     */
    public void testAddRecipeDuplicateRecipe() {
        boolean bSuccess1 = cm.addRecipe(r1);
        Assert.assertTrue(bSuccess1);
        boolean bSuccess2 = cm.addRecipe(r1);
        Assert.assertFalse(bSuccess2);
    }

    @Test
    /**
     * Test adding five recipes. The array only supports four recipes. Make sure the fifth isn't successful
     */
    public void testAddRecipeFiveRecipes() {
        boolean bSuccess1 = cm.addRecipe(r1);
        Assert.assertTrue(bSuccess1);
        boolean bSuccess2 = cm.addRecipe(r2);
        Assert.assertTrue(bSuccess2);
        boolean bSuccess3 = cm.addRecipe(r3);
        Assert.assertTrue(bSuccess3);
        boolean bSuccess4 = cm.addRecipe(r4);
        Assert.assertTrue(bSuccess4);
        boolean bSuccess5 = cm.addRecipe(new Recipe());
        Assert.assertFalse(bSuccess5);
    }

    @Test
    /**
     * Test adding a null recipe. Make sure adding a null recipe fails by throwing an exception
     */
    public void testAddRecipeNullRecipe() {
        try {
            boolean bSuccess = cm.addRecipe(null);
            Assert.fail("No exception was thrown!");
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    /* deleteRecipe and getRecipes Tests */
    @Test
    /**
     * Test deleting three recipes.  Make sure after adding four recipes can delete all but one.
     */
    public void testDeleteRecipeThreeRecipes() {
        boolean bSuccess1 = cm.addRecipe(r1);
        Assert.assertTrue(bSuccess1);
        boolean bSuccess2 = cm.addRecipe(r2);
        Assert.assertTrue(bSuccess2);
        boolean bSuccess3 = cm.addRecipe(r3);
        Assert.assertTrue(bSuccess3);
        boolean bSuccess4 = cm.addRecipe(r4);
        Assert.assertTrue(bSuccess4);

        String result1 = cm.deleteRecipe(1);
        Assert.assertEquals("Mocha", result1);
        String result2 = cm.deleteRecipe(2);
        Assert.assertEquals("Latte", result2);
        String result3 = cm.deleteRecipe(3);
        Assert.assertEquals("Hot Chocolate", result3);
    }

    @Test
    /**
     * Make sure when you delete a recipe that attempting to delete the same recipe again doesn't succeed.
     */
    public void testDeleteRecipeDuplicateRecipe() {
        boolean bSuccess1 = cm.addRecipe(r1);
        Assert.assertTrue(bSuccess1);
        String result1 = cm.deleteRecipe(0);
        Assert.assertEquals("Coffee", result1);
        String result2 = cm.deleteRecipe(0);
        Assert.assertNull(result2);
    }

    @Test
    /**
     * Test deleting recipe where the array is empty. Make sure when attempting to delete a recipe from an empty list that the method returns null.
     */
    public void testDeleteRecipeNoRecipes() {
        String result = cm.deleteRecipe(0);
        Assert.assertNull(result);
    }

    @Test
    /**
     * Test deleting recipe with negative index value. Make sure the method is capable of handling negative index values.
     */
    public void testDeleteRecipeNegativeIndex() {
        String result = cm.deleteRecipe(-1);
        Assert.assertNull(result);
    }

    @Test
    /**
     * Test deleting recipe with index value outside arrayrange. Test deleting recipes out of bounds. They should return null just like deleting a recipe that doesn't exist.
     */
    public void testDeleteRecipeOOBIndex() {
        String result = cm.deleteRecipe(254);
        Assert.assertNull(result);
    }

    @Test
    /**
     * Test editing three recipes. Make sure updated values persist.
     */
    public void testEditRecipeThreeRecipes() {
        boolean bSuccess1 = cm.addRecipe(r1);
        Assert.assertTrue(bSuccess1);
        Recipe recipe1 = cm.getRecipes()[0];
        Assert.assertNotNull(recipe1);
        try
        {
            recipe1.setAmtCoffee("4");
        }
        catch(Exception e) {
            Assert.fail("An exception was thrown!");
        }
        cm.editRecipe(0, recipe1);
        Assert.assertEquals(4, cm.getRecipes()[0].getAmtCoffee());

        boolean bSuccess2 = cm.addRecipe(r2);
        Assert.assertTrue(bSuccess2);
        boolean bSuccess3 = cm.addRecipe(r3);
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

    @Test
    /**
     * Test making coffee happy path, valid recipe and exact amount of money. Method should return the amount of change, 0 in this case.
     */
    public void testMakeCoffeeValidRecipeAndAmount() {
        try
        {
            r1.setAmtCoffee("3");
        }
        catch(Exception e){
            Assert.fail("An exception was thrown!");
        }
        boolean bSuccess = cm.addRecipe(r1);
        Assert.assertTrue(bSuccess);
        int change = cm.makeCoffee(0, 50);
        Assert.assertEquals(0, change);
    }

    @Test
    /**
     * Test making coffee with a valid recipe and not enough money. Method should return the amount the passed in.
     */
    public void testMakeCoffeeNotEnoughMoney() {
        boolean bSuccess = cm.addRecipe(r1);
        Assert.assertTrue(bSuccess);
        int change = cm.makeCoffee(0, 20);
        Assert.assertEquals(20, change);
    }

    @Test
    /**
     * Test making coffee with a valid recipe and amount but not enough ingredients. Method should return the amount the passed in.
     */
    public void testMakeCoffeeValidRecipeAndAmountNoIngredients() {
        try
        {
            r1.setAmtCoffee("100");
        }
        catch(Exception e){
            Assert.fail("An exception was thrown!");
        }
        boolean bSuccess = cm.addRecipe(r1);
        Assert.assertTrue(bSuccess);

        int change1 = cm.makeCoffee(0, 50);
        Assert.assertEquals(50, change1);
    }

    @Test
    /**
     * Test making coffee when the recipe is invalid (null). Method should return the amount the passed in.
     */
    public void testMakeCoffeesInvalidRecipe() {
        cm.getRecipes()[0] = null;
        int change1 = cm.makeCoffee(0, 50);
        Assert.assertEquals(50, change1);
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
