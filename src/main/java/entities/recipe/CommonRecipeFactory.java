package entities.recipe;

import java.io.Serializable;

/**
 * Class CommonRecipeFactory implements the RecipeFactory interface
 */
public class CommonRecipeFactory implements RecipeFactory, Serializable {
    /**
     *
     * @param name : name of the recipe
     * @param url: Object's url
     * @param image: Object's image
     * @return Overrides the method, returns a common recipe object with the input name, ingredients, time, calories
     */
    @Override
    public Recipe create(Object name, Object url, Object image) {
        return new CommonRecipe(name, url, image);
    }
}
