package database;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Interface that defines interaction with a database containing only items of type T.
 *
 * @param <T> T - type of the items in the database.
 */
public interface DatabaseGateway {

    public Object get(String key);

    /**
     * Adds a new object of type T to the database.
     *
     * @param item The item to add to the database.
     * null if item can't be added.
     */
    void store(String key, Object o) throws IOException;

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

}
