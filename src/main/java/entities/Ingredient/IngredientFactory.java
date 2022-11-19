package entities.Ingredient;

/**
 * Interface Ingredient Factory
 */
public interface IngredientFactory {
    /**
     *
     * @param name
     * method implemented by CommonIngredientFactory object
     */
    Ingredient create(String name);
}
