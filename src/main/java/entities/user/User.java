package entities.user;

import entities.fridge.CommonFridge;

/**
 * Interface user
 * implemented by CommonUser class
 */
// Supress warnings as IntelliJ was not properly suggesting warnings
@SuppressWarnings("ALL")
public interface User {
    String getName();
    CommonFridge getFridge();
}
