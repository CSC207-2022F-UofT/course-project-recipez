package entities.ingredient;

/**
 * Class CommonIngredientFactory
 * used to create new instances of object ingredient
 */
public class CommonIngredientFactory implements IngredientFactory {

    /**
     * Creates a CommonIngredient
     *
     * @param name as a String
     * @return Takes in a String name and returns a new CommonIngredientObject
     */
    @Override
    public Ingredient create(String name) {
        return new CommonIngredient(name);
    }
}
