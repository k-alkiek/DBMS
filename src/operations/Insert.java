package operations;

import data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 11/20/17.
 */
public class Insert implements IIntegerOperation {
    private IRecord record;
    private String tableName;
    List<String> fieldNams;
    List<String> values;
    public Insert(String tableName,
                  List<String> fieldNams,
                  List<String> values) {
        this.tableName = tableName;
        this.fieldNams = fieldNams;
        this.values = values;


    }

    @Override
    public int execute() {
        DatabaseManager manager = DatabaseManager.getInstance();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
        List<Object> objectValue = new ArrayList<Object>(values);
        record = new Record(table, fieldNams, objectValue);
        List<IField> listOfFields =  table.getFields();
        for(int i=0;i<fieldNams.size();i++)
        {
            int flag = 0;
            for(int j=0;j<listOfFields.size();j++)
            {
                if(listOfFields.get(j).getName().equals(fieldNams.get(i)))
                {
                    flag = 1;
                }
            }
            if(flag == 0)
            {
                throw  null;
            }
        }
        table.insert(record);
        return 1;
    }
}