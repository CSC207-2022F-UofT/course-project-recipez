package fridge;

import java.io.Serializable;

public class Ingredient implements Serializable {
    /**
     * Class ingredient:
     * String name: name of the ingredient
     */
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Constructor for the Ingredient class
     * @ param name: name of the ingredient
     * */
    @Override
    public String toString() {
        return this.name;
    }
}
