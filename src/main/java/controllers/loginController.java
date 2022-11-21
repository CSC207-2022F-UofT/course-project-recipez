package controllers;

import use_cases.login_usecase.loginInputBoundary;
import use_cases.login_usecase.loginRequestModel;
import use_cases.login_usecase.loginResponseModel;

public class loginController {

    public loginInputBoundary loginInteractor;

    public loginController(loginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    public loginResponseModel create(String user) {
        loginRequestModel requestModel = new loginRequestModel(user);
        return loginInteractor.create(requestModel);
    }
}
