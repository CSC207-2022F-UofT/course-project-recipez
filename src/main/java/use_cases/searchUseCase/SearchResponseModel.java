package use_cases.searchUseCase;

import entities.recipe.Recipe;

import java.util.ArrayList;

/**
 * Output model for search use case
 */
public class SearchResponseModel {
    private final ArrayList<Recipe> recipes;

    public SearchResponseModel(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }
}
