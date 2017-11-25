package operations;

import data.IDatabase;
import data.IField;

/**
 * Created by khaled on 11/20/17.
 */
public class CreateTable implements IBooleanOperation {
    void setTableName(String tableName){ }
    void setFields(IField[] fields){ }
    void setDatabaseName(String databaseName){ }
    @Override
    public boolean execute() {
        return false;
    }
}
