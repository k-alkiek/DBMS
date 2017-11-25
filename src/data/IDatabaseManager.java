package data;

import data.Exceptions.DatabaseNotFoundException;

public interface IDatabaseManager {
    void createDatabase(String databaseName);
    void dropDatabase(String databaseName);
    Database getDatabaseInUse(String databaseName);
    void setDatabaseInUse(String databaseName) throws DatabaseNotFoundException;
}
