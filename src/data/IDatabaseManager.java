package data;

import data.Exceptions.DatabaseNotFoundException;

import java.sql.SQLException;

public interface IDatabaseManager {
    IDatabase createDatabase(String databaseName);
    void dropDatabase(String databaseName) throws DatabaseNotFoundException, SQLException;
    IDatabase getDatabaseInUse();
    void setDatabaseInUse(String databaseName) throws DatabaseNotFoundException, SQLException;
}
