package entities.fridge;

import entities.ingredient.Ingredient;

import java.io.Serializable;
import java.util.ArrayList;

public class CommonFridge implements Fridge, Serializable {
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

    public CommonFridge(ArrayList<Ingredient> ingrediants) {
        this.ingredients = ingrediants;
    }

    /**
     *
     * @param ingredients which is an ArrayList<CommonIngredient>
     * list of ingredients is created and initialised inside fridge
     */

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    /**
     *
     * @param item which is a Ingredient
     * Add an ingredient to Ingredient
     */
    public void addIngredient (Ingredient item) {
        ingredients.add(item);
    }
    /**
     *
     * @param item which is a Ingredient
     * Remove an ingredient from Fridge
     */
    public void removeIngredient (Ingredient item) {
        ingredients.remove(item);
    }

    /**
     *
     * @return the first ingredient in the fridge
     * primarily created for testing the usecase
     */
    public Ingredient getIngredientx () {
        return this.ingredients.get(0) ;
    }

    /**
     *
     * @return prints out the ingredients in the fridge
     */
    public String printIngredient () {
        String[] ingredientNamesArray = new String[this.ingredients.size()];
        for (int i = 0; i < this.ingredients.size(); i++) {
            ingredientNamesArray[i] = this.ingredients.get(i).getName();
        };
        return String.join(",", ingredientNamesArray);
    }


    /**
     * Print the list of ingredients in Ingredient
     * */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Used for unit testing purposes
     * the UUID allows for the object to have a unique ID.
     */
    final private java.util.UUID uuid = java.util.UUID.randomUUID();
    /**
     * This method is for unit testing that the deserialized object
     * is the same as the serialized before after storing in the Database.
     *
     * @return the uuid
     */
    public int getUUID() {
        return uuid.hashCode();
    }

}
