package entities.user;

import entities.fridge.Fridge;

/**
 * Interface user
 * implemented by CommonUser class
 */
public interface User {
    boolean ingredientIsValid();
    String getName();
    Fridge getFridge();
}
