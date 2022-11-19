package entities.Fridge;

import entities.Ingredient.CommonIngredient;

import java.util.ArrayList;

/**
 * Interface FridgeFactory
 * Creates a fridge object for every new user
 */
public interface FridgeFactory {
    Fridge create(ArrayList<CommonIngredient> ingredients);
}
