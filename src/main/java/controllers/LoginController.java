package controllers;

import use_cases.login_usecase.LoginInputBoundary;
import use_cases.login_usecase.LoginRequestModel;

public class LoginController {

    public final LoginInputBoundary loginInteractor;

    public LoginController(LoginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    public void create(String user) {
        LoginRequestModel requestModel = new LoginRequestModel(user);
        loginInteractor.create(requestModel);
    }
}
