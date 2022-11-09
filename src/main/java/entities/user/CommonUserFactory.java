package entities.user;

import entities.Fridge;
import entities.FridgeInterface;

public class testUserFactory implements UserFactory {
    @Override
    public UserInterface create(String name, FridgeInterface fridge) {
        return new CommonUser(name, (Fridge) fridge);
    }
}
