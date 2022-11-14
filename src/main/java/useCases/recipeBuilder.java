package useCases;

import entities.recipe;
import entities.ingredient;

import java.util.ArrayList;

public class recipeBuilder {
    /**
     *recipeBuilder class, not to be instantiated.
     *Handles the creation of recipes using API output.
     *createRecipe takes input from collected API information and uses it to create a new recipe instance.
     */
    public static recipe createRecipe(String name,
                                      ArrayList<ingredient> ingredientsList,
                                      int time,
                                      int price,
                                      String info){
        recipe n = new recipe(name, ingredientsList, time, price, info);
        return n;
    }
}
