import database.Database;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DatabaseTest {

    private final String username = "Eric";
    private Database database;


    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    /**
     * Initializes the variables used by all the tests before each unit test.
     */
    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        database = new Database(tempFolder.toString());
    }

    @Test
    public void testTempFolder() throws IOException {
        File folder = tempFolder.newFolder("Test Folder");
        File file = tempFolder.newFile("Hello.txt");

        assertEquals(folder.getName(), "Test Folder");
        assertEquals(file.getName(), "Hello.txt");

    }

    @After
    public void tearDown() {}


}
