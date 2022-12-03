package use_cases.searchusecase;

import entities.recipe.RecipeFactory;

/**
 * Output model for search use case
 */
public class SearchResponseModel {
    final RecipeFactory recipeFactory;
    private final String apiOutput;

    public SearchResponseModel(RecipeFactory recipeFactory, String apiOutput) {
        this.recipeFactory = recipeFactory;
        this.apiOutput = apiOutput;
    }

    public String getApiOutput() {
        return apiOutput;
    }
}
