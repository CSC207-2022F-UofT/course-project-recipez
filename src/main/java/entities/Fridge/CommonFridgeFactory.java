package entities.Fridge;

import entities.Ingrediant.CommonIngrediant;

import java.util.ArrayList;

public class CommonFridgeFactory implements FridgeFactory {

    @Override
    public Fridge create(ArrayList<CommonIngrediant> ingredients) {
        return new CommonFridge(ingredients);
    }
}