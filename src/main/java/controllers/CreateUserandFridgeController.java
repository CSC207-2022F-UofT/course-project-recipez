package controllers;

import use_cases.create_user_and_fridge.CreateUserAndFridgeInputBoundary;
import use_cases.create_user_and_fridge.CreateUserandFridgeRequestModel;
import use_cases.create_user_and_fridge.CreateUserandFridgeResponseModel;

/**
 * Controller Class
 */
public class CreateUserandFridgeController{

    public CreateUserAndFridgeInputBoundary userNameInteractor;

    /**
     * Constructor for this controller class
     * @param userNameInteractor
     */
    public CreateUserandFridgeController(CreateUserAndFridgeInputBoundary userNameInteractor) {
        this.userNameInteractor = userNameInteractor;
    }

    /**
     * @param user
     * @return calls the create method of the interactor
     */
    public CreateUserandFridgeResponseModel create(String user) {
        CreateUserandFridgeRequestModel requestModel = new CreateUserandFridgeRequestModel(user);
        return userNameInteractor.create(requestModel);
    }

}

