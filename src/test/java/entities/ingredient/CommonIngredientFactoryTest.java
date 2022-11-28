package entities.ingredient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Cases for the CommonIngredientFactory class
 */
public class CommonIngredientFactoryTest {
    /**
     * Test for creating one CommonIngredient
     */
    @Test
    public void CreateIngredientTest() {
        CommonIngredientFactory factory = new CommonIngredientFactory();
        Ingredient ing = factory.create("Beef");
        Assertions.assertNotNull(ing);
    }
}
