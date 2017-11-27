package operations;

import data.*;

import java.util.Arrays;

/**
 * Created by khaled on 11/20/17.
 */
public class CreateTable implements IBooleanOperation {
    private String tableName;
    private String databaseName;
    private IField[] myFields;
    public CreateTable(String tableName, String databaseName, String[] fieldName, String[] types) throws InstantiationException, IllegalAccessException {

        this.tableName = tableName;
        this.databaseName = databaseName;
        myFields = new IField[fieldName.length];
        for(int i = 0; i < fieldName.length; i++) {
            myFields[i] = FieldsFactory.create(types[i], fieldName[i]);
        }
    }

    @Override
    public boolean execute() {
        DatabaseManager manager = DatabaseManager.getInstance();
        int flag = 0;
        for(int i=0;i<manager.allDatabase.size();i++)
            if(manager.allDatabase.equals(databaseName))
                flag = 1;

        if (flag == 0)
            return  false;
        IDatabase database = manager.getDatabaseInUse();
        database.createTable(tableName, Arrays.asList(myFields));
        return true;
    }
}
