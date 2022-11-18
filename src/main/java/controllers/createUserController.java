package controllers;

public class createUserController {
    private String username;
    public createUserController() {
    }

    public void createUser(String username) {
        this.username = username;
        System.out.println("User Created: " + username);
    }

    public String getUsername() {
        return username;
    }
}
