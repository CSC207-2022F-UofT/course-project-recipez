package entities;

import java.util.ArrayList;

public class Fridge {
    /**
     * Class Fridge:
     * ArrayList<Ingredient> ingredients: list of available ingredients that user added.
     * User can make changes to the ingredients list by adding or removing an ingredient.
     * Existing user can set their Ingredient to their previous ingredients list.
     */
    private ArrayList<Ingredient> ingredients;
    /**
     * Constructor for the Fridge class
     * @ param ingredients: list of ingredients
     * */
    public Fridge(){
        ingredients = new ArrayList<Ingredient>();
    }
    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    /**
     * Add an ingredient to Ingredient
     * */
    public void addIngredient (Ingredient item) {
        this.ingredients.add(item);
    }
    /**
     * Remove an ingredient from Ingredient
     * */
    public void removeIngredient (Ingredient item) {
        this.ingredients.remove(item);
    }
    /**
     * Print the list of ingredients in Ingredient
     * */
    public ArrayList<Ingredient> getIngredients(){
        return this.ingredients;
    }
}
