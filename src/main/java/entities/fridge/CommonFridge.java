package entities.fridge;

import entities.ingredient.CommonIngredient;

import java.io.Serializable;
import java.util.ArrayList;

public class CommonFridge implements Fridge, Serializable {
    /**
     * Class Fridge:
     * ArrayList<Ingredient> ingredients: list of available ingredients that user added.
     * User can make changes to the ingredients list by adding or removing an ingredient.
     * Existing user can set their Ingredient to their previous ingredients list.
     */
    private final ArrayList<CommonIngredient> ingredients;
    /**
     * Constructor for the Fridge class
     * @ param ingredients: list of ingredients
     *
     */
    public CommonFridge(ArrayList<CommonIngredient> ingredients) {
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
     * @return prints out the ingredients in the fridge
     */
    public String printIngredient () {
        String[] ingredientNamesArray = new String[this.ingredients.size()];
        for (int i = 0; i < this.ingredients.size(); i++) {
            ingredientNamesArray[i] = this.ingredients.get(i).getName();
        }
        return String.join(",", ingredientNamesArray);
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
