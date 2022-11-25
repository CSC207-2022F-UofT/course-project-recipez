package use_cases.create_user_and_fridge;

import database.DatabaseGateway;
import entities.fridge.CommonFridge;
import entities.fridge.FridgeFactory;
import entities.ingredient.CommonIngredient;
import entities.user.CommonUser;
import entities.user.UserFactory;
import presenters.create_user_and_fridge.CreateUserAndFridgePresenter;


import java.util.ArrayList;

/**
 * Class CreateUserAndFridgeInteractor
 */
public class CreateUserAndFridgeInteractor implements CreateUserAndFridgeInputBoundary {
    UserFactory userFactory;
    FridgeFactory fridgeFactory;
    CreateUserAndFridgePresenter createUserAndFridgePresenter;

    final DatabaseGateway database;

    /**
     * @param userFactory : Takes in a userFactory, this helps to create a new user
     * @param fridgeFactory : Takes in a fridgeFactory, this helps to create a new fridge
     * @param createUserAndFridgePresenter : Creates a presenter with success or fail view
     */

    public CreateUserAndFridgeInteractor(UserFactory userFactory, FridgeFactory fridgeFactory, CreateUserAndFridgePresenter
                                         createUserAndFridgePresenter, DatabaseGateway database ) {
        this.userFactory = userFactory;
        this.fridgeFactory = fridgeFactory;
        this.createUserAndFridgePresenter = createUserAndFridgePresenter;
        this.database = database;

    }

    /**
     * @param requestModel Main method for the use case. If no name is entered, it calls a fail view.
     *                     Otherwise, creates a fridge and user, stores it in database
     *                     Use the presenter to prepare a success view
     */
    @Override
    public CreateUserAndFridgeResponseModel create(CreateUserAndFridgeRequestModel requestModel) {
        if (database.hasKey(requestModel.getUserName())) {
            return createUserAndFridgePresenter.prepareFailView("User already exists.");
        }
        else if (requestModel.getUserName().isEmpty()) {
            return createUserAndFridgePresenter.prepareFailView("Nothing");
        }
        else {
            ArrayList<CommonIngredient> arr_list = new ArrayList<>();
            CommonFridge curr_fridge = (CommonFridge) fridgeFactory.create(arr_list);
            CommonUser curr_user = (CommonUser) userFactory.create(requestModel.getUserName(), curr_fridge);

            ArrayList<Object> list = new ArrayList<>();
            list.add(curr_fridge);
            list.add(curr_user);
            database.store(requestModel.getUserName(), list);

            CreateUserAndFridgeResponseModel successResponseModel = new
                    CreateUserAndFridgeResponseModel(curr_fridge, curr_user);

            try{
                return createUserAndFridgePresenter.prepareSuccessView(successResponseModel);
            } catch (Exception e) {
                System.out.println("exception");
                return createUserAndFridgePresenter.prepareFailView(e.toString());
            }
        }
    }
}