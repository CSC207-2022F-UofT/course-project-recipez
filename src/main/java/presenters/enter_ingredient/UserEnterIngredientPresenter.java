package presenters.enter_ingredient;

import use_cases.enter_indredients_usecase.UserEnterIngredientResponseModel;

@SuppressWarnings("ALL")
/**
 * Presenter class for entering ingredient presenter
 */
public interface UserEnterIngredientPresenter {

    void prepareSuccessView(UserEnterIngredientResponseModel userEnterIngredientResponseModel);

    void prepareFailView(String error);
}
