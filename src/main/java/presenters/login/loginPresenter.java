package presenters.login;

import use_cases.login_usecase.loginResponseModel;

/**
 * Presenter for login use case
 */
public interface loginPresenter {

    loginResponseModel prepareSuccessView(loginResponseModel responseModel);

    loginResponseModel prepareFailView(String error);
}
