package database;

import java.io.*;
import java.util.HashMap;


/**
 * Implements Serializable and DatabaseGateway and the Database is the persistence layer in the project.
 */
public class Database implements Serializable, DatabaseGateway {

    // Instance variables
    private final File storageFile;
    private HashMap<String, Object> database;

    /**
     * Constructor used to initialize the Database given a String filepath
     *
     * @param filepath String filepath name
     */
    public Database(String filepath) {

        this.storageFile = new File(filepath);

        try {
            // Enters the if branch if the new file is successfully created. Otherwise, we load from the existing file.
            if (storageFile.createNewFile()) {
                this.database = new HashMap<String, Object>();
                save();
            } else {
                load();
            }
        } catch (Exception e) {
            throw new RuntimeException("The database failed to create a file");
        }
    }

    /**
     * The save method in the Database class
     */
    @Override
    public void save() {
        try {
            FileOutputStream fileWriter = new FileOutputStream(this.storageFile);
            ObjectOutputStream out = new ObjectOutputStream(fileWriter);
            out.writeObject(this.database);
            out.close();
            fileWriter.close();
        } catch (Exception e) {
            throw new RuntimeException("The database saving system is malfunctioning");
        }

    }

    /**
     * The load method in the Database class
     */
    // SuppressWarnings is used as the casting cannot be made generic and the warning provided is irrelevant.
    @SuppressWarnings("unchecked")
    private void load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(storageFile)));
            this.database = (HashMap<String, Object>) in.readObject();
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("The database loading system is malfunctioning");
        }
    }

    /**
     * Store's the object of any type given a unique key in the Database.
     * @param key    The unique string identifier of the object that is stored in the database.
     * @param object The object that is stored in the database.
     */
    @Override
    public void store(String key, Object object) {
        this.database.put(key, object);
        save();
    }

    /**
     * Remove's the object of any type given a unique key from the Database.
     *
     * @param key The unique string identifier of that object.
     */
    @Override
    public void remove(String key) {
        database.remove(key);
        save();
    }

    /**
     * The Database class getter function that gets the object given a unique key.
     *
     * @param key The unique string identifier of that object.
     * @return the object of any type that is stored in the Database.
     */
    @Override
    public Object get(String key) {
        return this.database.get(key);
    }

    /**
     * Gets the first and only key in the Database which is the username.
     *
     * @return a String that is the username if it was stored otherwise an empty String.
     */
    @Override
    public String getUsername() {
        if (!this.database.isEmpty()) {
            Object username = this.database.keySet().iterator().next();
            return username.toString();
        }
        return "";
    }

    /**
     * Deletes the storage file associated with the Database.
     */
    @Override
    public void deleteStorageFile() {
        this.storageFile.delete();
    }

    /**
     * Private methods that checks if the object of any type is in the Database.
     *
     * @param object Any type of object that is stored in the Database.
     * @return True if the object is in the database otherwise False.
     */
    private boolean hasObject(Object object) {
        return this.database.containsValue(object);
    }

    /**
     * Private method that checks if the Database has the key in the Hashmap.
     *
     * @param key
     * @return True if the key in the Database other False.
     */
    private boolean hasKey(String key) {
        return this.database.containsKey(key);
    }
}
