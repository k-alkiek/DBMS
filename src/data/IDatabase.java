package data;

/**
 * Created by khaled on 11/22/17.
 */
public interface IDatabase {
    void createTable(String tableName,IField[] fields);
    void deleteTable(String tableName);
}
