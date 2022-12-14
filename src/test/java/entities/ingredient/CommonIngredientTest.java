package entities.ingredient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Cases for the CommonIngredient class
 */
public class CommonIngredientTest {
    /**
     * Test for getting ingredient name
     */
    @Test
    public void getNameTest() {
        Ingredient ing = new CommonIngredient("Salmon");
        Assertions.assertEquals("Salmon", ing.getName());
    }

    /**
     * Test for getting name from an ingredient with empty name
     */
    @Test
    public void getEmptyNameTest() {
        Ingredient ing = new CommonIngredient("");
        Assertions.assertEquals("", ing.getName());
    }
}
