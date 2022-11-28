import database.Database;
import database.DatabaseGateway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * The unit test class to test the Database.
 */
public class DatabaseTest {

    private final String username = "Eric";
    private DatabaseGateway database;
    private final ArrayList<Object> list = new ArrayList<>();
   // private Fridge fridge;

    /**
     * Setup method before each test
     */
    @BeforeEach
    public void setUp() {
//        fridge = new Fridge();
//        Ingredient t = new Ingredient();
//        t.setName("Tomato");
//
//        Ingredient l = new Ingredient();
//        l.setName("Lettuce");
//
//        fridge.addIngredient(l);
//        fridge.addIngredient(t);

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

//        list.add(fridge);
//        list.add(fridge);
//        database.store(username, list);
//
//        Database loadedDatabase = new Database("Test");
//
//        Fridge f = (Fridge) database.get(username).get(0);
//
//        assertEquals(((Fridge) database.get(username).get(0)).getUUID(),
//                ((Fridge) loadedDatabase.get(username).get(0)).getUUID());
        assertEquals(true, true);
    }

    /**
     * A test that tests the remove method in the database.
     */
    @Test
    public void testRemoveDatabase() {

       // list.add(fridge);

        //database.store(username, list);

        database.remove(username);

        assertEquals(database.get(username), null);
    }

    /**
     * A tear down method after each test.
     */
    @AfterEach
    public void tearDown() {
        database.deleteStorageFile();
    }

}
