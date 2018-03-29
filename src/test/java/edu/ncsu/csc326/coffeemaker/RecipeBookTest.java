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
        Assert.assertEquals("RecipeBook - validating Constructor: 1", 4, rb.getRecipes().length);
        Recipe [] testArray = rb.getRecipes();
        for (Recipe r: testArray) {
            Assert.assertNull("RecipeBook - validating Constructor: 2", r);
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

        Assert.assertTrue("RecipeBook - validating addRecipe: 1", rb.addRecipe(recipe));
        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating addRecipe: 2", recipe.equals(testArray[0]));
        Assert.assertNull("RecipeBook - validating addRecipe: 3", testArray[1]);
        Assert.assertNull("RecipeBook - validating addRecipe: 4", testArray[2]);
        Assert.assertNull("RecipeBook - validating addRecipe: 5", testArray[3]);
    }

    @Test
    /**
     * Test adding a recipe to a full Recipe Book. This should fail.
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
            Assert.assertTrue("RecipeBook - validating addRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("3");
            r2.setAmtMilk("2");
            r2.setAmtSugar("0");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe: 2", rb.addRecipe(r2));

            r3.setName("Tasty 3");
            r3.setAmtCoffee("5");
            r3.setAmtChocolate("1");
            r3.setAmtMilk("1");
            r3.setAmtSugar("2");
            r3.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe: 3", rb.addRecipe(r3));

            r4.setName("Tasty 4");
            r4.setAmtCoffee("4");
            r4.setAmtChocolate("1");
            r4.setAmtMilk("2");
            r4.setAmtSugar("3");
            r4.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe: 4", rb.addRecipe(r4));

            r5.setName("Tasty 5");
            r5.setAmtCoffee("3");
            r5.setAmtChocolate("1");
            r5.setAmtMilk("1");
            r5.setAmtSugar("2");
            r5.setPrice("5");
            Assert.assertFalse("RecipeBook - validating addRecipe: 5", rb.addRecipe(r5));
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating addRecipe: 6", r1.equals(testArray[0]));
        Assert.assertTrue("RecipeBook - validating addRecipe: 7", r2.equals(testArray[1]));
        Assert.assertTrue("RecipeBook - validating addRecipe: 8", r3.equals(testArray[2]));
        Assert.assertTrue("RecipeBook - validating addRecipe: 9", r4.equals(testArray[3]));
    }

    @Test
    /**
     * Test adding a recipe to a Recipe Book that was full and had a space open. This should succeed.
     */
    public void testAddRecipeToFullRBAfterDelete() {
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
            Assert.assertTrue("RecipeBook - validating addRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("2");
            r2.setAmtMilk("1");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe: 2", rb.addRecipe(r2));

            r3.setName("Tasty 3");
            r3.setAmtCoffee("4");
            r3.setAmtChocolate("1");
            r3.setAmtMilk("2");
            r3.setAmtSugar("3");
            r3.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe: 3", rb.addRecipe(r3));

            r4.setName("Tasty 4");
            r4.setAmtCoffee("5");
            r4.setAmtChocolate("2");
            r4.setAmtMilk("1");
            r4.setAmtSugar("2");
            r4.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe: 4", rb.addRecipe(r4));

            Assert.assertEquals("RecipeBook - validating addRecipe: 5", r2.getName(), rb.deleteRecipe(1));

            r5.setName("Tasty 5");
            r5.setAmtCoffee("4");
            r5.setAmtChocolate("2");
            r5.setAmtMilk("3");
            r5.setAmtSugar("0");
            r5.setPrice("5");
            Assert.assertTrue("RecipeBook - validating addRecipe: 6", rb.addRecipe(r5));
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating addRecipe: 7", r1.equals(testArray[0]));
        Assert.assertTrue("RecipeBook - validating addRecipe: 8", r5.equals(testArray[1]));
        Assert.assertTrue("RecipeBook - validating addRecipe: 9", r3.equals(testArray[2]));
        Assert.assertTrue("RecipeBook - validating addRecipe: 10", r4.equals(testArray[3]));
    }

    @Test
    /**
     * Test adding a duplicate recipe to an "empty" Recipe Book. This should return false.
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
        Assert.assertTrue("RecipeBook - validating addRecipe: 1", recipe.equals(testArray[0]));
        Assert.assertNull("RecipeBook - validating addRecipe: 2", testArray[1]);
        Assert.assertNull("RecipeBook - validating addRecipe: 3", testArray[2]);
        Assert.assertNull("RecipeBook - validating addRecipe: 4", testArray[3]);

        Assert.assertFalse("RecipeBook - validating addRecipe: 5", rb.addRecipe(recipe));

        testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating addRecipe: 6", recipe.equals(testArray[0]));
        Assert.assertNull("RecipeBook - validating addRecipe: 7", testArray[1]);
        Assert.assertNull("RecipeBook - validating addRecipe: 8", testArray[2]);
        Assert.assertNull("RecipeBook - validating addRecipe: 9", testArray[3]);
    }

    /* Test deleteRecipe */
    @Test
    /**
     * Test deleting the first element from an "empty" Recipe Book. This should return null.
     */
    public void testDeleteRecipeFromEmptyRB() {
        RecipeBook rb = new RecipeBook();
        Assert.assertNull("RecipeBook - validating deleteRecipe: 1", rb.deleteRecipe(0));
    }

    @Test
    /**
     * Test deleting a recipe from a full Recipe Book and ensuring an empty/null space exists after the delete.
     */
    public void testDeleteRecipeFromFullRB() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        Recipe r3 = new Recipe();
        Recipe r4 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("3");
            r1.setAmtChocolate("1");
            r1.setAmtMilk("2");
            r1.setAmtSugar("2");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("1");
            r2.setAmtMilk("2");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 2", rb.addRecipe(r2));

            r3.setName("Tasty 3");
            r3.setAmtCoffee("3");
            r3.setAmtChocolate("1");
            r3.setAmtMilk("2");
            r3.setAmtSugar("2");
            r3.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 3", rb.addRecipe(r3));

            r4.setName("Tasty 4");
            r4.setAmtCoffee("3");
            r4.setAmtChocolate("1");
            r4.setAmtMilk("2");
            r4.setAmtSugar("2");
            r4.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 4", rb.addRecipe(r4));
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Assert.assertEquals("RecipeBook - validating deleteRecipe: 5", r2.getName(), rb.deleteRecipe(1));
        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 6", r1.equals(testArray[0]));
        Assert.assertNull("RecipeBook - validating deleteRecipe: 7", testArray[1]);
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 8", r3.equals(testArray[2]));
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 9", r4.equals(testArray[3]));
    }

    @Test
    /**
     * Test deleting the null recipe in the Recipe Book without affecting other recipes.
     */
    public void testDeleteRecipeDoesNotExist() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("4");
            r1.setAmtChocolate("2");
            r1.setAmtMilk("2");
            r1.setAmtSugar("1");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("1");
            r2.setAmtMilk("0");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 2", rb.addRecipe(r2));
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Assert.assertNull("RecipeBook - validating deleteRecipe: 3", rb.deleteRecipe(2));

        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 4", r1.equals(testArray[0]));
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 5", r2.equals(testArray[1]));
        Assert.assertNull("RecipeBook - validating deleteRecipe: 6", testArray[2]);
        Assert.assertNull("RecipeBook - validating deleteRecipe: 7", testArray[3]);
    }

    @Test
    /**
     * Test deleting the a recipe in the Recipe Book without affecting other recipes the the Recipe Book is not full.
     */
    public void testDeleteRecipeExistsNotFull() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("4");
            r1.setAmtChocolate("2");
            r1.setAmtMilk("2");
            r1.setAmtSugar("1");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("1");
            r2.setAmtMilk("0");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 2", rb.addRecipe(r2));
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Assert.assertEquals("RecipeBook - validating deleteRecipe: 3", r2.getName(), rb.deleteRecipe(1));

        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 4", r1.equals(testArray[0]));
        Assert.assertNull("RecipeBook - validating deleteRecipe: 5", testArray[1]);
        Assert.assertNull("RecipeBook - validating deleteRecipe: 6", testArray[2]);
        Assert.assertNull("RecipeBook - validating deleteRecipe: 7", testArray[3]);
    }

    @Test
    /**
     * Test deleting the a recipe from a Recipe Book after it's already been deleted. This should return null.
     */
    public void testDeleteAlreadyDeletedRecipeFromEmptyRB() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        Recipe r3 = new Recipe();
        Recipe r4 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("3");
            r1.setAmtChocolate("1");
            r1.setAmtMilk("2");
            r1.setAmtSugar("2");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("1");
            r2.setAmtMilk("2");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 2", rb.addRecipe(r2));

            r3.setName("Tasty 3");
            r3.setAmtCoffee("3");
            r3.setAmtChocolate("1");
            r3.setAmtMilk("2");
            r3.setAmtSugar("2");
            r3.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 3", rb.addRecipe(r3));

            r4.setName("Tasty 4");
            r4.setAmtCoffee("3");
            r4.setAmtChocolate("1");
            r4.setAmtMilk("2");
            r4.setAmtSugar("2");
            r4.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 4", rb.addRecipe(r4));
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Assert.assertEquals("RecipeBook - validating deleteRecipe: 5", r2.getName(), rb.deleteRecipe(1));
        Assert.assertNull("RecipeBook - validating deleteRecipe: 5", rb.deleteRecipe(1));
        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 6", r1.equals(testArray[0]));
        Assert.assertNull("RecipeBook - validating deleteRecipe: 7", testArray[1]);
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 8", r3.equals(testArray[2]));
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 9", r4.equals(testArray[3]));
    }

    @Test
    /**
     * Test deleting items out of bounds (>3). They should return null just like deleting a recipe that doesn't exist.
     */
    public void testDeleteRecipeOutOfBounds() {
        RecipeBook rb = new RecipeBook();
        Assert.assertNull("RecipeBook - validating deleteRecipe: 1", rb.deleteRecipe(5));
    }

    @Test
    /**
     * Test deleting the first recipe in the Recipe Book without affecting other recipes.
     */
    public void testDeleteFirstRecipe() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("4");
            r1.setAmtChocolate("2");
            r1.setAmtMilk("2");
            r1.setAmtSugar("1");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("1");
            r2.setAmtMilk("0");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating deleteRecipe: 2", rb.addRecipe(r2));
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Assert.assertEquals("RecipeBook - validating deleteRecipe: 3", r1.getName(), rb.deleteRecipe(0));

        Recipe [] testArray = rb.getRecipes();
        Assert.assertNull("RecipeBook - validating deleteRecipe: 4", testArray[0]);
        Assert.assertTrue("RecipeBook - validating deleteRecipe: 5", r2.equals(testArray[1]));
        Assert.assertNull("RecipeBook - validating deleteRecipe: 6", testArray[2]);
        Assert.assertNull("RecipeBook - validating deleteRecipe: 7", testArray[3]);
    }

    @Test
    /**
     * Test deleting items out of bounds (<0). They should return null just like deleting a recipe that doesn't exist.
     */
    public void testDeleteNegRecipe() {
        RecipeBook rb = new RecipeBook();
        Assert.assertNull("RecipeBook - validating deleteRecipe: 1", rb.deleteRecipe(-1));
    }

    /* Test editRecipe */
    @Test
    /**
     * Test editing a recipe that exists. This is the happy path.
     */
    public void testEditRecipeDoesExist() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        Recipe r3 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("4");
            r1.setAmtChocolate("2");
            r1.setAmtMilk("3");
            r1.setAmtSugar("1");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating editRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("2");
            r2.setAmtMilk("0");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating editRecipe: 2", rb.addRecipe(r2));

            r3.setName("Tasty 3");
            r3.setAmtCoffee("4");
            r3.setAmtChocolate("1");
            r3.setAmtMilk("1");
            r3.setAmtSugar("1");
            r3.setPrice("2");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }


        Assert.assertEquals("RecipeBook - validating editRecipe: 3", r2.getName(), rb.editRecipe(1, r3));

        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating editRecipe: 4", r1.equals(testArray[0]));
        Assert.assertTrue("RecipeBook - validating editRecipe: 5", r3.equals(testArray[1]));
        Assert.assertNull("RecipeBook - validating editRecipe: 6", testArray[2]);
        Assert.assertNull("RecipeBook - validating editRecipe: 7", testArray[3]);

        Assert.assertEquals("RecipeBook - validating editRecipe: 8", "Tasty 3", testArray[1].getName());
        Assert.assertEquals("RecipeBook - validating editRecipe: 9", 4, testArray[1].getAmtCoffee());
        Assert.assertEquals("RecipeBook - validating editRecipe: 10", 1, testArray[1].getAmtChocolate());
        Assert.assertEquals("RecipeBook - validating editRecipe: 11", 1, testArray[1].getAmtMilk());
        Assert.assertEquals("RecipeBook - validating editRecipe: 12", 1, testArray[1].getAmtSugar());
        Assert.assertEquals("RecipeBook - validating editRecipe: 13", 2, testArray[1].getPrice());
    }
    @Test
    /**
     * Test editing a recipe that hasn't been added yet (i.e. a null recipe). This should return null and not add the recipe.
     */
    public void testEditRecipeDoesNotExist() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        Recipe r3 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("4");
            r1.setAmtChocolate("2");
            r1.setAmtMilk("3");
            r1.setAmtSugar("1");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating editRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("2");
            r2.setAmtMilk("0");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating editRecipe: 2", rb.addRecipe(r2));

            r3.setName("Tasty 3");
            r3.setAmtCoffee("4");
            r3.setAmtChocolate("1");
            r3.setAmtMilk("1");
            r3.setAmtSugar("1");
            r3.setPrice("2");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }


        Assert.assertNull("RecipeBook - validating editRecipe: 3", rb.editRecipe(2, r3));

        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating editRecipe: 4", r1.equals(testArray[0]));
        Assert.assertTrue("RecipeBook - validating editRecipe: 5", r2.equals(testArray[1]));
        Assert.assertNull("RecipeBook - validating editRecipe: 6", testArray[2]);
        Assert.assertNull("RecipeBook - validating editRecipe: 7", testArray[3]);
    }

    @Test
    /**
     * Tests trying to edit a recipe with an index >3 (out of bounds). This should return null.
     */
    public void testEditRecipeOutOfBounds() {
        RecipeBook rb = new RecipeBook();
        Recipe r = new Recipe();


        Assert.assertNull("RecipeBook - validating editRecipe: 1", rb.editRecipe(4, r));
    }

    @Test
    /**
     * Tests trying to edit a recipe with an index <0 (out of bounds). This should return null.
     */
    public void testEditRecipeNegIndex() {
        RecipeBook rb = new RecipeBook();
        Recipe r = new Recipe();


        Assert.assertNull("RecipeBook - validating editRecipe: 1", rb.editRecipe(-1, r));
    }

    @Test
    /**
     * Test to see if entering a null recipe causes problems. An edited recipe should not be able to be null.
     */
    public void testEditRecipeNullNewRecipe() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("4");
            r1.setAmtChocolate("2");
            r1.setAmtMilk("3");
            r1.setAmtSugar("1");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating editRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("2");
            r2.setAmtMilk("0");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating editRecipe: 2", rb.addRecipe(r2));
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Assert.assertNull("RecipeBook - validating editRecipe: 3", rb.editRecipe(1, null));

        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating editRecipe: 4", r1.equals(testArray[0]));
        Assert.assertTrue("RecipeBook - validating editRecipe: 5", r2.equals(testArray[1]));
        Assert.assertNull("RecipeBook - validating editRecipe: 6", testArray[2]);
        Assert.assertNull("RecipeBook - validating editRecipe: 7", testArray[3]);
    }

    @Test
    /**
     * Test editing the first recipe in the Recipe Book without affecting other recipes.
     */
    public void testEditFirstRecipe() {
        RecipeBook rb = new RecipeBook();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        Recipe r3 = new Recipe();

        try {
            r1.setName("Tasty 1");
            r1.setAmtCoffee("4");
            r1.setAmtChocolate("2");
            r1.setAmtMilk("3");
            r1.setAmtSugar("1");
            r1.setPrice("5");
            Assert.assertTrue("RecipeBook - validating editRecipe: 1", rb.addRecipe(r1));

            r2.setName("Tasty 2");
            r2.setAmtCoffee("3");
            r2.setAmtChocolate("2");
            r2.setAmtMilk("0");
            r2.setAmtSugar("2");
            r2.setPrice("5");
            Assert.assertTrue("RecipeBook - validating editRecipe: 2", rb.addRecipe(r2));

            r3.setName("Tasty 3");
            r3.setAmtCoffee("4");
            r3.setAmtChocolate("1");
            r3.setAmtMilk("1");
            r3.setAmtSugar("1");
            r3.setPrice("2");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
            Assert.fail("Exception thrown initializing recipe!");
        }

        Assert.assertEquals("RecipeBook - validating editRecipe: 3", r1.getName(), rb.editRecipe(0, r3));

        Recipe [] testArray = rb.getRecipes();
        Assert.assertTrue("RecipeBook - validating editRecipe: 4", r3.equals(testArray[0]));
        Assert.assertTrue("RecipeBook - validating editRecipe: 5", r2.equals(testArray[1]));
        Assert.assertNull("RecipeBook - validating editRecipe: 6", testArray[2]);
        Assert.assertNull("RecipeBook - validating editRecipe: 7", testArray[3]);
    }
}
