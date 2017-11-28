package operations;

import data.*;

public class DeleteFromTable implements IIntegerOperation {
    private query.ICondition myCondition;
    private String tableName;

    public DeleteFromTable(String tableName, query.ICondition condition) {
        this.tableName = tableName;
        myCondition = condition;
    }


    @Override
    public int execute() {
        DatabaseManager manager = DatabaseManager.getInstance();
        IDatabase database = manager.getDatabaseInUse();
        TableCachedXml table = new TableCachedXml(database.getName(), tableName);
        return table.delete(myCondition);
    }
}
