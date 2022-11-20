package presenters.create_user_and_fridge;

import use_cases.create_user_and_fridge.CreateUserandFridgeResponseModel;

public interface CreateUserAndFridgePresenter {
        CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel responseModel);

        CreateUserandFridgeResponseModel prepareFailView(String error);
}
