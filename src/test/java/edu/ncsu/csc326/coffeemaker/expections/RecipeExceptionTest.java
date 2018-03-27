package edu.ncsu.csc326.coffeemaker.expections;

import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import org.junit.Assert;
import org.junit.Test;

public class RecipeExceptionTest {
    @Test
    public void testRecipeException() {
        try {
            Recipe r = new Recipe();
            r.setAmtChocolate("-5");
        } catch(RecipeException e) {
            Assert.assertEquals( "Validating Recipe Exception: ",
                    "Units of chocolate must be a positive integer", e.getMessage());
        }
    }
}
