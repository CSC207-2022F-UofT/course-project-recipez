package entities.user;

import entities.fridge.CommonFridge;

/**
 * Class Common User Factory
 */
public class CommonUserFactory implements UserFactory {
    /**
     *
     * @param name : The name of the user
     * @param commonFridge : A fridge for the user
     * @return Create a new object of type CommonUser with parameters name and commonFridge
     */
    @Override
    public User create(String name, CommonFridge commonFridge) {
        return new CommonUser(name, commonFridge);
    }
}
