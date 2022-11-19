package presenters.enter_ingredient;

import use_cases.user_enter_indredients_interactor.UserEnterIngredientResponseModel;

public interface UserEnterIngredientPresenter {

    UserEnterIngredientResponseModel prepareSuccessView(UserEnterIngredientResponseModel userEnterIngredientResponseModel);

    UserEnterIngredientResponseModel prepareFailView(String error);
}
