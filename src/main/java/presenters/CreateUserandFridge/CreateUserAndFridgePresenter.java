package presenters.UserEnterIngrediant;

import entities.user.CommonUser;
import useCases.CreateUserAndFridge.CreateUserandFridgeRequestModel;
import useCases.CreateUserAndFridge.CreateUserandFridgeResponseModel;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngrediantResponseModel;

    public interface CreateUserAndFridgePresenter {
        CommonUser prepareSuccessView(CommonUser user);
}
