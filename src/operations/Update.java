package operations;

import data.*;
import query.ICondition;

import java.util.ArrayList;
import java.util.List;

public class Update implements IIntegerOperation {
    private ICondition myCondition;
    private IRecord record;
    private String tableName;
    List<String> fieldNams;
    List<String> values;
    public Update(String tableName,
                  List<String> fieldNams,
                  List<String> values, ICondition condition) {
        this.tableName = tableName;
        this.fieldNams = fieldNams;
        this.values = values;
        myCondition = condition;
    }
    public boolean notVaild(List<IField> listOfFields) {
        for(int i = 0; i < fieldNams.size(); i++)
        {
            int flag = 0;
            for(int j = 0; j < listOfFields.size(); j++)
            {
                if(listOfFields.get(j).getName().equals(fieldNams.get(i)))
                {
                    flag = 1;
                }
            }
            if(flag == 0)
            {
                return  true;
            }
        }
        return  false;
    }
    @Override
    public int execute() {
        DatabaseManager manager = DatabaseManager.getInstance();
        IDatabase database = manager.getDatabaseInUse();
        TableCachedXml table = new TableCachedXml(database.getName(), tableName);
        if(notVaild(table.getFields())) {
            throw  null;
        }
       return table.update(myCondition, fieldNams, values);
    }
}
