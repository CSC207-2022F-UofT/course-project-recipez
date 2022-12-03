package test_login_use_case;

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
import presenters.login.loginPresenter;
import use_cases.login_usecase.LoginInteractor;
import use_cases.login_usecase.loginInputBoundary;
import use_cases.login_usecase.loginRequestModel;
import use_cases.login_usecase.loginResponseModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginUseCase {
    /**
     * Test if a user already exists
     */
    @Test
    void existsTest() {

        DatabaseGateway testingDatabase = new Database("Test_Storage");

        loginPresenter testingPresenter = new loginPresenter() {
            @Override
            public void prepareSuccessView(loginResponseModel responseModel) {
                assertEquals("demetriusjr", responseModel.getCommonUser().getName());
                assertTrue(testingDatabase.hasKey("demetriusjr"));
                testingDatabase.deleteStorageFile();
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals(error, "Account does not exist");
            }
        };

        FridgeFactory testingFridgeFactory = new CommonFridgeFactory();
        ArrayList<CommonIngredient> ingredients = new ArrayList<>();
        CommonFridge testFridge = (CommonFridge) testingFridgeFactory.create(ingredients);
        UserFactory testingUserFactory = new CommonUserFactory();
        CommonUser testUser = (CommonUser) testingUserFactory.create("demetriusjr", testFridge);
        StorageObjects objects = new StorageObjects(testUser, testFridge);
        testingDatabase.store("demetriusjr", objects);

        loginInputBoundary testing_login = new LoginInteractor(testingDatabase, testingPresenter);
        //loginResponseModel inputData = new loginResponseModel(testFridge ,testUser);
        loginRequestModel inputData = new loginRequestModel("demetriusjr");
        testing_login.create(inputData);
        testingDatabase.deleteStorageFile();
    }

    /**
     * Check if user does not exist program gives expected result
     */
    @Test
    void nonexistentTest(){

        DatabaseGateway testingDatabase = new Database("Test_Storage");

        loginPresenter testingPresenter = new loginPresenter() {
            @Override
            public void prepareSuccessView(loginResponseModel responseModel) {
                assertEquals("demetriusjr", responseModel.getCommonUser().getName());
                assertTrue(testingDatabase.hasKey("demetriusjr"));
                testingDatabase.deleteStorageFile();
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals(error, "Account does not exist");
            }
        };
        loginInputBoundary testing_login = new LoginInteractor(testingDatabase, testingPresenter);
        loginRequestModel inputData = new loginRequestModel("demetriusSr");
        testing_login.create(inputData);
        testingDatabase.deleteStorageFile();


    }

    /**
     * Expected Result when nothing is entered
     */
    @Test
    void nothingTest(){
        DatabaseGateway testingDatabase = new Database("Test_Storage");
        loginPresenter testingPresenter = new loginPresenter() {
            @Override
            public void prepareSuccessView(loginResponseModel responseModel) {
            }
            @Override
            public void prepareFailView(String error) {
                assertEquals(error, "Nothing Entered");
            }
        };
        loginInputBoundary testing_login = new LoginInteractor(testingDatabase, testingPresenter);
        loginRequestModel inputData = new loginRequestModel("");
        testing_login.create(inputData);
        testingDatabase.deleteStorageFile();
    }

}
