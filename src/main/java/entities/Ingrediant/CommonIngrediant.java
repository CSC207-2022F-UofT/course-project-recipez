package entities.Ingrediant;

public class CommonIngrediant implements Ingrediant {
    /**
     * Class ingredient:
     * String name: name of the ingredient
     */
    private String name;
    /**
     * Constructor for the Ingredient class
     * @ param name: name of the ingredient
     * */

    public CommonIngrediant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
