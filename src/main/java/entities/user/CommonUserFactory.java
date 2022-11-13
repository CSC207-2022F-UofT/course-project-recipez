package entities.user;

import entities.Fridge.CommonFridge;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String name, CommonFridge commonFridge) {
        return new CommonUser(name, commonFridge);
    }
}
