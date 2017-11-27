package operations;

import data.DatabaseManager;
import data.Exceptions.DatabaseNotFoundException;

/**
 * Created by khaled on 11/20/17.
 */
public class DropDatabase implements IBooleanOperation{
    private String databaseName;
    public DropDatabase(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public boolean execute() {

        DatabaseManager manager = DatabaseManager.getInstance();
        try {
            manager.dropDatabase(databaseName);
        } catch (DatabaseNotFoundException e) {
            return false;
        }

        return true;
    }
}
