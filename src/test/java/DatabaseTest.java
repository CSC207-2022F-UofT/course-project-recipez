import database.Database;
import fridge.Fridge;
import fridge.Ingredient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private final String username = "Eric";
    private Database database;
    private Fridge fridge;

    /**
     * Setup method before each test
     */
    @BeforeEach
    public void setUp() {
        fridge = new Fridge();
        Ingredient t = new Ingredient();
        t.setName("Tomato");

        Ingredient l = new Ingredient();
        l.setName("Lettuce");

        fridge.addIngredient(l);
        fridge.addIngredient(t);

        database = new Database("Test");
    }

    /**
     * The test that tests everything
     * - Creating the database using the gateway
     * - Saving a fridge object
     * - Load the Fridge object and see if they are the same as the original Fridge Object
     */
    @Test
    public void testCreateSaveLoadDatabase() {

        database.store(username, fridge);

        Database loadedDatabase = new Database("Test");

        assertEquals(username, loadedDatabase.getUsername());
        assertEquals(database.getUsername(), loadedDatabase.getUsername());
        assertEquals("[Lettuce, Tomato]",
                Arrays.toString(((Fridge) database.get(username)).allIngredientValues()));
        assertEquals(((Fridge) database.get(username)).allIngredientValues(),
                ((Fridge) loadedDatabase.get(username)).allIngredientValues());
    }

    /**
     * A test that tests the remove method in the database.
     */
    @Test
    public void testRemoveDatabase() {

        database.store(username, fridge);

        database.remove(username);

        assertEquals(database.getUsername(), "");
    }

    /**
     * A tear down method after each test.
     */
    @AfterEach
    public void tearDown() {
        database.deleteStorageFile();
    }

}
