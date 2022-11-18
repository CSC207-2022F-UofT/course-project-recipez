package presenters.enteringrediant;

import entities.Ingrediant.CommonIngredient;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngrediantResponseModel;

public interface UserEnterIngrediantPresenter {

    UserEnterIngrediantResponseModel prepareSuccessView(UserEnterIngrediantResponseModel userEnterIngrediantResponseModel);

    UserEnterIngrediantResponseModel prepareFailView(String error);
}
