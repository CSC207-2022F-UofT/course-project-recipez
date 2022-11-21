package presenters.login;

import use_cases.login_usecase.loginResponseModel;

public class loginFormatter implements loginPresenter{
    @Override
    public loginResponseModel prepareSuccessView(loginResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public loginResponseModel prepareFailView(String error) {
        return null;
    }
}
