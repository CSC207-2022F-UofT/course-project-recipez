package database;

/**
 * Interface that defines interaction with the Database.
 */
public interface DatabaseGateway {

    /**
     * Adds a new object given a unique key to the database.
     *
     * @param key    The unique string identifier of the object that is stored in the database.
     * @param storageObjects   The Storage Objects Struct class to storage the Fridge and User
     */
    void store(String key, StorageObjects storageObjects);

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
    StorageObjects get(String key);

    /**
     * Deletes the storage file associated with the database.
     */
    void deleteStorageFile();

    boolean hasKey(String key);
}