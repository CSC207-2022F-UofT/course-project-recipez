package entities;
/**
 * Represents a user.
 */
public abstract class AbstractUser {
    private String username;
    private String[] userfridge;
    /**
     * Constructor for the user class
     * @ param username "Unique name of the user, this is what it is saved with in the database"
     * @ param Fridge "Unique fridge of the user, user stores the ingrediants in this fridge" (at the start fridge is
     * just empty)
     * */
    public AbstractUser(String username, String[] userFridge) {
        this.username = username;
        this.userfridge = userFridge;
    }
    public String getUsername() {
        return this.username;
    }

}
