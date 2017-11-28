package operations;

import data.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by khaled on 11/20/17.
 */
public class CreateTable implements IBooleanOperation {
    private String tableName;
    private String databaseName;
    private List<IField> myFields;
    public CreateTable(String tableName, String databaseName, String[] fieldName, String[] types) throws InstantiationException, IllegalAccessException {

        this.tableName = tableName;
        this.databaseName = databaseName;
        myFields = new ArrayList<>();
        for(int i = 0; i < fieldName.length; i++) {
            myFields.add(FieldsFactory.create(types[i], fieldName[i]));
        }
    }

    @Override
    public boolean execute() {
        DatabaseManager manager = DatabaseManager.getInstance();
        boolean foundDatabase = false;
        for(int i=0;i<manager.allDatabase.size();i++)
            if(manager.allDatabase.get(i).equals(databaseName))
                foundDatabase = true;
        if (!foundDatabase)
            return  false;


        IDatabase database = manager.getDatabaseInUse();
        String tablePath = manager.databasePath(database.getName()) + System.getProperty("file.separator") + tableName + ".xml";
        File tableFile = new File(tablePath);
        if (tableFile.exists()) {
            return false;
        }
        database.createTable(tableName, myFields);
        return true;
    }
}
