package operations;

import data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 11/20/17.
 */
public class Insert implements IIntegerOperation {
    private IRecord record;
    private String tableName;
    public Insert(String tableName,
                  List<String> fieldNams,
                  List<String> values) {
        this.tableName = tableName;
        IDatabaseManager manager = new DatabaseManager();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
        List<Object> objectValue = new ArrayList<Object>(values);
        record = new Record(table, fieldNams, objectValue);
    }

    @Override
    public int execute() {
        IDatabaseManager manager = new DatabaseManager();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
        table.insert(record);
        return 1;
    }
}
