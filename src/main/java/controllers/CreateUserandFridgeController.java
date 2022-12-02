package controllers;

import use_cases.create_user_and_fridge.CreateUserAndFridgeInputBoundary;
import use_cases.create_user_and_fridge.CreateUserAndFridgeRequestModel;
import use_cases.create_user_and_fridge.CreateUserAndFridgeResponseModel;

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
    public CreateUserAndFridgeResponseModel create(String user) {
        CreateUserAndFridgeRequestModel requestModel = new CreateUserAndFridgeRequestModel(user);
        return userNameInteractor.create(requestModel);
    }

}

