package controllers;

import useCases.CreateUserAndFridge.CreateUserAndFridgeInputBoundry;
import useCases.CreateUserAndFridge.CreateUserandFridgeRequestModel;
import useCases.CreateUserAndFridge.CreateUserandFridgeResponseModel;

public class CreateUserandFridgeController{

    public CreateUserAndFridgeInputBoundry userNameInteractor;

    public CreateUserandFridgeController(CreateUserAndFridgeInputBoundry userNameInteractor) {
        this.userNameInteractor = userNameInteractor;
    }

    public CreateUserandFridgeResponseModel create(String user) {
        CreateUserandFridgeRequestModel requestModel = new CreateUserandFridgeRequestModel(user);
        return userNameInteractor.create(requestModel);
    }

//    public CommonUser create(String user) {
//        CreateUserandFridgeRequestModel requestModel = new CreateUserandFridgeRequestModel(
//                user);
//        return userNameInteractor.create(requestModel);
    }
