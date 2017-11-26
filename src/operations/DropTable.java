package operations;

import data.Database;
import data.DatabaseManager;
import data.Exceptions.TableNotFoundException;

/**
 * Created by khaled on 11/20/17.
 */
public class DropTable implements IBooleanOperation {
    private String tableName;
    private String databaseName;

    void setTableName(String tableName) {
        this.tableName = tableName;
    }

    void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public boolean execute() {
        DatabaseManager manger = new DatabaseManager();
        Database database = manger.getDatabaseInUse(databaseName);
        try {
            database.deleteTable(tableName);
        } catch (TableNotFoundException e) {
            return false;
        }
        return true;
    }
}
