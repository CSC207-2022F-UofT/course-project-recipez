package entities.user;

import entities.fridge.CommonFridge;

/**
 * Interface user
 * implemented by CommonUser class
 */
public interface User {
    String getName();
    CommonFridge getFridge();
}
