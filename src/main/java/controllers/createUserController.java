package controllers;

public class createUserController {
    private String username;
    public createUserController() {
    }

    public String createUser(String username) {
        this.username = username;
        return username;
    }

    public String getUsername() {
        return username;
    }
}
