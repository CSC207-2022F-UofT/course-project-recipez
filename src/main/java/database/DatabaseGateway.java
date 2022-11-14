package database;

import java.io.IOException;

/**
 * Interface that defines interaction with a database containing only items of the object type.
 *
 */
public interface DatabaseGateway {

    /**
     * Adds a new object given a unique key to the database.
     *
     * @param key The unique string identifier of the object that is stored in the database.
     * @param object The object that is stored in the database.
     */
    void store(String key, Object object) throws IOException ;

    /**
     * Remove an object from the database.
     *
     * @param key The unique string identifier of that object.
     */
    void remove(String key) throws IOException;

    /**
     * Saves the database.
     */
    void save() throws IOException;

    /**
     * Gets the first and only key in the database which is the username
     */
    String getUsername();

    /**
     * Gets the object from the database based on the
     *
     * @param key The unique string identifier of that object.
     */
    public Object get(String key);

}
