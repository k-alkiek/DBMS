package data;

import data.Exceptions.DatabaseNotFoundException;

public interface IDatabaseManager {
    IDatabase createDatabase(String databaseName);
    void dropDatabase(String databaseName) throws DatabaseNotFoundException;
    IDatabase getDatabaseInUse();
    void setDatabaseInUse(String databaseName) throws DatabaseNotFoundException;
}
