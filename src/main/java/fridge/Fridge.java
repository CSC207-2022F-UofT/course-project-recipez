package fridge;

import java.util.ArrayList;

public class Fridge {
    public ArrayList<Ingredient> ingredients;

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient (Ingredient item) {
        ingredients.add(item);
    }

    public void removeIngredient (Ingredient item) {
        ingredients.remove(item);
    }
}
