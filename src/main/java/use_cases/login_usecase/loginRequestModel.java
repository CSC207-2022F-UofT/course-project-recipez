package use_cases.login_usecase;

/**
 * Making the login Request Model
 */
public class loginRequestModel {

    public final String user;

    /**
     * Constructor
     *
     * @param user as a String
     */
    public loginRequestModel(String user) {
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
