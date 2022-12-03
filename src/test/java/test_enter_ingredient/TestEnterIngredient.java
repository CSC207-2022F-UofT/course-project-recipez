package test_enter_ingredient;

import database.Database;
import database.DatabaseGateway;
import database.StorageObjects;
import entities.fridge.CommonFridge;
import entities.ingredient.CommonIngredient;
import entities.ingredient.CommonIngredientFactory;
import entities.ingredient.IngredientFactory;
import entities.user.CommonUser;
import org.junit.jupiter.api.*;
import presenters.enter_ingredient.UserEnterIngredientFormatter;
import presenters.enter_ingredient.UserEnterIngredientPresenter;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientRequestModel;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientResponseModel;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientsInteractor;

import java.util.ArrayList;

/**
 * Test Cases for the APICaller class
 */
public class TestEnterIngredient {
    private static UserEnterIngredientsInteractor enterIngredientsInteractor;
    private static CommonFridge fridge;
    private static DatabaseGateway testingDatabase;

    /**
     * Setup for creating database and interactor
     */
    @BeforeEach
    public void setup() {
        testingDatabase = new Database("EnterIngredientTestStorage");
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        UserEnterIngredientPresenter enterIngredientPresenter = new UserEnterIngredientFormatter();
        enterIngredientsInteractor = new UserEnterIngredientsInteractor(
                ingredientFactory,
                enterIngredientPresenter,
                testingDatabase
        );
        ArrayList<CommonIngredient> ingredients = new ArrayList<>();
        fridge = new CommonFridge(ingredients);
        CommonUser testUser = new CommonUser("name", fridge);

        StorageObjects objects = new StorageObjects(testUser, fridge);
        testingDatabase.store("name", objects);
    }

    /**
     * Deletes storage database
     */
    @AfterEach
    public void teardown() {
        testingDatabase.deleteStorageFile();
    }

    /**
     * Test for entering one ingredient to the fridge
     */
    @Test
    public void enterOneIngredient() {
        UserEnterIngredientRequestModel requestModel = new UserEnterIngredientRequestModel("ingredient", "name");
        UserEnterIngredientResponseModel responseModel = enterIngredientsInteractor.create(requestModel);

        Assertions.assertEquals(fridge.printIngredient(), "ingredient");
        Assertions.assertEquals(responseModel.commonIngredient.getName(), "ingredient");
    }

    /**
     * Test for entering ingredients to the fridge twice
     */
    @Test
    public void enterTwoIngredients() {
        UserEnterIngredientRequestModel requestModel = new UserEnterIngredientRequestModel("ingredient", "name");
        UserEnterIngredientRequestModel requestModel2 = new UserEnterIngredientRequestModel("ingredient2", "name");
        enterIngredientsInteractor.create(requestModel);
        UserEnterIngredientResponseModel responseModel = enterIngredientsInteractor.create(requestModel2);

        Assertions.assertEquals(fridge.printIngredient(), "ingredient,ingredient2");
        Assertions.assertEquals(responseModel.commonIngredient.getName(), "ingredient2");
    }
}
