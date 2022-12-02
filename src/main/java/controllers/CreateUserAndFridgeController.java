package controllers;

import use_cases.create_user_and_fridge.CreateUserAndFridgeInputBoundary;
import use_cases.create_user_and_fridge.CreateUserAndFridgeRequestModel;
import use_cases.create_user_and_fridge.CreateUserAndFridgeResponseModel;

/**
 * Controller Class
 */
public class CreateUserAndFridgeController {

    public CreateUserAndFridgeInputBoundary userNameInteractor;

    /**
     * Constructor for this controller class
     *
     * @param userNameInteractor CreateUserAndFridgeInputBoundary interactor
     */
    public CreateUserAndFridgeController(CreateUserAndFridgeInputBoundary userNameInteractor) {
        this.userNameInteractor = userNameInteractor;
    }

    /**
     * Creates CreateUserAndFridgeResponseModel given a user as a String.
     *
     * @param user as a String
     * @return calls the create method of the interactor
     */
    public CreateUserAndFridgeResponseModel create(String user) {
        CreateUserAndFridgeRequestModel requestModel = new CreateUserAndFridgeRequestModel(user);
        return userNameInteractor.create(requestModel);
    }

}

