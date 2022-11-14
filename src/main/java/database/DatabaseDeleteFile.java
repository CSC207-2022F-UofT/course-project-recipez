package database;

import java.io.File;

public class DatabaseDeleteFile {

    /**
     * Deletes a local file.
     *
     * @param directoryToBeDeleted File - the file object of the file that is to be deleted.
     */
    public static void deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        //noinspection ResultOfMethodCallIgnored
        directoryToBeDeleted.delete();
    }

}


