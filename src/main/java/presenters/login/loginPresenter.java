package presenters.login;

import use_cases.login_usecase.loginResponseModel;

@SuppressWarnings("SameReturnValue")
public interface loginPresenter {

    void prepareSuccessView(loginResponseModel responseModel);

    void prepareFailView(String error);
}
