package entities;

/**
 * Error for when API call returns failure status code
 */
public class ApiAccountError extends Error {
    public ApiAccountError(String message) {
        super(message);
    }
}
