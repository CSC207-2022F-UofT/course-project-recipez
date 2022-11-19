package presenters.enteringrediant;

import useCases.UserEnterIndrediantsInteractor.UserEnterIngredientResponseModel;

public interface UserEnterIngredientPresenter {

    UserEnterIngredientResponseModel prepareSuccessView(UserEnterIngredientResponseModel userEnterIngredientResponseModel);

    UserEnterIngredientResponseModel prepareFailView(String error);
}
