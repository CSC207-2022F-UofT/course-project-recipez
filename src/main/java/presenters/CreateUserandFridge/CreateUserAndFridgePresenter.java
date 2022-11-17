package presenters.CreateUserandFridge;

import entities.user.CommonUser;
import useCases.CreateUserAndFridge.CreateUserandFridgeRequestModel;
import useCases.CreateUserAndFridge.CreateUserandFridgeResponseModel;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngrediantResponseModel;

    public interface CreateUserAndFridgePresenter {
//        CommonUser prepareSuccessView(CommonUser user);
        CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel responseModel);

        CreateUserandFridgeResponseModel prepareFailView(String error);
}
