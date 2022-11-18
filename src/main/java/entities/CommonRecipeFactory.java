package entities;

public class CommonRecipeFactory implements RecipeFactory{
    @Override
    public Recipe create(Object name, Object ingredients, Object time, Object calories) {
        return new CommonRecipe(name, ingredients, time, calories);
    }
}
