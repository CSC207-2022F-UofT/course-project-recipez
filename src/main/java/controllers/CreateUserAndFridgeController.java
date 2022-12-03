package controllers;

import use_cases.create_user_and_fridge.CreateUserAndFridgeInputBoundary;
import use_cases.create_user_and_fridge.CreateUserAndFridgeRequestModel;

/**
 * Controller Class
 */
public class CreateUserAndFridgeController {

    public final CreateUserAndFridgeInputBoundary userNameInteractor;

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
     */
    public void create(String user) {
        CreateUserAndFridgeRequestModel requestModel = new CreateUserAndFridgeRequestModel(user);
        userNameInteractor.create(requestModel);
    }

}

