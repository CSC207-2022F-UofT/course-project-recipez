package entities.Fridge;

import entities.Ingrediant.CommonIngredient;
import entities.Ingrediant.Ingrediant;

import java.util.ArrayList;

public class CommonFridge implements Fridge {
    /**
     * Class Fridge:
     * ArrayList<Ingredient> ingredients: list of available ingredients that user added.
     * User can make changes to the ingredients list by adding or removing an ingredient.
     * Existing user can set their Ingredient to their previous ingredients list.
     */
    private ArrayList<CommonIngredient> ingredients;
    /**
     * Constructor for the Fridge class
     * @ param ingredients: list of ingredients
     * */

    public CommonFridge(ArrayList<CommonIngredient> ingrediants) {
        this.ingredients = ingrediants;
    }

    /**
     *
     * @param ingredients which is an ArrayList<CommonIngredient>
     * list of ingredients is created and initialised inside fridge
     */

    public void setIngredients(ArrayList<CommonIngredient> ingredients) {
        this.ingredients = ingredients;
    }
    /**
     *
     * @param item which is a CommonIngredient
     * Add an ingredient to Ingredient
     */
    public void addIngredient (CommonIngredient item) {
        ingredients.add(item);
    }
    /**
     *
     * @param item which is a CommonIngredient
     * Remove an ingredient from Fridge
     */
    public void removeIngredient (CommonIngredient item) {
        ingredients.remove(item);
    }

    /**
     *
     * @return the first ingredient in the fridge
     * primarily created for testing the usecase
     */
    public Ingrediant getIngrediantx () {
        return this.ingredients.get(0) ;
    }

    /**
     *
     * @return prints out the ingredients in the fridge
     */
    public String printIngrediant () {
        return this.ingredients.toString() ;
    }


    /**
     * Print the list of ingredients in Ingredient
     * */
    @Override
    public String toString() {
        return super.toString();
    }
}
