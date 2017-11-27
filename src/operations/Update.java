package operations;

import data.*;

import java.util.ArrayList;
import java.util.List;

public class Update implements IIntegerOperation {
    private ICondition myCondition;
    private IRecord record;
    private String tableName;
    public Update(String tableName,
                  List<String> fieldNams,
                  List<String> values, ICondition condition) {
        this.tableName = tableName;
        IDatabaseManager manager = new DatabaseManager();
        IDatabase database = manager.getDatabaseInUse();
        myCondition = condition;
        TableXML table = new TableXML(database.getName(), tableName);
        List<Object> objectValue = new ArrayList<Object>(values);
        record = new Record(table, fieldNams, objectValue);
    }

    @Override
    public int execute() {
        IDatabaseManager manager = new DatabaseManager();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
       return table.update(myCondition, record);
    }
}
