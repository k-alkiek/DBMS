package operations;

import data.DatabaseManager;

/**
 * Created by khaled on 11/20/17.
 */
public class CreateDatabase implements IBooleanOperation{
    private String databaseName;
    public  CreateDatabase(String databaseName) {
        this.databaseName = databaseName;
    }
    @Override
    public boolean execute() {
        DatabaseManager manager = new DatabaseManager();
        manager.createDatabase(databaseName);
        return  true;

    }
}
