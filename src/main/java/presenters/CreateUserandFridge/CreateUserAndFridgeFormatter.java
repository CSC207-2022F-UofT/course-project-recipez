package presenters.CreateUserandFridge;

import entities.user.CommonUser;

public class CreateUserAndFridgeFormatter implements CreateUserAndFridgePresenter {
    @Override
    public CommonUser prepareSuccessView(CommonUser user) {
        return user;
    }
}
