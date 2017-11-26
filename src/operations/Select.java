package operations;

import query.ICondition;

public class Select implements IDataOperation {
    void setConditon(ICondition conditon){}
    void setDatabaseName(String databaseName){}
    void setTableName(String tableName) { }
    @Override
    public Object[][] execute() {
        return new Object[0][];
    }
}
