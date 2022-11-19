package useCases;

import entities.Recipe;

/**
 * Interface input boundary for RecipeBuilder Use case
 * Requires implementors to have createRecipe
 */
public interface RecipeBuilderInputBoundary {
    RecipeBuilderResponseModel createRecipe(RecipeBuilder requestModel);
}
