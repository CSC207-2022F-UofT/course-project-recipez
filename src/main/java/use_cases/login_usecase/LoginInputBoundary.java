package use_cases.login_usecase;

/**
 * loginInputBoundary interface
 */
public interface LoginInputBoundary {
    /**
     * Creates a loginResponseModel
     *
     * @param requestModel takes in a request Model
     */
    void create(LoginRequestModel requestModel);
}
