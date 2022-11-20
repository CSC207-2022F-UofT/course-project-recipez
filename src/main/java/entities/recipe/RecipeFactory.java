package entities.recipe;

import entities.recipe.Recipe;

/**
 * Interface with the basic method to create a new Recipe
 */
public interface RecipeFactory {
    Recipe create(Object name, Object url, Object image);
}
