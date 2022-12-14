package use_cases.create_user_and_fridge;

/**
 * Class CreateUserAndFridgeRequestModel
 */

public class CreateUserAndFridgeRequestModel {
    public final String user;

    /**
     * @param user : Constructor for this class, sets the string user to user entered
     */
    public CreateUserAndFridgeRequestModel(String user) {
        this.user = user;
    }

    /**
     * @return the name of the user
     */
    String getUserName() {
        return user;
    }
}
