package entities;

/**
 * Interface with the basic method to create a new Recipe
 */
public interface RecipeFactory {
    Recipe create(Object name, Object ingredients, Object time, Object calories);
}
