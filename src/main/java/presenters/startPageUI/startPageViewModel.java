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
        assert this.pageState.equals("main");
        this.pageState = "register";
        System.out.println(this.pageState);
    }

    @Override
    public void enterLoginPage() {
        assert this.pageState.equals("main");
        this.pageState = "login";
        System.out.println(this.pageState);
    }

    @Override
    public void enterMainPage() {
        this.pageState = "main";
    }
}
