package presenters.enter_ingredient;

import use_cases.enter_indredients_usecase.UserEnterIngredientResponseModel;

/**
 * Presenter class for entering ingredient presenter
 */
public interface UserEnterIngredientPresenter {

    UserEnterIngredientResponseModel prepareSuccessView(UserEnterIngredientResponseModel userEnterIngredientResponseModel);

    UserEnterIngredientResponseModel prepareFailView(String error);
}
