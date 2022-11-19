package entities.Ingredient;

import java.io.Serializable;

public class CommonIngredient implements Ingredient, Serializable {
    /**
     * Class ingredient:
     * String name: name of the ingredient
     */
    private String name;
    /**
     * Constructor for the Ingredient class
     * @param name: name of the ingredient
     * */
    public CommonIngredient(String name) {
        this.name = name;
    }

    /**
     *
     * @return The name of the ingredient
     */
    public String getName() {
        return this.name;
    }
}
