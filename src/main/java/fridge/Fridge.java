package fridge;

import java.util.ArrayList;

public class Fridge {
    /**
     * Class Fridge:
     * ArrayList<Ingredient> ingredients: list of available ingredients that user added.
     * User can make changes to the ingredients list by adding or removing an ingredient.
     * Existing user can set their Ingredient to their previous ingredients list.
     */
    private ArrayList<Ingredient> ingredients;

    public void setIngredients(ArrayList<Ingredient> ingredients) {
//      Set Ingredient to a list of existing ingredients
        this.ingredients = ingredients;
    }

    public void addIngredient (Ingredient item) {
//      Add an ingredient to Ingredient
        ingredients.add(item);
    }

    public void removeIngredient (Ingredient item) {
//      Remove an ingredient from Ingredient
        ingredients.remove(item);
    }

    @Override
    public String toString() {
//      Print the list of ingredients in Ingredient
        return super.toString();
    }
}
