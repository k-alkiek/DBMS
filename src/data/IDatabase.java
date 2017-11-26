package data;

import data.Exceptions.TableNotFoundException;

import java.util.List;

/**
 * Created by khaled on 11/22/17.
 */
public interface IDatabase {
    void createTable(String tableName,List<IField> fields);
    void deleteTable(String tableName) throws TableNotFoundException;
}
