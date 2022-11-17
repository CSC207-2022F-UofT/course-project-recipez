package entities.Fridge;

import entities.Ingrediant.CommonIngredient;

import java.util.ArrayList;

/**
 * Class CommonFridgeFactory implements the FridgeFactory interface
 */
public class CommonFridgeFactory implements FridgeFactory {
    /**
     *
     * @param ingredients : a list of common ingredients
     * @return Overrides the method, takes in a list of common ingredients and returns a common
     * fridge object for the user with ingredients inside
     */
    @Override
    public Fridge create(ArrayList<CommonIngredient> ingredients) {
        return new CommonFridge(ingredients);
    }
}