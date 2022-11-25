package presenters.enter_ingredient;

import use_cases.enter_indredients_usecase.UserEnterIngredientResponseModel;

public interface UserEnterIngredientPresenter {

    UserEnterIngredientResponseModel prepareSuccessView(UserEnterIngredientResponseModel userEnterIngredientResponseModel);

    UserEnterIngredientResponseModel prepareFailView(String error);
}
