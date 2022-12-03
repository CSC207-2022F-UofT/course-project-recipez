package entities.user;

import entities.fridge.Fridge;

/**
 * Interface user
 * implemented by CommonUser class
 */
// Supress warnings as IntelliJ was not properly suggesting warnings
@SuppressWarnings("ALL")
public interface User {
    String getName();
    Fridge getFridge();
}
