package entities.Fridge;

import entities.Ingrediant.CommonIngrediant;

import java.util.ArrayList;

public class CommonFridge implements Fridge {
    /**
     * Class Fridge:
     * ArrayList<Ingredient> ingredients: list of available ingredients that user added.
     * User can make changes to the ingredients list by adding or removing an ingredient.
     * Existing user can set their Ingredient to their previous ingredients list.
     */
    private ArrayList<CommonIngrediant> ingredients;
    /**
     * Constructor for the Fridge class
     * @ param ingredients: list of ingredients
     * */

    public CommonFridge(ArrayList<CommonIngrediant> ingrediants) {
        this.ingredients = ingrediants;
    }
    public void setIngredients(ArrayList<CommonIngrediant> ingredients) {
        this.ingredients = ingredients;
    }
    /**
     * Add an ingredient to Ingredient
     * */
    public void addIngredient (CommonIngrediant item) {
        ingredients.add(item);
    }
    /**
     * Remove an ingredient from Ingredient
     * */
    public void removeIngredient (CommonIngrediant item) {
        ingredients.remove(item);
    }
    /**
     * Print the list of ingredients in Ingredient
     * */
    @Override
    public String toString() {
        return super.toString();
    }
}
