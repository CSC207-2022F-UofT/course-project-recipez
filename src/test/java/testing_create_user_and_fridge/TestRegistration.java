package testing_create_user_and_fridge;

import database.Database;
import database.DatabaseGateway;
import database.StorageObjects;
import entities.fridge.CommonFridge;
import entities.fridge.CommonFridgeFactory;
import entities.fridge.FridgeFactory;
import entities.ingredient.CommonIngredient;
import entities.user.CommonUser;
import entities.user.CommonUserFactory;
import entities.user.UserFactory;
import org.junit.jupiter.api.Test;
import presenters.create_user_and_fridge.CreateUserAndFridgePresenter;
import use_cases.create_user_and_fridge.CreateUserAndFridgeInputBoundary;
import use_cases.create_user_and_fridge.CreateUserandFridgeInteractor;
import use_cases.create_user_and_fridge.CreateUserandFridgeRequestModel;
import use_cases.create_user_and_fridge.CreateUserandFridgeResponseModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRegistration {

    /**
     * Testing if a user that did not exist is then created along with an empty fridge
     */
    @Test
    void UserAndEmptyFridgeCreated() {
        DatabaseGateway testingDatabase = new Database("Test_Storage");

        CreateUserAndFridgePresenter testingPresenter = new CreateUserAndFridgePresenter() {
            @Override
            public CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel responseModel) {
                assertEquals("demetriusjr", responseModel.getCommonUser().getName());
                // Fridge is empty right now
                assertEquals("", responseModel.getCommonUser().getFridge().printIngredient());
                return null;
            }

            @Override
            public CreateUserandFridgeResponseModel prepareFailView(String error) {
                return null;
            }
        };

        FridgeFactory testingFridgeFactory = new CommonFridgeFactory();
        UserFactory testingUserFactory = new CommonUserFactory();
        CreateUserAndFridgeInputBoundary interactor = new CreateUserandFridgeInteractor(testingUserFactory,
                testingFridgeFactory, testingPresenter, testingDatabase);
        CreateUserandFridgeRequestModel inputData = new CreateUserandFridgeRequestModel("demetriusjr");
        interactor.create(inputData);
        testingDatabase.deleteStorageFile();
    }

    /**
     * Manually create a user along with fridge and test that use case returns that user already exists
     */
    @Test
    void UserExists() {
        DatabaseGateway testingDatabase = new Database("Test_Storage");
        CreateUserAndFridgePresenter testingPresenter = new CreateUserAndFridgePresenter() {

            @Override
            public CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel responseModel) {
                return null;
            }

            @Override
            public CreateUserandFridgeResponseModel prepareFailView(String error) {
                assertEquals("User already exists.", error);
                return null;
            }

        };
        FridgeFactory testingFridgeFactory = new CommonFridgeFactory();
        UserFactory testingUserFactory = new CommonUserFactory();
        CreateUserAndFridgeInputBoundary interactor = new CreateUserandFridgeInteractor(testingUserFactory,
                testingFridgeFactory, testingPresenter, testingDatabase);
        ArrayList<CommonIngredient> ingredients = new ArrayList<>();
        CommonFridge testFridge = (CommonFridge) testingFridgeFactory.create(ingredients);
        CommonUser testUser = (CommonUser) testingUserFactory.create("demetriusSr", testFridge);
        StorageObjects objects = new StorageObjects(testUser, testFridge);
        testingDatabase.store("demetriusSr", objects);
        CreateUserandFridgeRequestModel inputData = new CreateUserandFridgeRequestModel("demetriusSr");
        interactor.create(inputData);


    }

    /**
     * Return error if nothing is entered
     */
    @Test
    void UserDoesNotExist() {
        DatabaseGateway testingDatabase = new Database("Test_Storage");

        CreateUserAndFridgePresenter testingPresenter = new CreateUserAndFridgePresenter() {
            @Override
            public CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel responseModel) {
                return null;
            }

            @Override
            public CreateUserandFridgeResponseModel prepareFailView(String error) {
                assertEquals("Nothing Entered", error);
                return null;
            }
        };

        FridgeFactory testingFridgeFactory = new CommonFridgeFactory();
        UserFactory testingUserFactory = new CommonUserFactory();
        CreateUserAndFridgeInputBoundary interactor = new CreateUserandFridgeInteractor(testingUserFactory,
                testingFridgeFactory, testingPresenter, testingDatabase);
        CreateUserandFridgeRequestModel inputData = new CreateUserandFridgeRequestModel("");
        interactor.create(inputData);
        testingDatabase.deleteStorageFile();

    }

}
