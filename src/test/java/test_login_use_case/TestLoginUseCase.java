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
import presenters.login.LoginPresenter;
import use_cases.login_usecase.LoginInteractor;
import use_cases.login_usecase.LoginInputBoundary;
import use_cases.login_usecase.LoginRequestModel;
import use_cases.login_usecase.LoginResponseModel;
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

        LoginPresenter testingPresenter = new LoginPresenter() {
            @Override
            public void prepareSuccessView(LoginResponseModel responseModel) {
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

        LoginInputBoundary testing_login = new LoginInteractor(testingDatabase, testingPresenter);
        //loginResponseModel inputData = new loginResponseModel(testFridge ,testUser);
        LoginRequestModel inputData = new LoginRequestModel("demetriusjr");
        testing_login.create(inputData);
        testingDatabase.deleteStorageFile();
    }

    /**
     * Check if user does not exist program gives expected result
     */
    @Test
    void nonexistentTest(){

        DatabaseGateway testingDatabase = new Database("Test_Storage");

        LoginPresenter testingPresenter = new LoginPresenter() {
            @Override
            public void prepareSuccessView(LoginResponseModel responseModel) {
                assertEquals("demetriusjr", responseModel.getCommonUser().getName());
                assertTrue(testingDatabase.hasKey("demetriusjr"));
                testingDatabase.deleteStorageFile();
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals(error, "Account does not exist");
            }
        };
        LoginInputBoundary testing_login = new LoginInteractor(testingDatabase, testingPresenter);
        LoginRequestModel inputData = new LoginRequestModel("demetriusSr");
        testing_login.create(inputData);
        testingDatabase.deleteStorageFile();


    }

    /**
     * Expected Result when nothing is entered
     */
    @Test
    void nothingTest(){
        DatabaseGateway testingDatabase = new Database("Test_Storage");
        LoginPresenter testingPresenter = new LoginPresenter() {
            @Override
            public void prepareSuccessView(LoginResponseModel responseModel) {
            }
            @Override
            public void prepareFailView(String error) {
                assertEquals(error, "Nothing Entered");
            }
        };
        LoginInputBoundary testing_login = new LoginInteractor(testingDatabase, testingPresenter);
        LoginRequestModel inputData = new LoginRequestModel("");
        testing_login.create(inputData);
        testingDatabase.deleteStorageFile();
    }

}
