package data;

import java.util.List;

/**
 * Created by khaled on 11/25/17.
 */
public class Database implements IDatabase {
    String path;

    public Database(String path) {
        this.path = path;
    }

    @Override
    public void createTable(String tableName, List<IField> fields) {
        ITable table = new TableXML(this.path, tableName);
        table.setFields(fields);
    }

    @Override
    public void deleteTable(String tableName) {
        //TODO Delete table by path
    }
}
