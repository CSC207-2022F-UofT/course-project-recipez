package useCases.CreateUserAndFridge;

import entities.Fridge.Fridge;

public class CreateUserandFridgeRequestModel {
    public String user;
    // fridge will not be here as it is created automatically

    public CreateUserandFridgeRequestModel(String user) {
        this.user = user;
    }

    String getUserName() {
        return user;
    }

    void setUser(String user) {
        this.user = user;
    }
}
