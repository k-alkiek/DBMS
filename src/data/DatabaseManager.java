package data;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by khaled on 11/26/17.
 */
public class DatabaseManager implements IDatabaseManager {
    private IDatabase databaseInUse;
    private static DatabaseManager databaseManager;
    public ArrayList<String> allDatabase = new ArrayList<>();
    private static final String databasesPath = "Database" + System.getProperty("file.separator");
    private Map<String, String> databasesPathMap;

    private DatabaseManager() {
        databaseInUse = null;
        databasesPathMap = new HashMap<>();
    }

    public static DatabaseManager getInstance() {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }

    @Override
    public IDatabase createDatabase(String databaseName) {
        new File(databasePath(databaseName)).mkdirs();
        databaseInUse = new Database(databaseName);
        allDatabase.add(databaseName);
        return databaseInUse;
    }

    @Override
    public void dropDatabase(String databaseName) throws SQLException {
        File databaseDir = new File(databasePath(databaseName));
        if (!databaseDir.exists()) throw new SQLException();
        deleteFilesInDirectory(databaseDir);
        databaseDir.delete();
        databaseInUse = null;
    }

    @Override
    public IDatabase getDatabaseInUse() {
        return databaseInUse;
    }

    @Override
    public void setDatabaseInUse(String databaseName) throws SQLException {
        databaseInUse = new Database(databaseName);
    }

    public String databasePath(String databaseName) {
        return System.getProperty("user.dir") + System.getProperty("file.separator") + databasesPath + databaseName;
    }

    private void deleteFilesInDirectory(File directory) {
        String[] fileNames = directory.list();
        for(String fileName: fileNames){
            File currentFile = new File(directory.getPath(), fileName);
            currentFile.delete();
        }
    }
}
