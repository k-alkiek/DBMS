package operations;

import data.*;
import query.ICondition;

import java.util.List;

public class Select implements IDataOperation {
    private ICondition myCondition;
    private String tableName;
    private String databaseName;
    private List<String> selectedFields;
    public Select(ICondition condition, String tableName, String databaseName, List<String> FieldsName) {
        this.myCondition = condition;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.selectedFields =  FieldsName;

    }
    public boolean find(String sbstr, List<IField> tablesField) {

        for(int i = 0; i < tablesField.size(); i++) {
            if(tablesField.get(i).getName().equals(sbstr)) {
                return  true;
            }
        }
        return false;
    }
    public boolean notVaild(List<IField> listOfFields) {
        for(int i = 0; i < selectedFields.size(); i++)
        {
            int flag = 0;
            for(int j = 0; j < listOfFields.size(); j++)
            {
                if(listOfFields.get(j).getName().equals(selectedFields.get(i)))
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
        TableCachedXml table = new TableCachedXml(database.getName(), tableName);
        List<IRecord> records = table.select(myCondition);
        List<IField> tableFields = table.getFields();
        if(selectedFields.size() == 0) {
            this.selectedFields.clear();
            for( int j = 0; j < tableFields.size(); j++)
                this.selectedFields.add(tableFields.get(j).getName());
        }
        Object[][] result = new Object[records.size()][selectedFields.size()];
        if(notVaild(tableFields)){
            throw  null;
        }
        int u = 0;
        for(int i = 0; i < records.size(); i++) {
            IRecord record = records.get(i);
            u = 0;
            for( int j = 0; j < selectedFields.size(); j++) {
                String fieldName = selectedFields.get(j);
              //  if(find(fieldName, tableFields)) {
                    result[i][j] = record.getAttribute(fieldName);
                //}
            }
        }

        return  result;
    }
}
