package database;

import java.io.File;

public class DatabaseDeleteFile {

    /**
     * Deletes a local file.
     *
     * @param file File - the file object of the file that is to be deleted.
     */
    public static void deleteFile(File file) {
        file.delete();
    }
}


