package operations;

import data.DatabaseManager;
import data.Database;
import data.IField;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by khaled on 11/20/17.
 */
public class CreateTable implements IBooleanOperation {
    private String tableName;
    private String databaseName;
    private IField[] fileds;
    void setTableName(String tableName){ this.tableName = tableName; }
    void setFields(IField[] fields){ this.fileds = fields; }
    void setDatabaseName(String databaseName){

        this.databaseName = databaseName;
    }
    @Override
    public boolean execute() {
        DatabaseManager manger = new DatabaseManager();
        Database database = manger.getDatabaseInUse(databaseName);
        database.createTable(tableName, Arrays.asList(fileds));
        return true;
    }
}
