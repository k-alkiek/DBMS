package data;

import data.Exceptions.DatabaseNotFoundException;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by khaled on 11/26/17.
 */
public class DatabaseManager implements IDatabaseManager {
    private IDatabase databaseInUse;
    private static DatabaseManager databaseManager;
    public ArrayList<String> allDatabase = new ArrayList<>();
    private static final String databasesPath = "Database/";

    private DatabaseManager() {

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
    public void dropDatabase(String databaseName) throws DatabaseNotFoundException {
        File databaseDir = new File(databasePath(databaseName));
        deleteFilesInDirectory(databaseDir);
        databaseDir.delete();
    }

    @Override
    public IDatabase getDatabaseInUse() {
        return databaseInUse;
    }

    @Override
    public void setDatabaseInUse(String databaseName) throws DatabaseNotFoundException {
        databaseInUse = new Database(databaseName);
    }

    public String databasePath(String databaseName) {
        return databasesPath + databaseName;
    }

    private void deleteFilesInDirectory(File directory) {
        String[] fileNames = directory.list();
        for(String fileName: fileNames){
            File currentFile = new File(directory.getPath(), fileName);
            currentFile.delete();
        }
    }
}
