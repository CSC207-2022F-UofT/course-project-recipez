package use_cases.login_usecase;

/**
 * loginInputBoundary interface
 */
public interface loginInputBoundary {
    /**
     * Creates a loginResponseModel
     *
     * @param requestModel takes in a request Model
     */
    void create(loginRequestModel requestModel);
}
