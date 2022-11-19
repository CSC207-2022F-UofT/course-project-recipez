package useCases.CreateUserAndFridge;

/**
 * Class CreateUserandFridgeRequestModel
 */

public class CreateUserandFridgeRequestModel {
    public String user;

    /**
     * @param user : Constructor for this class, sets the string user to user entered
     */
    public CreateUserandFridgeRequestModel(String user) {
        this.user = user;
    }

    /**
     * @return the name of the user
     */
    String getUserName() {
        return user;
    }

    /**
     * @param
     */
    void setUser(String user) {
        this.user = user;
    }
}
