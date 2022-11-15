package useCases;

import entities.Ingredient;
import entities.Recipe;

import java.util.ArrayList;

public class recipeBuilder {
    /**
     *recipeBuilder class, not to be instantiated.
     *Handles the creation of recipes using API output.
     *createRecipe takes input from collected API information and uses it to create a new recipe instance.
     */
    public static Recipe createRecipe(String name,
                                      ArrayList<Ingredient> ingredientsList,
                                      int time,
                                      int price,
                                      String info){
        Recipe n = new Recipe(name, ingredientsList, time, price, info);
        return n;
    }
}
