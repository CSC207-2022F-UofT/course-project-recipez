import database.Database;
import database.DatabaseDeleteFile;
import fridge.Fridge;
import fridge.Ingredient;
import org.junit.After;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private final String username = "Eric";
    private Database database;

    /**
     * The test that tests everything
     *  - Creating the database using the gateway
     *  - Saving a fridge object
     *  - Load the Fridge object and see if they are the same as the original Fridge Object
     */
    @Test
    public void testCreateSaveLoadDatabase() throws IOException, ClassNotFoundException {

        Fridge fridge = new Fridge();
        Ingredient t = new Ingredient();
        t.setName("Tomato");

        Ingredient l = new Ingredient();
        l.setName("Lettuce");

        fridge.addIngredient(l);
        fridge.addIngredient(t);

        Database database = new Database("Test");

        database.store(username, fridge);

        Database loadedDatabase = new Database("Test");

        assertEquals(username, loadedDatabase.getUsername());
        assertEquals(database.getUsername(), loadedDatabase.getUsername());
        assertEquals(((Fridge) database.get(username)).allIngredientValues(),
                ((Fridge) loadedDatabase.get(username)).allIngredientValues());
    }


    /**
     * Deletes the temporary database folder used to store the database for tests after tests are done.
     */
    @After
    public void after() {
       DatabaseDeleteFile.deleteFile(new File("Test"));
    }

}
