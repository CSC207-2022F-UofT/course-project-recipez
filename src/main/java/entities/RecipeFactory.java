package entities;

public interface RecipeFactory {
    Recipe create(Object name, Object ingredients, Object time, Object price, Object info);
}
