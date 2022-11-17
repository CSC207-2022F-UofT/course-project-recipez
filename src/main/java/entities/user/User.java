package entities.user;

import entities.Fridge.CommonFridge;

/**
 * Interface user
 * implemented by CommonUser class
 */
public interface User {
    boolean ingredientIsValid();
    String getName();
    CommonFridge getFridge();
}
