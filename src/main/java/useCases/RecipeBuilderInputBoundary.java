package useCases;

import entities.Recipe;

/**
 * Interface input boundary for RecipeBuilder Use case
 * Requires implementors to have createRecipe
 */
public interface RecipeBuilderInputBoundary {
    Recipe createRecipe(String[] apiOutput);
}
