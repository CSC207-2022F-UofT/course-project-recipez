package entities.fridge;

import entities.ingredient.Ingredient;

import java.util.ArrayList;

/**
 * interface Fridge
 * ArrayList<Ingredient> ingredients: list of available ingredients that user added.
 * All commonfridge objects implement fridge
 */
public interface Fridge {

    /**
     * Method : set ingredients
     * @param ingredients which is an ArrayList<Ingredient>
     */
    void setIngredients(ArrayList<Ingredient> ingredients);

    /**
     *
     * @param item which is a CommonIngredient
     * implemented by fridge class
     */
    void  addIngredient (Ingredient item);

    /**
     * @param item which is a CommonIngredient
     * implemented by fridge class
     */
    void removeIngredient (Ingredient item) ;

}