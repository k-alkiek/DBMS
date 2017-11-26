package operations;

import data.*;

import java.util.List;

public class Select implements IDataOperation {
    private ICondition condition;
    private String tableName;
    private String databaseName;
    void setConditon(ICondition conditon){
        this.condition = conditon;
    }
    void setDatabaseName(String databaseName){
        this.databaseName = databaseName;
    }
    void setTableName(String tableName) {
        this.tableName = tableName;
    }
    @Override
    public Object[][] execute() {
        DatabaseManager manager = new DatabaseManager();
        Database database = manager.getDatabaseInUse("A7la mesa");
        TableXML table = new TableXML(database.getName(), tableName);
        List<IRecord> records = table.select( condition );
        List<IField> fields = table.getFields();
        Object[][] result = new Object[records.size()][fields.size()];
        for(int i = 0; i < records.size(); i++) {
            for(int j = 0; j < fields.size(); j++) {
                result[i][j] = records.get(i).getAttribute(fields.get(j).getName()).getData();
            }
        }
        return  result;
    }
}
