package entities.recipe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Cases for the CommonRecipeFactory class
 */
public class CommonRecipeFactoryTest {
    /**
     * Test for creating a Recipe
     */
    @Test
    public void CreateRecipeTest() {
        CommonRecipeFactory factory = new CommonRecipeFactory();
        Recipe recipe = factory.create("Fried Egg", "url", "image");
        Assertions.assertNotNull(recipe);
    }

    /**
     * Test for creating a Recipe with empty string name
     */
    @Test
    public void CreateEmptyRecipeTest() {
        CommonRecipeFactory factory = new CommonRecipeFactory();
        Recipe recipe = factory.create("", "", "");
        Assertions.assertNotNull(recipe);
    }
}
