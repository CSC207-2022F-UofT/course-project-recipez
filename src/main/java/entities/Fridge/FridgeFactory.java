package entities.Fridge;

import entities.Ingrediant.CommonIngrediant;

import java.util.ArrayList;

public interface FridgeFactory {
    Fridge create(ArrayList<CommonIngrediant> ingredients);
}
