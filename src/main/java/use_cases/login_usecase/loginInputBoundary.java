package use_cases.login_usecase;

/**
 * loginInputBoundary interface
 */
public interface loginInputBoundary {
    /**
     * Creates a loginResponseModel
     *
     * @param requestModel takes in a request Model
     * @return goes to page where user can enter ingredients, if user does not exist throws error
     */
    loginResponseModel create(loginRequestModel requestModel);
}
