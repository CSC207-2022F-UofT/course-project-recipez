package entities.user;

import entities.fridge.CommonFridge;
import entities.ingredient.CommonIngredient;
import entities.ingredient.CommonIngredientFactory;
import entities.ingredient.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CommonUserFactoryTest {
    /**
     * Test for create CommonUser function.
     */
    @Test
    void test_create(){
        CommonIngredientFactory ing_factory = new CommonIngredientFactory();
        Ingredient chicken = ing_factory.create("chicken");
        ArrayList<CommonIngredient> ing = new ArrayList<>();
        ing.add((CommonIngredient) chicken);
        CommonFridge fridge = new CommonFridge(ing);
        CommonUserFactory user_factory = new CommonUserFactory();
        User user = user_factory.create("D.Jr", fridge);
        Assertions.assertNotNull(user);
    }
}
