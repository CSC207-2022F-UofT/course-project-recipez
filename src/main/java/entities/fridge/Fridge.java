package entities.fridge;

import entities.ingredient.CommonIngredient;

import java.util.ArrayList;

/**
 * interface Fridge
 * ArrayList<Ingredient> ingredients: list of available ingredients that user added.
 * All commonFridge objects implement fridge
 */
public interface Fridge {

    /**
     * Method : set ingredients
     * @param ingredients which is an ArrayList<CommonIngredient>
     */
    void setIngredients(ArrayList<CommonIngredient> ingredients);

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