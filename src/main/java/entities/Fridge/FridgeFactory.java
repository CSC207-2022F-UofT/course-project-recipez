package entities.Fridge;

import entities.testIngredient;

import java.util.ArrayList;

public interface FridgeFactory {
    Fridge create(ArrayList<testIngredient> ingredients);
}
