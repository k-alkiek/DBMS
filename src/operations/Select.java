package operations;

import data.*;
import query.ICondition;

import java.util.List;

public class Select implements IDataOperation {
    private ICondition myCondition;
    private String tableName;
    private String databaseName;
    private List<String> fieldsName;
    public Select(ICondition condition, String tableName, String databaseName, List<String> FieldsName) {
        this.myCondition = condition;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.fieldsName =  FieldsName;

    }
    public boolean find(String sbstr) {

        for(int i = 0; i < fieldsName.size(); i++) {
            if(fieldsName.get(i).equals(sbstr)) {
                return  true;
            }
        }
        return false;
    }
    public boolean notVaild(List<IField> listOfFields) {
        for(int i = 0; i < fieldsName.size(); i++)
        {
            int flag = 0;
            for(int j = 0; j < listOfFields.size(); j++)
            {
                if(listOfFields.get(j).getName().equals(fieldsName.get(i)))
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
    public Object[][] execute() {
        DatabaseManager manager = DatabaseManager.getInstance();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
        List<IRecord> records = table.select(myCondition);
        List<IField> fields = table.getFields();
        if(fieldsName.size() == 0) {
            this.fieldsName.clear();
            for( int j = 0; j < fields.size(); j++)
                this.fieldsName.add(fields.get(j).getName());
        }
        Object[][] result = new Object[records.size()][fieldsName.size()];
        if(notVaild(fields)){
            throw  null;
        }
        for(int i = 0; i < records.size(); i++) {
            IRecord record = records.get(i);
            for( int j = 0; j < fields.size(); j++) {
                String fieldName = fields.get(j).getName();
                if(find(fieldName)) {
                    result[i][j] = record.getAttribute(fieldName);
                }
            }
        }

        return  result;
    }
}
