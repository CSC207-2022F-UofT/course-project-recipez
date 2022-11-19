package presenters.CreateUserandFridge;

import useCases.CreateUserAndFridge.CreateUserandFridgeResponseModel;

public interface CreateUserAndFridgePresenter {
//        CommonUser prepareSuccessView(CommonUser user);
        CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel responseModel);

        CreateUserandFridgeResponseModel prepareFailView(String error);
}
