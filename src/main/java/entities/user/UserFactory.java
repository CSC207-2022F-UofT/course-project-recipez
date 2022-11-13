package entities.user;

import entities.Fridge.CommonFridge;

public interface UserFactory {
    User create(String name, CommonFridge commonFridge);
}
