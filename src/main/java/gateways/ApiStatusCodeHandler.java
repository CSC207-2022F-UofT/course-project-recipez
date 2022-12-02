package gateways;

import gateways.errors.ApiRequestError;

/**
 * Facade part for handling error responses from API call
 */
public class ApiStatusCodeHandler {
    private final int statusCode;

    public ApiStatusCodeHandler(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Throw error messages based on HTTP status code
     */
    public void checkErrorStatus() {
        switch (this.statusCode) {
            case 200:
                return;
            case 401:
                throw new ApiRequestError("API call unsuccessful. Account may have incorrect credentials or reached quota.");
            case 400:
                throw new ApiRequestError("API call unsuccessful. Request may contain unaccepted characters");
            default:
                throw new ApiRequestError("API call unsuccessful.");
        }
    }
}
