package controllers;

import use_cases.login_usecase.loginInputBoundary;
import use_cases.login_usecase.loginRequestModel;

public class loginController {

    public final loginInputBoundary loginInteractor;

    public loginController(loginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    public void create(String user) {
        loginRequestModel requestModel = new loginRequestModel(user);
        loginInteractor.create(requestModel);
    }
}
