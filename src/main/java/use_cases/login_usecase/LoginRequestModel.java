package use_cases.login_usecase;

/**
 * Making the login Request Model
 */
public class LoginRequestModel {

    public final String user;

    /**
     * Constructor
     *
     * @param user as a String
     */
    public LoginRequestModel(String user) {
        this.user = user;
    }

    /**
     * Getter method for getting the user
     *
     * @return the user as a String
     */
    String getUserName() {
        return user;
    }
}
