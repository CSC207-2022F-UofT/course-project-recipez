package database;

import entities.fridge.CommonFridge;
import entities.ingredient.CommonIngredient;
import entities.ingredient.CommonIngredientFactory;
import entities.user.CommonUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The unit test class to test the Database.
 */
public class DatabaseTest {

    private DatabaseGateway database;
    final private String key = "JP";
    final private String filepath = "Test";
    private StorageObjects objects;


    /**
     * Setup method before each test
     */
    @BeforeEach
    public void setUp() {
        CommonIngredientFactory ingredientFactory = new CommonIngredientFactory();
        final ArrayList<CommonIngredient> ingredients = new ArrayList<>();
        ingredients.add((CommonIngredient) ingredientFactory.create("Carrot"));
        ingredients.add((CommonIngredient) ingredientFactory.create("Chicken"));
        ingredients.add((CommonIngredient) ingredientFactory.create("Potato"));
        CommonFridge fridge = new CommonFridge(ingredients);
        CommonUser user = new CommonUser("Eric", fridge);
        objects = new StorageObjects();
        objects.setFridge(fridge);
        objects.setUser(user);
    }

    /**
     * The test that tests everything
     * - Creating the database using the gateway
     * - Saving a fridge object
     * - Load the Fridge object and see if they are the same as the original Fridge Object
     */
    @Test
    public void testCreateSaveLoadDatabase() {
        // Create database
        database = new Database(filepath);
        // Store Fridge and User
        database.store(key, objects);

        DatabaseGateway testTempDatabase = new Database(filepath);

        Assertions.assertEquals(testTempDatabase.get(key).getFridge().getUUID(),
                database.get(key).getFridge().getUUID());
    }

    /**
     * A test that tests the remove method in the database.
     */
    @Test
    public void testRemoveDatabase() {
        database = new Database(filepath);
        database.store(key, objects);
        database.remove(key);

        DatabaseGateway testTempDatabase = new Database(filepath);

        assertNull(database.get(key));
        assertNull(testTempDatabase.get(key));
    }

    /**
     * Add many keys/usernames and StorageObjects to the Database
     */
    @Test
    public void testMultipleKeysDatabase() {
        database = new Database(filepath);
        database.store(key, objects);
        CommonIngredientFactory ingredientFactory = new CommonIngredientFactory();
        objects.getFridge().addIngredient((CommonIngredient) ingredientFactory.create("Rice"));
        final String tempKey = "Test";
        database.store(tempKey, objects);

        DatabaseGateway testTempDatabase = new Database(filepath);

        Assertions.assertEquals(database.get(key).getFridge().getUUID(),
                testTempDatabase.get(key).getFridge().getUUID());
        Assertions.assertEquals(database.get(tempKey).getFridge().getUUID(),
                testTempDatabase.get(tempKey).getFridge().getUUID());
    }

    /**
     * Empty Database - nothing added to it that it still works and saves when loading back in.
     */
    @Test
    public void testEmptyDatabase() {
        database = new Database(filepath);

        DatabaseGateway testTempDatabase = new Database(filepath);

        Assertions.assertEquals(database.toString(), testTempDatabase.toString());
    }

    /**
     * Test hasKey() method in the Database.
     */
    @Test
    public void testHasKeyDatabase() {
        database = new Database(filepath);
        database.store(key, objects);

        assertTrue(database.hasKey(key));
        assertFalse(database.hasKey("demetriusSr"));
    }


    /**
     * Test deleting the Database storage file.
     */
    @Test
    public void testDeleteStorageFileDatabase() {
        database = new Database(filepath);
        database.store(key, objects);
        database.deleteStorageFile();
        Path path = Paths.get(filepath);
        assertFalse(Files.exists(path));
    }

    /**
     * Test that a storage file is created successfully.
     */
    @Test
    public void testCreatedStorageFileDatabase() {
        database = new Database(filepath);
        Path path = Paths.get(filepath);
        assertTrue(Files.exists(path));
    }

    /**
     * A tear down method after each test, which destroys the storage file.
     */
    @AfterEach
    public void tearDown() {
        database.deleteStorageFile();
    }
}
