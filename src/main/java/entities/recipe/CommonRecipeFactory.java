package entities.recipe;

/**
 * Class CommonRecipeFactory implements the RecipeFactory interface
 */
public class CommonRecipeFactory implements RecipeFactory {
    /**
     *
     * @param name : name of the recipe
     * @param ingredients: list of ingredients needed for the recipe
     * @param time: time needed for the recipe to be done
     * @param calories: amount of calories provided by the recipe
     * @return Overrides the method, returns a common recipe object with the input name, ingredients, time, calories
     */
    @Override
    public Recipe create(Object name, Object url, Object image) {
        return new CommonRecipe(name, url, image);
    }
}
