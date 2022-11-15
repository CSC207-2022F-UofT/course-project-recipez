package useCases.searchUseCase;

import entities.Recipe;

public class SearchResponseModel {
    private final Recipe[] recipes;

    public SearchResponseModel(Recipe[] recipes) {
        this.recipes = recipes;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }
}
