package operations;

import data.DatabaseManager;
import data.Exceptions.DatabaseNotFoundException;

import java.sql.SQLException;

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
        } catch (SQLException e) {
            return false;
        }

        return true;
    }
}
