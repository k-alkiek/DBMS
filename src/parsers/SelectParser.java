package parsers;

import operations.IDataOperation;
import operations.Select;
import query.ICondition;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class SelectParser implements ICollectionParser {
    private String columns, tableName;
    public String condition = "*";
    @Override
    public Object[][] parse(String query) throws SQLException {
        if (isValidQuery(query)) {
            String tableName = getTableName(query);
            columns = getColumns(query);
            IConditionParser conditionParser = new ConditionParser();
            ICondition cond = conditionParser.parse(condition);
            IDataOperation select = new Select(cond, tableName, "", getFieldNames());
            return select.execute();
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName(String query) {
        return tableName;
    }

    public String getColumns(String query) {
        return columns.trim();
    }
    private boolean isValidQuery(String query) {
        if(Pattern.matches("(?i)\\s*(SELECT)\\s+.+\\s+(FROM)\\s+\\w+\\s*(;)?\\s*", query)) {
            query = query.trim();
            setAttr(query, query.length());
            return true;
        } else if (Pattern.matches("(?i)\\s*(SELECT)\\s+.+\\s+(FROM)\\s+\\w+\\s+(WHERE)\\s+.+\\s*(;)?\\s*", query)) {
            query = query.trim();
            setAttr(query, query.toLowerCase().lastIndexOf("where"));
            int secondIdx = query.toLowerCase().lastIndexOf("where") + 6;
            condition = query.substring(secondIdx, query.length());
            return true;
        } else if (Pattern.matches("(?i)\\s*(SELECT)\\s+(\\*)\\s+(FROM)\\s+\\w+\\s*(;)\\s*", query)) {
            query = query.trim();
            tableName = query.substring(query.toLowerCase().lastIndexOf("from ") + 5);
            tableName = tableName.trim();
            return true;
        }
        return false;
    }

    private void setAttr(String query, int flag) {
        tableName = query.substring(query.toLowerCase().lastIndexOf("from ") + 5, flag);
        tableName = tableName.trim();
        int firstIdx = query.toLowerCase().lastIndexOf("select") + 7,
                secondIdx = query.toLowerCase().lastIndexOf("from");
        columns = query.substring(firstIdx, secondIdx);
    }

    private List<String> getFieldNames() {
        List<String> names = new ArrayList<>();
        if (columns.contains("*"))
            return names;
        String[] fields = columns.split(",");
        for (String str : fields) {
            names.add(str.trim());
     //       System.out.println(str.trim());
        }
        return names;
    }
}
