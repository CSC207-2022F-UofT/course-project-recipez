package use_cases.enter_indredients_usecase;

import database.DatabaseGateway;
import entities.ingredient.CommonIngredient;
import entities.ingredient.IngredientFactory;
import entities.user.CommonUser;
import presenters.enter_ingredient.UserEnterIngredientPresenter;


import java.util.Objects;

/**
 * Class UserEnterIngredientsInteractor (Implements the setEnterIngredientsInputBoundary)
 */
public class UserEnterIngredientsInteractor implements UserEnterIngredientsInputBoundary {
    final UserEnterIngredientPresenter userEnterIngredientPresenter;
    final IngredientFactory ingredientFactory;

    final DatabaseGateway database;

    /**
     * @param ingredientFactory : An ingredient factory to create an ingredient object based on the string
     * @param userEnterIngredientPresenter Presenter that will call view model based on if ingredient is added or not
     * @param database                     Need to add database inside this
     */
    public UserEnterIngredientsInteractor(IngredientFactory ingredientFactory,
                                          UserEnterIngredientPresenter userEnterIngredientPresenter,
                                          DatabaseGateway database) {
        this.ingredientFactory = ingredientFactory;
        this.userEnterIngredientPresenter = userEnterIngredientPresenter;
        this.database = database;
    }

    /**
     * @param requestModel the request model is passed in
     */
    @Override
    public void create(UserEnterIngredientRequestModel requestModel) {
        if (Objects.equals(requestModel.getIngredient_in_String_Format(), "")) {
            userEnterIngredientPresenter.prepareFailView("Nothing");
        }
        else {
            CommonIngredient ingredient = (CommonIngredient) ingredientFactory.create(requestModel.getIngredient_in_String_Format());
            CommonUser Curr_User = (CommonUser) database.get(requestModel.getUserName()).getUser();
            Curr_User.getFridge().addIngredient(ingredient);
            database.save();
            UserEnterIngredientResponseModel responseModel = new UserEnterIngredientResponseModel(ingredient);
            userEnterIngredientPresenter.prepareSuccessView(responseModel);
        }
    }
}
