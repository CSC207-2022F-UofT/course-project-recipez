package database;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Database implements Serializable, DatabaseGateway{

    private File storageFile;
    private HashMap<String, Object> database;

    public Database(String filepath) throws IOException, IllegalArgumentException, ClassNotFoundException {
        this(new File(filepath));
    }

    public Database(File file) throws IOException, IllegalArgumentException, ClassNotFoundException {
        this.storageFile = file;

        if (storageFile.isDirectory()) {
            throw new IllegalArgumentException("The Database file must not be a directory");
        }

        if (storageFile.length() == 0 || storageFile.createNewFile()) {
            this.database = new HashMap<String, Object>();
            save();
        } else {
            load();
        }
    }

    @Override
    public void save() throws IOException {
//        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(storageFile)));
//        out.writeObject(database);
//        out.flush();
//        out.close();
        FileOutputStream fileWriter = new FileOutputStream(this.storageFile);
        ObjectOutputStream out = new ObjectOutputStream(fileWriter);
        out.writeObject(this.database);
        out.close();
        fileWriter.close();
    }

    @Override
    public void store(String key, Object o) throws IOException {
        this.database.put(key, o);
        save();
    }


    private void load() throws IOException, ClassNotFoundException {
        ObjectInputStream in =
                new ObjectInputStream(new BufferedInputStream(new FileInputStream(storageFile)));
        this.database = (HashMap<String, Object>) in.readObject();
        in.close();
    }

    public Object get(String key) {
        return this.database.get(key);
    }


    // Not sure if we need this....
    public ArrayList<Object> getAllAsArrayList() {
        return new ArrayList<>(this.database.values());
    }

    public HashMap<String, Object> getAll() {
        return database;
    }

    public void printAll() {
        System.out.println(this);
    }

    @Override
    public void remove(String key) throws IOException {
        database.remove(key);
        save();
    }

    public boolean hasKey(String key) {
        return this.database.containsKey(key);
    }

    public String getKeys() {
        Object[] keys = this.database.keySet().toArray();
        return keys[0].toString();
    }

    public boolean hasObject(Object o) {
        return this.database.containsValue(o);
    }

    @Override
    public String toString() {
        String result = "FileStorage @ " + storageFile.getAbsolutePath() + "\n";
        for (String cKey : database.keySet()) {
            result += cKey + " :: " + database.get(cKey) + "\n";
        }
        return result.trim();
    }


}
