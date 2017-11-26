package data;

public interface IDatabaseManager {
    void createDatabase(String databaseName);
    void deleteDatabase(String databaseName);
    void setDefaultDatabase(String databaseName);
}
