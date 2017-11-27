package operations;

import data.*;

import java.util.ArrayList;
import java.util.List;

public class Update implements IIntegerOperation {
    private ICondition myCondition;
    private IRecord record;
    private String tableName;
    List<String> fieldNams;
    List<String> values;
    public Update(String tableName,
                  List<String> fieldNams,
                  List<String> values, ICondition condition) {
        this.tableName = tableName;
        this.fieldNams = fieldNams;
        this.values = values;
        myCondition = condition;
    }

    @Override
    public int execute() {
        DatabaseManager manager = DatabaseManager.getInstance();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
       return table.update(myCondition, fieldNams, values);
    }
}
