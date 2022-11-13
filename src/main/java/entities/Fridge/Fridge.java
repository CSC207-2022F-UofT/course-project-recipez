package entities.Fridge;

import entities.Ingrediant.CommonIngrediant;

import java.util.ArrayList;

public interface Fridge {
    void setIngredients(ArrayList<CommonIngrediant> ingredients);

    void  addIngredient (CommonIngrediant item);

    void removeIngredient (CommonIngrediant item) ;

}