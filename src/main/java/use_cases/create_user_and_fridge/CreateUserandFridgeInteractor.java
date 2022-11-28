package use_cases.create_user_and_fridge;

import database.DatabaseGateway;
import database.StorageObjects;
import entities.fridge.CommonFridge;
import entities.fridge.FridgeFactory;
import entities.ingredient.CommonIngredient;
import entities.user.CommonUser;
import entities.user.UserFactory;
import presenters.create_user_and_fridge.CreateUserAndFridgePresenter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class CreateUserandFridgeInteractor
 */
public class CreateUserandFridgeInteractor implements CreateUserAndFridgeInputBoundary {
    UserFactory userFactory;
    FridgeFactory fridgeFactory;
    CreateUserAndFridgePresenter createUserAndFridgePresenter;

    final DatabaseGateway database;

    /**
     * @param userFactory : Takes in a userFactory, this helps to create a new user
     * @param fridgeFactory : Takes in a fridgeFactory, this helps to create a new fridge
     * @param createUserAndFridgePresenter : Creates a presenter with success or fail view
     */

    public CreateUserandFridgeInteractor(UserFactory userFactory, FridgeFactory fridgeFactory, CreateUserAndFridgePresenter
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
    public CreateUserandFridgeResponseModel create(CreateUserandFridgeRequestModel requestModel) {
/**
 * Need some method here that already checks if database has it
 */
        if (database.hasKey(requestModel.getUserName())) {
            return createUserAndFridgePresenter.prepareFailView("User already exists.");
        }
        else if (requestModel.getUserName().isEmpty()) {
            return createUserAndFridgePresenter.prepareFailView("Nothing");
        }
        else {
            ArrayList<CommonIngredient> tesst = new ArrayList<>();
            CommonFridge curr_fridge = (CommonFridge) fridgeFactory.create(tesst);
            CommonUser curr_user = (CommonUser) userFactory.create(requestModel.getUserName(), curr_fridge);

            StorageObjects storageObjects = new StorageObjects(curr_user, curr_fridge);
            database.store(requestModel.getUserName(), storageObjects);

            /**
             * Add erics method and somehow do database.save()
             */
            // Need to add erics method
            //            database.save();
            LocalDateTime now = LocalDateTime.now();
            CreateUserandFridgeResponseModel successResponseModel = new
                    CreateUserandFridgeResponseModel(curr_fridge, curr_user, now.toString());

            try{
                return createUserAndFridgePresenter.prepareSuccessView(successResponseModel);
            } catch (Exception e) {
                System.out.println("exception");
                return createUserAndFridgePresenter.prepareFailView(e.toString());
            }
        }
    }

//    @Override
//    public String create(CreateUserandFridgeRequestModel requestModel) {
//        if (Objects.equals(requestModel.getUserName(), "")) {
//            return createUserAndFridgePresenter.prepareFailView("Nothing entered");
//        }
//        else {
//            ArrayList<CommonIngrediant> temporary = new ArrayList<>();
//            Fridge fridge = fridgeFactory.create(temporary);
//            User user = userFactory.create("Shaffaan", (CommonFridge) fridge);
//
//            CreateUserandFridgeResponseModel user_created_successfully =
//                    new CreateUserandFridgeResponseModel(user.getName());
//            return createUserAndFridgePresenter.prepareSuccessView(user_created_successfully);
//        }
//    }
}
