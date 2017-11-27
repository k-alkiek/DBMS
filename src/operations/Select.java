package operations;

import data.*;

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
        IDatabaseManager manager = new DatabaseManager();
        IDatabase database = manager.getDatabaseInUse();
        TableXML table = new TableXML(database.getName(), tableName);
        List<IRecord> records = table.select(myCondition);
        List<IField> fields = table.getFields();
        Object[][] result = new Object[records.size()][fieldsName.size()];
        if(fieldsName.get(0).equals("*")) {
            this.fieldsName.clear();
            for( int j = 0; j < fields.size(); j++)
                this.fieldsName.add(fields.get(j).getName());
        }
        if(notVaild(fields)){
            return null;
        }
        for(int i = 0; i < records.size(); i++) {
            for( int j = 0; j < fields.size(); j++) {
                if(find(fields.get(j).getName())) {
                    result[i][j] = records.get(i).getAttribute(fields.get(j).getName());
                }
            }
        }

        return  result;
    }
}
