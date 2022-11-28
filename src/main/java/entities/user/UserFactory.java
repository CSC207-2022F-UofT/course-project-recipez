package entities.user;

import entities.fridge.Fridge;

/**
 * Interface UserFactory
 * Used to create new instances of object user
 */
public interface UserFactory {
    /**
     * Method implemented by CommonUserFactory
     * @param name
     * @param Fridge
     * @return
     */
    User create(String name, Fridge Fridge);
}
