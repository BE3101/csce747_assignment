package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class InventoryTest {
    private static final int default_inventory = 15;
    private static Recipe recipe;

    @BeforeClass
    public static void setup() {
        recipe = new Recipe();
        try {
            recipe.setName("Tasty");
            recipe.setAmtCoffee("3");
            recipe.setAmtChocolate("1");
            recipe.setAmtMilk("2");
            recipe.setAmtSugar("2");
            recipe.setPrice("5");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }
    }


    /* Constructor Tests */
    @Test
    /**
     * Test the default Inventory object creation and initialization. Everything should be set to 15.
     */
    public void testDefaultInventoryConstructor() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating Coffee: 1", default_inventory, i.getCoffee() );
        Assert.assertEquals("InventoryTest - validating Milk: 2", default_inventory, i.getMilk() );
        Assert.assertEquals("InventoryTest - validating Sugar: 3", default_inventory, i.getSugar() );
        Assert.assertEquals("InventoryTest - validating Chocolate: 4", default_inventory, i.getChocolate() );
    }

    /* getChocolate Tests */
    @Test
    /**
     * Test retrieving the amount of chocolate in inventory. This is the happy path.
     */
    public void testGetChocolate() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating getChocolate: 1", default_inventory, i.getChocolate() );
    }

    /* setChocolate Tests */
    @Test
    /**
     * Test setting the amount of chocolate in inventory to a positive integer. This is the happy path.
     */
    public void testSetChocolatePosValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setChocolate: 1", default_inventory, i.getChocolate() );
        i.setChocolate(5);
        Assert.assertEquals("InventoryTest - validating setChocolate: 2", 5, i.getChocolate() );
    }

    @Test
    /**
     * Test setting the amount of chocolate in inventory to a negative integer. The value should remain unchanged.
     */
    public void testSetChocolateNegValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setChocolate: 1", default_inventory, i.getChocolate() );
        i.setChocolate(-3);
        Assert.assertEquals("InventoryTest - validating setChocolate: 2", default_inventory, i.getChocolate() );
    }

    @Test
    /**
     * Test setting the amount of chocolate in inventory to zero. The value should be zero.
     */
    public void testSetChocolateZeroValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setChocolate: 1", default_inventory, i.getChocolate() );
        i.setChocolate(0);
        Assert.assertEquals("InventoryTest - validating setChocolate: 2", 0, i.getChocolate() );
    }

    /* addChocolate Tests */
    @Test
    /**
     * Test adding a positive integer to the amount of chocolate in inventory. This is the happy path.
     */
    public void testAddChocolatePosValue() {
        Inventory i = new Inventory();
        try {
            i.addChocolate("7");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception was thrown!");
        } finally {
            Assert.assertEquals("InventoryTest - validating addChocolate: 1", default_inventory + 7, i.getChocolate());
        }
    }

    @Test
    /**
     * Test adding a negative integer to the amount of chocolate in inventory. This should throw an exception.
     */
    public void testAddChocolateNegValue() {
        Inventory i = new Inventory();
        try {
            i.addChocolate("-7");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addChocolate: 1",
                    "Units of chocolate must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test adding a zero to the amount of chocolate in inventory. This should not change the chocolate in inventory.
     */
    public void testAddChocolateZeroValue() {
        Inventory i = new Inventory();
        try {
            i.addChocolate("0");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception was thrown!");
        } finally {
            Assert.assertEquals("InventoryTest - validating addChocolate: 1", default_inventory, i.getChocolate());
        }
    }

    @Test
    /**
     * Test adding a non-integer (float) to the amount of chocolate in inventory. This should throw an exception.
     */
    public void testAddChocolateFloatValue() {
        Inventory i = new Inventory();
        try {
            i.addChocolate("7.3");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addChocolate: 1",
                    "Units of chocolate must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test adding a non-numeric string to the amount of chocolate in inventory. This should throw an exception.
     */
    public void testAddChocolateInvalidValue() {
        Inventory i = new Inventory();
        try {
            i.addChocolate("Interesting");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addChocolate: 1",
                    "Units of chocolate must be a positive integer", e.getMessage());
        }
    }

    /* getCoffee Tests */
    @Test
    /**
     * Test retrieving the amount of coffee in inventory. This is the happy path.
     */
    public void testGetCoffee() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating getCoffee: 1", default_inventory, i.getCoffee() );
    }

    /* setCoffee Tests */
    @Test
    /**
     * Test setting the amount of coffee in inventory to a positive integer. This is the happy path.
     */
    public void testSetCoffeePosValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setCoffee: 1", default_inventory, i.getCoffee() );
        i.setCoffee(5);
        Assert.assertEquals("InventoryTest - validating setCoffee: 2", 5, i.getCoffee() );
    }

    @Test
    /**
     * Test setting the amount of coffee in inventory to a negative integer. The value should remain unchanged.
     */
    public void testSetCoffeeNegValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setCoffee: 1", default_inventory, i.getCoffee() );
        i.setCoffee(-3);
        Assert.assertEquals("InventoryTest - validating setCoffee: 2", default_inventory, i.getCoffee() );
    }

    @Test
    /**
     * Test setting the amount of coffee in inventory to zero. The value should be zero.
     */
    public void testSetCoffeeZeroValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setCoffee: 1", default_inventory, i.getCoffee() );
        i.setCoffee(0);
        Assert.assertEquals("InventoryTest - validating setCoffee: 2", 0, i.getCoffee() );
    }

    /* addCoffee Tests */
    @Test
    /**
     * Test adding a positive integer to the amount of coffee in inventory. This is the happy path.
     */
    public void testAddCoffeePosValue() {
        Inventory i = new Inventory();
        try {
            i.addCoffee("7");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception was thrown!");
        } finally {
            Assert.assertEquals("InventoryTest - validating addCoffee: 1", default_inventory + 7, i.getCoffee());
        }
    }

    @Test
    /**
     * Test adding a negative integer to the amount of coffee in inventory. This should throw an exception.
     */
    public void testAddCoffeeNegValue() {
        Inventory i = new Inventory();
        try {
            i.addCoffee("-7");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addCoffee: 1",
                    "Units of coffee must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test adding a zero to the amount of coffee in inventory. This should not change the coffee in inventory.
     */
    public void testAddCoffeeZeroValue() {
        Inventory i = new Inventory();
        try {
            i.addCoffee("0");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception was thrown!");
        } finally {
            Assert.assertEquals("InventoryTest - validating addCoffee: 1", default_inventory, i.getCoffee());
        }
    }

    @Test
    /**
     * Test adding a non-integer (float) to the amount of coffee in inventory. This should throw an exception.
     */
    public void testAddCoffeeFloatValue() {
        Inventory i = new Inventory();
        try {
            i.addCoffee("7.3");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addCoffee: 1",
                    "Units of coffee must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test adding a non-numeric string to the amount of coffee in inventory. This should throw an exception.
     */
    public void testAddCoffeeInvalidValue() {
        Inventory i = new Inventory();
        try {
            i.addCoffee("Interesting");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addCoffee: 1",
                    "Units of coffee must be a positive integer", e.getMessage());
        }
    }

    /* getMilk Tests */
    @Test
    /**
     * Test retrieving the amount of milk in inventory. This is the happy path.
     */
    public void testGetMilk() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating getMilk: 1", default_inventory, i.getMilk() );
    }

    /* setMilk Tests */
    @Test
    /**
     * Test setting the amount of milk in inventory to a positive integer. This is the happy path.
     */
    public void testSetMilkPosValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setMilk: 1", default_inventory, i.getMilk() );
        i.setMilk(5);
        Assert.assertEquals("InventoryTest - validating setMilk: 2", 5, i.getMilk() );
    }

    @Test
    /**
     * Test setting the amount of milk in inventory to a negative integer. The value should remain unchanged.
     */
    public void testSetMilkNegValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setMilk: 1", default_inventory, i.getMilk() );
        i.setMilk(-3);
        Assert.assertEquals("InventoryTest - validating setMilk: 2", default_inventory, i.getMilk() );
    }

    @Test
    /**
     * Test setting the amount of milk in inventory to zero. The value should be zero.
     */
    public void testSetMilkZeroValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setMilk: 1", default_inventory, i.getMilk() );
        i.setMilk(0);
        Assert.assertEquals("InventoryTest - validating setMilk: 2", 0, i.getMilk() );
    }

    /* addMilk Tests */
    @Test
    /**
     * Test adding a positive integer to the amount of milk in inventory. This is the happy path.
     */
    public void testAddMilkPosValue() {
        Inventory i = new Inventory();
        try {
            i.addMilk("7");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception was thrown!");
        } finally {
            Assert.assertEquals("InventoryTest - validating addMilk: 1", default_inventory + 7, i.getMilk());
        }
    }

    @Test
    /**
     * Test adding a negative integer to the amount of milk in inventory. This should throw an exception.
     */
    public void testAddMilkNegValue() {
        Inventory i = new Inventory();
        try {
            i.addMilk("-7");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addMilk: 1",
                    "Units of milk must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test adding a zero to the amount of milk in inventory. This should not change the milk in inventory.
     */
    public void testAddMilkZeroValue() {
        Inventory i = new Inventory();
        try {
            i.addMilk("0");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception was thrown!");
        } finally {
            Assert.assertEquals("InventoryTest - validating addMilk: 1", default_inventory, i.getMilk());
        }
    }

    @Test
    /**
     * Test adding a non-integer (float) to the amount of milk in inventory. This should throw an exception.
     */
    public void testAddMilkFloatValue() {
        Inventory i = new Inventory();
        try {
            i.addMilk("7.3");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addMilk: 1",
                    "Units of milk must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test adding a non-numeric string to the amount of milk in inventory. This should throw an exception.
     */
    public void testAddMilkInvalidValue() {
        Inventory i = new Inventory();
        try {
            i.addMilk("Interesting");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addMilk: 1",
                    "Units of milk must be a positive integer", e.getMessage());
        }
    }

    /* getSugar Tests */
    @Test
    /**
     * Test retrieving the amount of sugar in inventory. This is the happy path.
     */
    public void testGetSugar() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating getSugar: 1", default_inventory, i.getSugar() );
    }

    /* setSugar Tests */
    @Test
    /**
     * Test setting the amount of sugar in inventory to a positive integer. This is the happy path.
     */
    public void testSetSugarPosValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setSugar: 1", default_inventory, i.getSugar() );
        i.setSugar(5);
        Assert.assertEquals("InventoryTest - validating setSugar: 2", 5, i.getSugar() );
    }

    @Test
    /**
     * Test setting the amount of sugar in inventory to a negative integer. The value should remain unchanged.
     */
    public void testSetSugarNegValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setSugar: 1", default_inventory, i.getSugar() );
        i.setSugar(-3);
        Assert.assertEquals("InventoryTest - validating setSugar: 2", default_inventory, i.getSugar() );
    }

    @Test
    /**
     * Test setting the amount of sugar in inventory to zero. The value should be zero.
     */
    public void testSetSugarZeroValue() {
        Inventory i= new Inventory();

        Assert.assertEquals("InventoryTest - validating setSugar: 1", default_inventory, i.getSugar() );
        i.setSugar(0);
        Assert.assertEquals("InventoryTest - validating setSugar: 2", 0, i.getSugar() );
    }

    /* addSugar Tests */
    @Test
    /**
     * Test adding a positive integer to the amount of sugar in inventory. This is the happy path.
     */
    public void testAddSugarPosValue() {
        Inventory i = new Inventory();
        try {
            i.addSugar("7");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception was thrown!");
        } finally {
            Assert.assertEquals("InventoryTest - validating addSugar: 1", default_inventory + 7, i.getSugar());
        }
    }

    @Test
    /**
     * Test adding a negative integer to the amount of sugar in inventory. This should throw an exception.
     */
    public void testAddSugarNegValue() {
        Inventory i = new Inventory();
        try {
            i.addSugar("-7");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addSugar: 1",
                    "Units of sugar must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test adding a zero to the amount of sugar in inventory. This should not change the sugar in inventory.
     */
    public void testAddSugarZeroValue() {
        Inventory i = new Inventory();
        try {
            i.addSugar("0");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception was thrown!");
        } finally {
            Assert.assertEquals("InventoryTest - validating addSugar: 1", default_inventory, i.getSugar());
        }
    }

    @Test
    /**
     * Test adding a non-integer (float) to the amount of sugar in inventory. This should throw an exception.
     */
    public void testAddSugarFloatValue() {
        Inventory i = new Inventory();
        try {
            i.addSugar("7.3");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addSugar: 1",
                    "Units of sugar must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test adding a non-numeric string to the amount of sugar in inventory. This should throw an exception.
     */
    public void testAddSugarInvalidValue() {
        Inventory i = new Inventory();
        try {
            i.addSugar("Interesting");
            Assert.fail("No exception was thrown!");
        } catch (InventoryException e) {
            Assert.assertEquals("InventoryTest - validating addSugar: 1",
                    "Units of sugar must be a positive integer", e.getMessage());
        }
    }

    /* enoughIngredients Tests */
    @Test
    /**
     * Test if there are enough ingredients to make a recipe when there are.
     */
    public void testEnoughIngredientsTrue() {
        Inventory i = new Inventory();
        Assert.assertTrue("InventoryTest - validating enoughIngredients (true): 1", i.enoughIngredients(recipe));
    }

    @Test
    /**
     * Test if there are enough ingredients to make a recipe when there is not enough Coffee.
     */
    public void testEnoughIngredientsNoCoffee() {
        Inventory i = new Inventory();
        i.setCoffee(0);
        Assert.assertEquals("InventoryTest - validating enoughIngredients (no coffee): 1", 0, i.getCoffee());
        Assert.assertFalse("InventoryTest - validating enoughIngredients (no coffee): 2", i.enoughIngredients(recipe));
    }

    @Test
    /**
     * Test if there are enough ingredients to make a recipe when there is not enough Milk.
     */
    public void testEnoughIngredientsNoMilk() {
        Inventory i = new Inventory();
        i.setMilk(0);
        Assert.assertEquals("InventoryTest - validating enoughIngredients (no milk): 1", 0, i.getMilk());
        Assert.assertFalse("InventoryTest - validating enoughIngredients (no milk): 2", i.enoughIngredients(recipe));
    }

    @Test
    /**
     * Test if there are enough ingredients to make a recipe when there is not enough Sugar.
     */
    public void testEnoughIngredientsNoSugar() {
        Inventory i = new Inventory();
        i.setSugar(0);
        Assert.assertEquals("InventoryTest - validating enoughIngredients (no sugar): 1", 0, i.getSugar());
        Assert.assertFalse("InventoryTest - validating enoughIngredients (no sugar): 2", i.enoughIngredients(recipe));
    }

    @Test
    /**
     * Test if there are enough ingredients to make a recipe when there is not enough Chocolate.
     */
    public void testEnoughIngredientsNoChocolate() {
        Inventory i = new Inventory();
        i.setChocolate(0);
        Assert.assertEquals("InventoryTest - validating enoughIngredients (no chocolate): 1", 0, i.getChocolate());
        Assert.assertFalse("InventoryTest - validating enoughIngredients (no chocolate): 2", i.enoughIngredients(recipe));
    }

    @Test
    /**
     * Test if there are enough ingredients to make a null recipe. Assuming this would generate a false response.
     */
    public void testEnoughIngredientsNullRecipe() {
        Inventory i = new Inventory();
        Assert.assertFalse("InventoryTest - validating enoughIngredients (null recipe): 1", i.enoughIngredients(null));
    }

    /* useIngredients Tests */
    @Test
    /**
     * Test ingredients are subtracted when used.
     */
    public void testUseIngredientsTrue() {
        Inventory i = new Inventory();
        Assert.assertTrue("InventoryTest - validating useIngredients (true): 1", i.useIngredients(recipe));
        Assert.assertEquals("InventoryTest - validating useIngredients (true): 2", default_inventory - recipe.getAmtCoffee(), i.getCoffee());
        Assert.assertEquals("InventoryTest - validating useIngredients (true): 3", default_inventory - recipe.getAmtMilk(), i.getMilk());
        Assert.assertEquals("InventoryTest - validating useIngredients (true): 4", default_inventory - recipe.getAmtSugar(), i.getSugar());
        Assert.assertEquals("InventoryTest - validating useIngredients (true): 5", default_inventory - recipe.getAmtChocolate(), i.getChocolate());
    }

    @Test
    /**
     * Test ingredients are not subtracted when there's not enough coffee for the drink to be made. Ingredient count should be unchanged.
     */
    public void testUseIngredientsNoCoffee() {
        Inventory i = new Inventory();
        i.setCoffee(0);
        Assert.assertFalse("InventoryTest - validating useIngredients (no coffee): 1", i.useIngredients(recipe));
        Assert.assertEquals("InventoryTest - validating useIngredients (no coffee): 2", 0, i.getCoffee());
        Assert.assertEquals("InventoryTest - validating useIngredients (no coffee): 3", default_inventory, i.getMilk());
        Assert.assertEquals("InventoryTest - validating useIngredients (no coffee): 4", default_inventory, i.getSugar());
        Assert.assertEquals("InventoryTest - validating useIngredients (no coffee): 5", default_inventory, i.getChocolate());
    }

    @Test
    /**
     * Test ingredients are not subtracted when there's not enough milk for the drink to be made. Ingredient count should be unchanged.
     */
    public void testUseIngredientsNoMilk() {
        Inventory i = new Inventory();
        i.setMilk(0);
        Assert.assertFalse("InventoryTest - validating useIngredients (no milk): 1", i.useIngredients(recipe));
        Assert.assertEquals("InventoryTest - validating useIngredients (no milk): 2", default_inventory, i.getCoffee());
        Assert.assertEquals("InventoryTest - validating useIngredients (no milk): 3", 0, i.getMilk());
        Assert.assertEquals("InventoryTest - validating useIngredients (no milk): 4", default_inventory, i.getSugar());
        Assert.assertEquals("InventoryTest - validating useIngredients (no milk): 5", default_inventory, i.getChocolate());
    }

    @Test
    /**
     * Test ingredients are not subtracted when there's not enough sugar for the drink to be made. Ingredient count should be unchanged.
     */
    public void testUseIngredientsNoSugar() {
        Inventory i = new Inventory();
        i.setSugar(0);
        Assert.assertFalse("InventoryTest - validating useIngredients (no sugar): 1", i.useIngredients(recipe));
        Assert.assertEquals("InventoryTest - validating useIngredients (no sugar): 2", default_inventory, i.getCoffee());
        Assert.assertEquals("InventoryTest - validating useIngredients (no sugar): 3", default_inventory, i.getMilk());
        Assert.assertEquals("InventoryTest - validating useIngredients (no sugar): 4", 0, i.getSugar());
        Assert.assertEquals("InventoryTest - validating useIngredients (no sugar): 5", default_inventory, i.getChocolate());
    }

    @Test
    /**
     * Test ingredients are not subtracted when there's not enough chocolate for the drink to be made. Ingredient count should be unchanged.
     */
    public void testUseIngredientsNoChocolate() {
        Inventory i = new Inventory();
        i.setChocolate(0);
        Assert.assertFalse("InventoryTest - validating useIngredients (no chocolate): 1", i.useIngredients(recipe));
        Assert.assertEquals("InventoryTest - validating useIngredients (no chocolate): 2", default_inventory, i.getCoffee());
        Assert.assertEquals("InventoryTest - validating useIngredients (no chocolate): 3", default_inventory, i.getMilk());
        Assert.assertEquals("InventoryTest - validating useIngredients (no chocolate): 4", default_inventory, i.getSugar());
        Assert.assertEquals("InventoryTest - validating useIngredients (no chocolate): 5", 0, i.getChocolate());
    }

    @Test
    /**
     * Test ingredients are not subtracted to make a null recipe. Assuming this would generate a false response.
     */
    public void testUseIngredientsNullRecipe() {
        Inventory i = new Inventory();
        Assert.assertFalse("InventoryTest - validating useIngredients (no chocolate): 1", i.useIngredients(null));
        Assert.assertEquals("InventoryTest - validating useIngredients (no chocolate): 2", default_inventory, i.getCoffee());
        Assert.assertEquals("InventoryTest - validating useIngredients (no chocolate): 3", default_inventory, i.getMilk());
        Assert.assertEquals("InventoryTest - validating useIngredients (no chocolate): 4", default_inventory, i.getSugar());
        Assert.assertEquals("InventoryTest - validating useIngredients (no chocolate): 5", default_inventory, i.getChocolate());
    }

    /* toString Tests */
    @Test
    /**
     * Test the toString representation of the Inventory.
     */
    public void testToString() {
        String expectedString = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        Inventory i = new Inventory();
        Assert.assertEquals( "InventoryTest - validating toString: 1", expectedString ,i.toString());
    }
}
