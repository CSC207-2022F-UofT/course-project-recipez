package presenters.login;

import use_cases.login_usecase.LoginResponseModel;

@SuppressWarnings("SameReturnValue")
/**
 * Presenter for login use case
 */
public interface LoginPresenter {

    void prepareSuccessView(LoginResponseModel responseModel);

    void prepareFailView(String error);
}
