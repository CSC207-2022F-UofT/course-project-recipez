package entities;

public class CommonRecipeFactory implements RecipeFactory{
    @Override
    public Recipe create(Object name, Object ingredients, Object time, Object price, Object info) {
        return new CommonRecipe(name, ingredients, time, price, info);
    }
}
