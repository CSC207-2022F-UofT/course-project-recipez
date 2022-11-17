package entities.user;

import entities.Fridge.CommonFridge;

/**
 * Interface UserFactory
 * Used to create new instances of object user
 */
public interface UserFactory {
    /**
     * Method implemented by CommonUserFactory
     * @param name
     * @param commonFridge
     * @return
     */
    User create(String name, CommonFridge commonFridge);
}
