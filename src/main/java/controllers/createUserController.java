package controllers;

import presenters.mockUserRegisterPresenter;

public class createUserController {
    private String username;
    public createUserController(mockUserRegisterPresenter presenter) {
    }

    public String createUser(String username) {
        this.username = username;
        return username;
    }

    public String getUsername() {
        return username;
    }
}
