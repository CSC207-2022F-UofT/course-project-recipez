package presenters.create_user_and_fridge;

import use_cases.create_user_and_fridge.CreateUserAndFridgeResponseModel;

@SuppressWarnings("ALL")
public interface CreateUserAndFridgePresenter {
        CreateUserAndFridgeResponseModel prepareSuccessView(CreateUserAndFridgeResponseModel responseModel);

        CreateUserAndFridgeResponseModel prepareFailView(String error);
}
