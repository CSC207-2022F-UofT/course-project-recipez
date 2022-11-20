package presenters.login;

import use_cases.login_usecase.loginResponseModel;

public interface loginPresenter {

    loginResponseModel prepareSuccessView(loginResponseModel responseModel);

    loginResponseModel prepareFailView(String error);
}
