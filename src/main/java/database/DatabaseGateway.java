package database;

/**
 * Interface that defines interaction with the Database.
 */
public interface DatabaseGateway {

    /**
     * Adds a new object given a unique key to the database.
     *
     * @param key    The unique string identifier of the object that is stored in the database.
     * @param object The object that is stored in the database.
     */
    void store(String key, Object object);

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
     * Gets the first and only key in the database which is the username
     *
     * @return returns the username of the database
     */
    String getUsername();

    /**
     * Gets the object from the database based on the
     *
     * @param key The unique string identifier of that object.
     */
    Object get(String key);

    /**
     * Deletes the storage file associated with the database.
     */
    void deleteStorageFile();
}
