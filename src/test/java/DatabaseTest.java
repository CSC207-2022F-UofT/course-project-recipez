import database.Database;
import database.DatabaseDeleteFile;
import database.DatabaseDeleteFile;
import fridge.Fridge;
import fridge.Ingredient;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private final String username = "Eric";
    private Database database;


    /**
     * Temporary Folder
     */
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    /**
     * Initialize the database before each test
     */
    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        database = new Database(tempFolder.toString());
    }

    /**
     * Test the creation of a temporary folder called Test Folder and file Hello.txt
     */
    @Test
    public void testTempFolder() throws IOException {
        File folder = tempFolder.newFolder("Test Folder");
        File file = tempFolder.newFile("Hello.txt");

        assertEquals(folder.getName(), "Test Folder");
        assertEquals(file.getName(), "Hello.txt");
    }

    @Test
    public void testCreateSaveLoadDatabase() throws IOException, ClassNotFoundException {

        Fridge fridge = new Fridge();
        Ingredient t = new Ingredient();
        t.setName("Tomato");

        Ingredient l = new Ingredient();
        l.setName("Lettuce");

        fridge.addIngredient(l);
        fridge.addIngredient(t);

        database.store(username, fridge);

        Database loadedDatabase = new Database(tempFolder.toString());

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
        DatabaseDeleteFile.deleteDirectory(new File(tempFolder.toString()));
    }

}
