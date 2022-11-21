package entities;

/**
 * Error for when API call returns failure status code
 */
public class ApiRequestError extends Error {
    public ApiRequestError(String message) {
        super(message);
    }
}
