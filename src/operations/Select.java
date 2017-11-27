package operations;

import data.*;
import query.ICondition;

import java.util.List;

public class Select implements IDataOperation {
    private ICondition myCondition;
    private String tableName;
    private String databaseName;
    public Select(ICondition condition, String tableName, String databaseName) {
        this.myCondition = condition;
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    @Override
    public Object[][] execute() {
        IDatabaseManager manager = new DatabaseManager();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
        List<IRecord> records = table.select(myCondition);
        List<IField> fields = table.getFields();
        Object[][] result = new Object[records.size()][fields.size()];
        for(int i = 0; i < records.size(); i++) {
            for(int j = 0; j < fields.size(); j++) {
                result[i][j] = records.get(i).getAttribute(fields.get(j).getName());
            }
        }
        return  result;
    }
}
