package database;

import java.io.*;
import java.util.HashMap;

public class Database implements Serializable, DatabaseGateway {

    private static final long serialVersionUID = 1L;

    private final File storageFile;
    private HashMap<String, Object> database;

    public Database(String filepath) throws IOException, IllegalArgumentException, ClassNotFoundException {
        this(new File(filepath));
    }

    public Database(File file) throws IOException, IllegalArgumentException, ClassNotFoundException {
        this.storageFile = file;

        if (storageFile.isDirectory()) {
            throw new IllegalArgumentException("The Database file must not be a directory");
        }

        if (storageFile.createNewFile() || storageFile.length() == 0) {
            this.database = new HashMap<String, Object>();
            save();
        } else {
            load();
        }
    }

    @Override
    public void save() throws IOException {
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

    @Override
    public void remove(String key) throws IOException {
        database.remove(key);
        save();
    }

    @Override
    public Object get(String key) {
        return this.database.get(key);
    }

    @Override
    public String getUsername() {
        Object username = this.database.keySet().iterator().next();
        return username.toString();
    }

    @SuppressWarnings("unchecked")
    private void load() throws IOException, ClassNotFoundException {
        ObjectInputStream in =
                new ObjectInputStream(new BufferedInputStream(new FileInputStream(storageFile)));
        this.database = (HashMap<String, Object>) in.readObject();
        in.close();
    }

    private boolean hasObject(Object o) {
        return this.database.containsValue(o);
    }

    private boolean hasKey(String key) {
        return this.database.containsKey(key);
    }


}
