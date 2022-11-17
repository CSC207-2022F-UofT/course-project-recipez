package entities.Ingrediant;

/**
 * Interface Ingredient Factory
 */
public interface IngredientFactory {
    /**
     *
     * @param name
     * method implemented by CommonIngredientFactory object
     */
    Ingrediant create(String name);
}
