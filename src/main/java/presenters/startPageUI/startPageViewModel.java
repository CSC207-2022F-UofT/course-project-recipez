package presenters.startPageUI;

import controllers.createUserController;

import javax.swing.*;

public class startPageViewModel implements startPageViewModelInterface {

    public String pageState;

    private JTextField username;

    private createUserController registerController;

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
}
