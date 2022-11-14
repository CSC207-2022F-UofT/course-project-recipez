package fridge;

import java.io.Serializable;
import java.util.ArrayList;

public class Fridge implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Class Fridge:
     * ArrayList<Ingredient> ingredients: list of available ingredients that user added.
     * User can make changes to the ingredients list by adding or removing an ingredient.
     * Existing user can set their Ingredient to their previous ingredients list.
     */
    private ArrayList<Ingredient> ingredients;

    /**
     * docString
     * */


    public Fridge() {
        this.ingredients = new ArrayList<>();
    }
    /**
     * Constructor for the Fridge class
     * @ param ingredients: list of ingredients
     * */

    //This is completely wrong.
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
    public void removeIngredient(Ingredient item) {
        ingredients.remove(item);
    }


    public String[] allIngredientValues() {
        String[] str = new String[this.ingredients.size()];
        for (int i = 0; i < this.ingredients.size(); i++) {
            str[i] = this.ingredients.get(i).toString();
        }
        return str;
    }

    /**
     * Print the list of ingredients in Ingredient
     * */

    @Override
    public String toString() {
        return super.toString();
    }
}
