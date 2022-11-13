package entities.Ingrediant;

public class CommonIngrediantFactory implements IngrediantFactory {
    @Override
    public Ingrediant create(String name) {
        return new CommonIngrediant(name);
    }
}
