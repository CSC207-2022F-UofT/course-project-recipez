package entities.Fridge;

import entities.testIngredient;

import java.util.ArrayList;

public interface Fridge {
    void setIngredients(ArrayList<testIngredient> ingredients);

    void  addIngredient (testIngredient item);

    void removeIngredient (testIngredient item) ;

}