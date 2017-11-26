package data;

import data.Exceptions.DatabaseNotFoundException;

public interface IDatabaseManager {
    IDatabase createDatabase(String databaseName);
    void dropDatabase(String databaseName);
    IDatabase getDatabaseInUse(String databaseName);
    void setDatabaseInUse(String databaseName) throws DatabaseNotFoundException;
}
