package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import org.junit.Assert;
import org.junit.Test;

public class RecipeTest {
    /* Constructor Tests */
    @Test
    /**
     * Test the default Recipe object creation and initialization.
     */
    public void testDefaultRecipeConstructor() {
        Recipe r = new Recipe();

        Assert.assertEquals("RecipeTest - validating Name: ", "", r.getName() );
        Assert.assertEquals("RecipeTest - validating Price: ", 0, r.getPrice() );
        Assert.assertEquals("RecipeTest - validating amtCoffee: ", 0, r.getAmtCoffee() );
        Assert.assertEquals("RecipeTest - validating amtMilk: ", 0, r.getAmtMilk() );
        Assert.assertEquals("RecipeTest - validating amtSugar: ", 0, r.getAmtSugar() );
        Assert.assertEquals("RecipeTest - validating amtChocolate: ", 0, r.getAmtChocolate() );
    }

    /* setAmtChocolate Tests */
    @Test
    /**
     * Test setting the amount of chocolate in a recipe to a positive integer. This is the happy path.
     */
    public void testSetAmtChocolatePositiveAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtChocolate("3");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setAmtChocolate: ", 3, r.getAmtChocolate());
        }
    }

    @Test
    /**
     * Test setting the amount of chocolate in a recipe to zero. This should be acceptable.
     */
    public void testSetAmtChocolateZeroAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtChocolate("5");
            Assert.assertEquals("RecipeTest - validating setAmtChocolate: ", 5, r.getAmtChocolate());
            r.setAmtChocolate("0");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setAmtChocolate: ", 0, r.getAmtChocolate());
        }
    }

    @Test
    /**
     * Test setting the amount of chocolate in a recipe to a negative amount. This should throw an exception.
     */
    public void testSetAmtChocolateNegativeAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtChocolate("-5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of chocolate must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the amount of chocolate in a recipe to a non-integer (float) amount. This should throw an exception.
     */
    public void testSetAmtChocolateFloatAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtChocolate("0.5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of chocolate must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the amount of chocolate in a recipe to a non-numeric string. This should throw an exception.
     */
    public void testSetAmtChocolateInvalidFormatAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtChocolate("yummy");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of chocolate must be a positive integer", e.getMessage());
        }
    }

    /* getAmtChocolate Tests */
    @Test
    /**
     * Test retrieving the amount of chocolate in a recipe. This is the happy path.
     */
    public void testGetAmtChocolate() {
        Recipe r = new Recipe();
        try {
            r.setAmtChocolate("7");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating getAmtChocolate: ", 7, r.getAmtChocolate());
        }
    }

    /* setAmtCoffee Tests */
    @Test
    /**
     * Test setting the amount of coffee in a recipe to a positive integer. This is the happy path.
     */
    public void testSetAmtCoffeePositiveAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtCoffee("3");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setAmtCoffee: ", 3, r.getAmtCoffee());
        }
    }

    @Test
    /**
     * Test setting the amount of coffee in a recipe to zero. This should be acceptable.
     */
    public void testSetAmtCoffeeZeroAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtCoffee("5");
            Assert.assertEquals("RecipeTest - validating setAmtCoffee: ", 5, r.getAmtCoffee());
            r.setAmtCoffee("0");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setAmtCoffee: ", 0, r.getAmtCoffee());
        }
    }

    @Test
    /**
     * Test setting the amount of coffee in a recipe to a negative amount. This should throw an exception.
     */
    public void testSetAmtCoffeeNegativeAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtCoffee("-5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of coffee must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the amount of coffee in a recipe to a non-integer (float) amount. This should throw an exception.
     */
    public void testSetAmtCoffeeFloatAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtCoffee("0.5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of coffee must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the amount of coffee in a recipe to a non-numeric string. This should throw an exception.
     */
    public void testSetAmtCoffeeInvalidFormatAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtCoffee("yummy");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of coffee must be a positive integer", e.getMessage());
        }
    }

    /* getAmtCoffee Tests */
    @Test
    /**
     * Test retrieving the amount of coffee in a recipe. This is the happy path.
     */
    public void testGetAmtCoffee() {
        Recipe r = new Recipe();
        try {
            r.setAmtCoffee("7");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating getAmtCoffee: ", 7, r.getAmtCoffee());
        }
    }

    /* setAmtMilk Tests */
    @Test
    /**
     * Test setting the amount of milk in a recipe to a positive integer. This is the happy path.
     */
    public void testSetAmtMilkPositiveAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtMilk("3");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setAmtMilk: ", 3, r.getAmtMilk());
        }
    }

    @Test
    /**
     * Test setting the amount of milk in a recipe to zero. This should be acceptable.
     */
    public void testSetAmtMilkZeroAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtMilk("5");
            Assert.assertEquals("RecipeTest - validating setAmtMilk: ", 5, r.getAmtMilk());
            r.setAmtMilk("0");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setAmtMilk: ", 0, r.getAmtMilk());
        }
    }

    @Test
    /**
     * Test setting the amount of milk in a recipe to a negative amount. This should throw an exception.
     */
    public void testSetAmtMilkNegativeAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtMilk("-5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of milk must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the amount of milk in a recipe to a non-integer (float) amount. This should throw an exception.
     */
    public void testSetAmtMilkFloatAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtMilk("0.5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of milk must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the amount of milk in a recipe to a non-numeric string. This should throw an exception.
     */
    public void testSetAmtMilkInvalidFormatAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtMilk("yummy");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of milk must be a positive integer", e.getMessage());
        }
    }

    /* getAmtMilk Tests */
    @Test
    /**
     * Test retrieving the amount of milk in a recipe. This is the happy path.
     */
    public void testGetAmtMilk() {
        Recipe r = new Recipe();
        try {
            r.setAmtMilk("7");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating getAmtMilk: ", 7, r.getAmtMilk());
        }
    }

    /* setAmtSugar Tests */
    @Test
    /**
     * Test setting the amount of sugar in a recipe to a positive integer. This is the happy path.
     */
    public void testSetAmtSugarPositiveAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtSugar("3");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setAmtSugar: ", 3, r.getAmtSugar());
        }
    }

    @Test
    /**
     * Test setting the amount of sugar in a recipe to zero. This should be acceptable.
     */
    public void testSetAmtSugarZeroAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtSugar("5");
            Assert.assertEquals("RecipeTest - validating setAmtSugar: ", 5, r.getAmtSugar());
            r.setAmtSugar("0");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setAmtSugar: ", 0, r.getAmtSugar());
        }
    }

    @Test
    /**
     * Test setting the amount of sugar in a recipe to a negative amount. This should throw an exception.
     */
    public void testSetAmtSugarNegativeAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtSugar("-5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of sugar must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the amount of sugar in a recipe to a non-integer (float) amount. This should throw an exception.
     */
    public void testSetAmtSugarFloatAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtSugar("0.5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of sugar must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the amount of sugar in a recipe to a non-numeric string. This should throw an exception.
     */
    public void testSetAmtSugarInvalidFormatAmt() {
        Recipe r = new Recipe();
        try {
            r.setAmtSugar("yummy");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of sugar must be a positive integer", e.getMessage());
        }
    }

    /* getAmtSugar Tests */
    @Test
    /**
     * Test retrieving the amount of sugar in a recipe. This is the happy path.
     */
    public void testGetAmtSugar() {
        Recipe r = new Recipe();
        try {
            r.setAmtSugar("7");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating getAmtSugar: ", 7, r.getAmtSugar());
        }
    }


    /* setName Tests */
    @Test
    /**
     * Test setting the name of a recipe to a string. This is the happy path.
     */
    public void testSetNameNonNull() {
        Recipe r = new Recipe();
        r.setName("Biscuits");
        Assert.assertEquals("RecipeTest - validating setName: ", "Biscuits", r.getName());
        r.setName("Cookies");
        Assert.assertEquals("RecipeTest - validating setName: ", "Cookies", r.getName());
    }

    @Test
    /**
     * Test setting the name of a recipe to null. This should result in no name change occurring.
     */
    public void testSetNameNull() {
        Recipe r = new Recipe();
        r.setName("Cookies");
        Assert.assertEquals("RecipeTest - validating setName: ", "Cookies", r.getName());
        r.setName(null);
        Assert.assertEquals("RecipeTest - validating setName: ", "Cookies", r.getName());
    }

    /* getName Tests*/
    @Test
    /**
     * Test retrieving the name of a recipe. This is the happy path.
     */
    public void testGetName() {
        Recipe r = new Recipe();
        r.setName("Cookies");
        Assert.assertEquals("RecipeTest - validating getName: ", "Cookies", r.getName());
    }

    /* setPrice Tests */
    @Test
    /**
     * Test setting the price of a recipe to a positive integer. This is the happy path.
     */
    public void testSetPricePositiveAmt() {
        Recipe r = new Recipe();
        try {
            r.setPrice("3");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setPrice: ", 3, r.getPrice());
        }
    }

    @Test
    /**
     * Test setting the price of a recipe to zero. This should be acceptable.
     */
    public void testSetPriceZeroAmt() {
        Recipe r = new Recipe();
        try {
            r.setPrice("5");
            Assert.assertEquals("RecipeTest - validating setPrice: ", 5, r.getPrice());
            r.setPrice("0");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating setPrice: ", 0, r.getPrice());
        }
    }

    @Test
    /**
     * Test setting the price of a recipe to a negative amount. This should throw an exception.
     */
    public void testSetPriceNegativeAmt() {
        Recipe r = new Recipe();
        try {
            r.setPrice("-5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Price must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the price of a recipe to a non-integer (float) amount. This should throw an exception.
     */
    public void testSetPriceFloatAmt() {
        Recipe r = new Recipe();
        try {
            r.setPrice("0.5");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Price must be a positive integer", e.getMessage());
        }
    }

    @Test
    /**
     * Test setting the price of a recipe to a non-numeric string. This should throw an exception.
     */
    public void testSetPriceInvalidFormatAmt() {
        Recipe r = new Recipe();
        try {
            r.setPrice("yummy");
        } catch (RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Price must be a positive integer", e.getMessage());
        }
    }

    /* getPrice Tests */
    @Test
    /**
     * Test retrieving the price of a recipe. This is the happy path.
     */
    public void testGetPrice() {
        Recipe r = new Recipe();
        try {
            r.setPrice("7");
        } catch (RecipeException e) {
            System.out.println( e.getMessage() );
        } finally {
            Assert.assertEquals("RecipeTest - validating getPrice: ", 7, r.getPrice());
        }
    }

    /* toString Tests */
    @Test
    /**
     * Test the toString method. The string representation should be the name of the recipe.
     */
    public void testToString() {
        Recipe r = new Recipe();
        r.setName("Candy");
        Assert.assertEquals("RecipeTest - validating toString: ", r.getName(), r.toString());
    }

    /* hashCode Tests */
    @Test
    /**
     * Test the hashCode method. The hashCode is a numeric representation of the object.
     */
    public void testHashCode() {
        Recipe r = new Recipe();
        r.setName("Some Coffee");
        try {
            r.setAmtCoffee("2");
            r.setAmtChocolate("4");
            r.setAmtMilk("3");
            r.setAmtSugar("10");
            r.setPrice("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        } finally {
            Assert.assertEquals("RecipeTest - validating hashCode: ", 1684024471, r.hashCode());
        }
    }

    /* equals Tests */
    @Test
    /**
     * Test the equals method. A recipe is equal to itself.
     */
    public void testEqualsSameObj() {
        Recipe r = new Recipe();
        r.setName("Some Coffee");
        try {
            r.setAmtCoffee("2");
            r.setAmtChocolate("4");
            r.setAmtMilk("3");
            r.setAmtSugar("10");
            r.setPrice("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        } finally {
            Assert.assertTrue("RecipeTest - validating equals", r.equals(r));
        }
    }

    @Test
    /**
     * Test the equals method. A recipe should not be equal to null.
     */
    public void testEqualsNullObj() {
        Recipe r = new Recipe();
        r.setName("Some Coffee");
        try {
            r.setAmtCoffee("2");
            r.setAmtChocolate("4");
            r.setAmtMilk("3");
            r.setAmtSugar("10");
            r.setPrice("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        } finally {
            Assert.assertFalse("RecipeTest - validating equals", r.equals(null));
        }
    }

    @Test
    /**
     * Test the equals method. A recipe should not be equal to a String (or any other class).
     */
    public void testEqualsDiffObjClasses() {
        Recipe r = new Recipe();
        r.setName("Some Coffee");
        try {
            r.setAmtCoffee("2");
            r.setAmtChocolate("4");
            r.setAmtMilk("3");
            r.setAmtSugar("10");
            r.setPrice("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        } finally {
            Assert.assertFalse("RecipeTest - validating equals", r.equals("This should fail!"));
        }
    }

    @Test
    /**
     * Test the equals method. A recipe should not be equal to a recipe with a different name.
     */
    public void testEqualsDiffObjDiffNames() {
        Recipe r1 = new Recipe();
        r1.setName("Some Coffee");
        Recipe r2 = new Recipe();
        r2.setName("Better Coffee");
        try {
            r1.setAmtCoffee("2");
            r1.setAmtChocolate("4");
            r1.setAmtMilk("3");
            r1.setAmtSugar("10");
            r1.setPrice("1");

            r2.setAmtCoffee("2");
            r2.setAmtChocolate("4");
            r2.setAmtMilk("3");
            r2.setAmtSugar("10");
            r2.setPrice("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        } finally {
            Assert.assertFalse("RecipeTest - validating equals", r1.equals(r2));
        }
    }

    @Test
    /**
     * Test the equals method. A recipe should be equal to a different recipe with the same name.
     */
    public void testEqualsDiffObjSameName() {
        Recipe r1 = new Recipe();
        r1.setName("Some Coffee");
        Recipe r2 = new Recipe();
        r2.setName("Some Coffee");
        try {
            r1.setAmtCoffee("2");
            r1.setAmtChocolate("4");
            r1.setAmtMilk("3");
            r1.setAmtSugar("10");
            r1.setPrice("1");

            r2.setAmtCoffee("2");
            r2.setAmtChocolate("4");
            r2.setAmtMilk("3");
            r2.setAmtSugar("3");
            r2.setPrice("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        } finally {
            Assert.assertTrue("RecipeTest - validating equals", r1.equals(r2));
        }
    }
}
