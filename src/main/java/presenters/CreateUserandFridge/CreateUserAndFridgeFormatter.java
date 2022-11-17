package presenters.UserEnterIngrediant;

import entities.user.CommonUser;
import useCases.CreateUserAndFridge.CreateUserandFridgeRequestModel;

public class CreateUserAndFridgeFormatter implements CreateUserAndFridgePresenter {
    @Override
    public CommonUser prepareSuccessView(CommonUser user) {
        return user;
    }
}
