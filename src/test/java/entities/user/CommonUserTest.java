package entities.user;

import entities.fridge.CommonFridge;
import entities.ingredient.CommonIngredient;
import entities.ingredient.CommonIngredientFactory;
import entities.ingredient.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Test cases for CommonUser Class
 */

public class CommonUserTest {

    /**
     *Test for get name function
     */
    @Test
    void test_get_name(){
        CommonIngredientFactory factory = new CommonIngredientFactory();
        Ingredient chicken = factory.create("chicken");
        ArrayList<CommonIngredient> ing = new ArrayList<>();
        ing.add((CommonIngredient) chicken);
        CommonFridge fridge = new CommonFridge(ing);
        CommonUser user = new CommonUser("D.Jr", fridge);
        Assertions.assertEquals("D.Jr", user.getName());
    }

    /**
     * Test for get fridge function
     */
    @Test
    void test_get_fridge(){
        CommonIngredientFactory factory = new CommonIngredientFactory();
        Ingredient chicken = factory.create("chicken");
        ArrayList<CommonIngredient> ing = new ArrayList<>();
        ing.add((CommonIngredient) chicken);
        CommonFridge fridge = new CommonFridge(ing);
        CommonUser user = new CommonUser("D.Jr", fridge);
        Assertions.assertEquals(fridge, user.getFridge());
    }
}
