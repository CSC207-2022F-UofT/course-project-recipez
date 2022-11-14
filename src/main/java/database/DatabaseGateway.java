package database;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Interface that defines interaction with a database containing only items of type T.
 *
 * @param <T> T - type of the items in the database.
 */
public interface DatabaseGateway<T> {

    /**
     * Gets all unique identifiers in the stored in the database.
     *
     * @return A hashset of all ids as a string.
     */
    HashSet<Integer> getAllIds();

    /**
     * Gets an object of type T from the database.
     *
     * @param id The unique identifier of that object.
     * @return Object of type T.
     * null if id does not correspond to an object in the database.
     */
    T get(Integer id);

    /**
     * Adds a new object of type T to the database.
     *
     * @param item The item to add to the database.
     * @return an integer id is returned.
     * null if item can't be added.
     */
    Integer add(T item);

    /**
     * Remove an object of type T from the database.
     *
     * @param id The unique identifier of that object.
     */
    void remove(Integer id);

    /**
     * Saves the database.
     */
    void save();

}
