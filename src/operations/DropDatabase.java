package operations;

import data.DatabaseManager;
import data.Exceptions.DatabaseNotFoundException;

/**
 * Created by khaled on 11/20/17.
 */
public class DropDatabase implements IBooleanOperation{
    private String databaseName;
    void setDatabaseName(String databaseName){ databaseName =databaseName; }

    @Override
    public boolean execute() {

        DatabaseManager manager = new DatabaseManager();
        try {
            manager.dropDatabase(databaseName);
        } catch (DatabaseNotFoundException e) {
            return false;
        }

        return true;
    }
}
