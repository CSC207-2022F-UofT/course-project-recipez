package entities.fridge;

import entities.ingredient.CommonIngredient;

/**
 * interface Fridge
 * ArrayList<Ingredient> ingredients: list of available ingredients that user added.
 * All commonFridge objects implement fridge
 */
public interface Fridge {

    /**
     *
     * @param item which is a CommonIngredient
     * implemented by fridge class
     */
    void  addIngredient (CommonIngredient item);

    /**
     * Used for unit testing purposes
     * the UUID allows for the object to have a unique ID.
     *
     * @return the ID as an int
     */
    int getUUID();
}