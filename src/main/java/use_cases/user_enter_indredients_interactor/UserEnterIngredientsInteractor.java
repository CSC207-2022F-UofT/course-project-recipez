package use_cases.user_enter_indredients_interactor;

import database.DatabaseGateway;
import entities.fridge.CommonFridge;
import entities.ingredient.CommonIngredient;
import entities.ingredient.IngredientFactory;
import entities.user.CommonUser;
import presenters.enter_ingredient.UserEnterIngredientPresenter;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class UserEnterIngredientsInteractor (Implements the setEnterIngredientsInputBoundary)
 */
public class UserEnterIngredientsInteractor implements UserEnterIngredientsInputBoundary {
//    User user;
//    Fridge fridge;
    UserEnterIngredientPresenter userEnterIngredientPresenter;
    IngredientFactory ingredientFactory;

    DatabaseGateway database;

    /**
     *
//     * @param user : The user who is currently using the program
//     * @param fridge : The user's current fridge
     * @param ingredientFactory : An ingredient factory to create an ingredient object based on the string
     * @param userEnterIngredientPresenter Presenter that will call view model based on if ingredient is added or not
     *                                     Need to add database inside this
     */
    public UserEnterIngredientsInteractor(IngredientFactory ingredientFactory,
                                          UserEnterIngredientPresenter userEnterIngredientPresenter,
                                          DatabaseGateway database) {
        this.ingredientFactory = ingredientFactory;
        this.userEnterIngredientPresenter = userEnterIngredientPresenter;
        this.database = database;
    }

    /**
     * @param requestModel
     * @return CommonIngredient, if button is pressed and user does not enter anything an error is presented,
     * Otherwise ingredient is created using ingredient factory, and added to the user's fridge
     */
    @Override
    public UserEnterIngredientResponseModel create(UserEnterIngredientRequestModel requestModel) {
        if (Objects.equals(requestModel.getIngredient_in_String_Format(), "")) {
            return userEnterIngredientPresenter.prepareFailView("Nothing");
        }
        else {
            CommonIngredient ingredient = (CommonIngredient) ingredientFactory.create(requestModel.getIngredient_in_String_Format());
            /**
             * Need to call some database method based on String
             */
            CommonUser Curr_User = (CommonUser) database.get(requestModel.getUserName()).getUser();
            Curr_User.getFridge().addIngredient(ingredient);
            database.save();
            LocalDateTime now = LocalDateTime.now();
            UserEnterIngredientResponseModel responseModel = new UserEnterIngredientResponseModel(ingredient,
                    now.toString());
            return userEnterIngredientPresenter.prepareSuccessView(responseModel);
        }
    }
}
