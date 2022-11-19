package presenters.CreateUserandFridge;

import useCases.CreateUserAndFridge.CreateUserandFridgeResponseModel;

public interface CreateUserAndFridgePresenter {
        CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel responseModel);

        CreateUserandFridgeResponseModel prepareFailView(String error);
}
