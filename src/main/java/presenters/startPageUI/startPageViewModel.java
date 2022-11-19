package presenters.startPageUI;

import controllers.createUserController;

import javax.swing.*;

public class startPageViewModel implements startPageViewModelInterface {

    public String pageState;
    private final createUserController registerController;

    private String create_register_response;

    private String attempt_login_response;

    public startPageViewModel(createUserController controller) {
        this.registerController = controller;
        this.pageState = "main";
    }

    public void enterUserRegistrationPage() {
        this.pageState = "register";
    }

    @Override
    public void enterLoginPage() {
        this.pageState = "login";
    }

    @Override
    public void enterMainPage() {
        this.pageState = "main";
    }

    public String registerUser(String username) {
        assert this.pageState.equals("register");
        return registerController.createUser(username);
    }

    public String attemptLogin(String username) {
        assert this.pageState.equals("login");
        return registerController.createUser(username);
    }

    public void registration_success(String response) {
        this.create_register_response = response;
    }

    public void registration_failure(String err_message) {
        this.create_register_response = err_message;
    }

    public void login_success(String response) {
        this.attempt_login_response = response;
    }

    public void login_failure(String err_message) {
        this.attempt_login_response = err_message;
    }
}
