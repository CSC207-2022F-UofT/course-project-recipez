package entities.user;

import entities.fridge.CommonFridge;

/**
 * Interface UserFactory
 * Used to create new instances of object user
 */
public interface UserFactory {
    /**
     * Method implemented by CommonUserFactory
     * @param name as a string
     * @param commonFridge is the commonFridge
     * @return the User
     */
    User create(String name, CommonFridge commonFridge);
}
