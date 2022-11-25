package database;

import entities.fridge.Fridge;
import entities.user.User;

import java.io.Serializable;

/**
 * Storage Objects Struct class to storage the Fridge and User
 */
public class StorageObjects implements Serializable {
    private Fridge fridge;
    private User user;

    /**
     * Constructor
     *
     * @param fridge The Fridge object
     * @param user The User object
     */
    public StorageObjects(User user, Fridge fridge) {
        this.fridge = fridge;
        this.user = user;
    }

    /**
     * Constructor
     */
    // Supress warnings if we want to use an empty constructor in the future.
    @SuppressWarnings("all")
    public StorageObjects() {}

    /**
     * The getter function for getting the Fridge
     *
     * @return the Fridge object
     */
    public Fridge getFridge() {
        return fridge;
    }

    /**
     * The getter function for getting the User
     *
     * @return the User object
     */
    public User getUser() {
        return user;
    }

    /**
     * The setter function for the Fridge object
     */
    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    /**
     * The setter function for the User object
     */
    public void setUser(User user) {
        this.user = user;
    }
}
