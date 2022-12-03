package presenters.enter_ingredient;

import use_cases.enter_indredients_usecase.UserEnterIngredientResponseModel;

/**
 * Implements the Presenter (using dependency injection), More it has methods that are used by viewModel
 */
public class UserEnterIngredientFormatter implements UserEnterIngredientPresenter {

    /**
     * Format for Enter Ingredient Response for success view and fail view
     */
    @Override
    public UserEnterIngredientResponseModel prepareSuccessView(UserEnterIngredientResponseModel userEnterIngredientResponseModel) {
        return userEnterIngredientResponseModel;
    }
    /**
     * @param error : The error that needs to be displayed
     */
    @Override
    public UserEnterIngredientResponseModel prepareFailView(String error) {
        return null;
    }
}
