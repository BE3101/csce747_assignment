package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import org.junit.Assert;
import org.junit.Test;

public class RecipeBookTest {
    /** Number of recipes in coffee maker */
    private final int NUM_RECIPES = 4;

    @Test
    /**
     * Test the default Recipe Book object. It should have 4 "empty" recipes in it.
     */
    public void testDefaultRecipeBookConstructor() {
        RecipeBook rb = new RecipeBook();
        Assert.assertEquals("RecipeBook - validating Constructor: ", 4, rb.getRecipes().length);
        Recipe [] testArray = rb.getRecipes();
        for (Recipe r: testArray) {
            Assert.assertNull("RecipeBook - validating Constructor: ", r);
        }
    }

    /* Test addRecipe */
    @Test
    /**
     * Test adding a recipe to an "empty" Recipe Book.
     */
    public void testAddRecipeToEmptyRB() {
        RecipeBook rb = new RecipeBook();
        Recipe recipe = new Recipe();
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

        Assert.assertTrue("RecipeBook - validating addRecipe", rb.addRecipe(recipe));
        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating addRecipe", recipe.equals(testArray[0]));
        Assert.assertNull("RecipeBook - validating addRecipe", testArray[1]);
        Assert.assertNull("RecipeBook - validating addRecipe", testArray[2]);
        Assert.assertNull("RecipeBook - validating addRecipe", testArray[3]);
    }

    @Test
    /**
     *  Test adding a recipe to a full Recipe Book. This should fail.
     */
    public void testAddRecipeToFullRB() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        Recipe r3 = new Recipe();
        Recipe r4 = new Recipe();
        Recipe r5 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("3");
            r1.setAmtChocolate("1");
            r1.setAmtMilk("2");
            r1.setAmtSugar("2");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("1");
            r2.setAmtMilk("2");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe", rb.addRecipe(r2));

            r3.setName("Tasty 3");
            r3.setAmtCoffee("3");
            r3.setAmtChocolate("1");
            r3.setAmtMilk("2");
            r3.setAmtSugar("2");
            r3.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe", rb.addRecipe(r3));

            r4.setName("Tasty 4");
            r4.setAmtCoffee("3");
            r4.setAmtChocolate("1");
            r4.setAmtMilk("2");
            r4.setAmtSugar("2");
            r4.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe", rb.addRecipe(r4));

            r5.setName("Tasty 5");
            r5.setAmtCoffee("3");
            r5.setAmtChocolate("1");
            r5.setAmtMilk("2");
            r5.setAmtSugar("2");
            r5.setPrice("5");
            Assert.assertFalse("RecipeBook - validating addRecipe", rb.addRecipe(r1));
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating addRecipe", r1.equals(testArray[0]));
        Assert.assertTrue("RecipeBook - validating addRecipe", r2.equals(testArray[1]));
        Assert.assertTrue("RecipeBook - validating addRecipe", r3.equals(testArray[2]));
        Assert.assertTrue("RecipeBook - validating addRecipe", r4.equals(testArray[3]));
    }

    @Test
    /**
     *  Test adding a duplicate recipe to an "empty" Recipe Book. This should return false.
     */
    public void testAddDuplicateRecipeToRB() {
        RecipeBook rb = new RecipeBook();
        Recipe recipe = new Recipe();
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

        Assert.assertTrue(rb.addRecipe(recipe));
        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating addRecipe", recipe.equals(testArray[0]));
        Assert.assertNull("RecipeBook - validating addRecipe", testArray[1]);
        Assert.assertNull("RecipeBook - validating addRecipe", testArray[2]);
        Assert.assertNull("RecipeBook - validating addRecipe", testArray[3]);

        Assert.assertFalse("RecipeBook - validating addRecipe", rb.addRecipe(recipe));

        testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating addRecipe", recipe.equals(testArray[0]));
        Assert.assertNull("RecipeBook - validating addRecipe", testArray[1]);
        Assert.assertNull("RecipeBook - validating addRecipe", testArray[2]);
        Assert.assertNull("RecipeBook - validating addRecipe", testArray[3]);
    }

    /* Test deleteRecipe */
    @Test
    /**
     * Test deleting the first element from an "empty" Recipe Book. This should return null.
     */
    public void testDeleteRecipeFromEmptyRB() {
        RecipeBook rb = new RecipeBook();
        Assert.assertNull("RecipeBook - validating deleteRecipe", rb.deleteRecipe(0));
    }

    @Test
    /**
     *
     */
    public void testDeleteRecipeFromFullRB() {

    }

    @Test
    /**
     *
     */
    public void testDeleteRecipeDoesNotExist() {

    }

    @Test
    /**
     *
     */
    public void testDeleteRecipeExistsNotFull() {

    }

    @Test
    /**
     * Test deleting the first element from an "empty" Recipe Book. This should return null.
     */
    public void testDeleteAlreadyDeletedRecipeFromEmptyRB() {
        RecipeBook rb = new RecipeBook();
        Assert.assertNull("RecipeBook - validating deleteRecipe", rb.deleteRecipe(0));
    }

    @Test
    /**
     *
     */
    public void testDeleteRecipeOutOfBounds() {

    }

    @Test
    /**
     *
     */
    public void testDeleteFirstRecipe() {

    }

    @Test
    /**
     *
     */
    public void testDeleteNegRecipe() {

    }

    /* Test editRecipe */
    @Test
    /**
     *
     */
    public void testEditRecipeDoesExists() {

    }
    @Test
    /**
     *
     */
    public void testEditRecipeDoesNotExist() {

    }

    @Test
    /**
     *
     */
    public void testEditRecipeOutOfBounds() {

    }

    @Test
    /**
     *
     */
    public void testEditFirstRecipe() {

    }

    @Test
    /**
     *
     */
    public void testEditNegRecipe() {

    }
}
