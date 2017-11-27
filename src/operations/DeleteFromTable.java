package operations;

import data.*;

import java.util.ArrayList;
import java.util.List;

public class DeleteFromTable implements IIntegerOperation {
    private ICondition myCondition;
    private String tableName;

    public DeleteFromTable(String tableName, ICondition condition) {
        this.tableName = tableName;
        myCondition = condition;
    }


    @Override
    public int execute() {
        DatabaseManager manager = DatabaseManager.getInstance();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
        return table.delete(myCondition);
    }
}
