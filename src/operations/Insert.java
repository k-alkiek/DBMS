package operations;

import data.Database;
import data.DatabaseManager;
import data.IRecord;
import data.TableXML;

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
        DatabaseManager manager = new DatabaseManager();
        Database database = manager.getDatabaseInUse("A7la mesa");
        TableXML table = new TableXML(database.getName(), tableName);
        table.insert(record);
        return true;
    }
}
