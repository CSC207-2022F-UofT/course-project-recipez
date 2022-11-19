package presenters.enteringrediant;

import useCases.UserEnterIndrediantsInteractor.UserEnterIngredientResponseModel;

public interface UserEnterIngrediantPresenter {

    UserEnterIngredientResponseModel prepareSuccessView(UserEnterIngredientResponseModel userEnterIngredientResponseModel);

    UserEnterIngredientResponseModel prepareFailView(String error);
}
