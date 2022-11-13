package presenters.UserEnterIngrediant;

import useCases.CreateUserAndFridge.CreateUserandFridgeRequestModel;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngrediantResponseModel;

public interface UserEnterIngrediantPresenter {

    UserEnterIngrediantResponseModel prepareSuccessView(UserEnterIngrediantResponseModel user);

    UserEnterIngrediantResponseModel prepareFailView(String error);
}
