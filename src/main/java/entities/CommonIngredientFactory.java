package entities;
/**
 * Creates Ingredient objects for the Fridge
 */

public class CommonIngredientFactory implements IngredientFactory{
    @Override
    public Ingredient create(String name) {
        Ingredient newIngredient = new CommonIngredient(name);
        return newIngredient;
    }
}
