package operations;

import data.*;

/**
 * Created by khaled on 11/20/17.
 */
public class Insert implements IBooleanOperation {
    private IRecord record;
    private String tableName;
    void setRecord(IRecord record){
        this.record = record;
    }
    void setTableName(String tableName){
        this.tableName = tableName;
    }

    @Override
    public boolean execute() {
        IDatabaseManager manager = new DatabaseManager();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
        table.insert(record);
        return true;
    }
}
