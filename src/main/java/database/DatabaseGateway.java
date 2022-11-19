package database;

import java.util.ArrayList;

/**
 * Interface that defines interaction with the Database.
 */
public interface DatabaseGateway {

    /**
     * Adds a new object given a unique key to the database.
     *
     * @param key    The unique string identifier of the object that is stored in the database.
     * @param object The list of object(s) that is stored in the database.
     */
    void store(String key, ArrayList<Object> object);

    /**
     * Remove an object from the database.
     *
     * @param key The unique string identifier of that object.
     */
    void remove(String key);

    /**
     * Saves the database.
     */
    void save();

    /**
     * Gets the object from the database based on the
     *
     * @param key The unique string identifier of that object.
     */
    ArrayList<Object> get(String key);

    /**
     * Deletes the storage file associated with the database.
     */
    void deleteStorageFile();
}