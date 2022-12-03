package presenters.login;

import use_cases.login_usecase.loginResponseModel;

@SuppressWarnings("SameReturnValue")
/**
 * Presenter for login use case
 */
public interface loginPresenter {

    void prepareSuccessView(loginResponseModel responseModel);

    void prepareFailView(String error);
}
