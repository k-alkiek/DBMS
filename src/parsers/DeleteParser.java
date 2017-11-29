package parsers;

import operations.DeleteFromTable;
import operations.IIntegerOperation;
import query.ICondition;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class DeleteParser implements IIntegerParser {
    private String tableName, condition;
    @Override
    public int parse(String query) throws SQLException {
        if (isValidQuery(query)) {
            IConditionParser conditionParser = new ConditionParser();
            ICondition cond = conditionParser.parse(getCondition(query));
            IIntegerOperation delete = new DeleteFromTable(getTableName(), cond);
            return delete.execute();
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName() {
        tableName = tableName.toLowerCase();
        return tableName;
    }

    public String getCondition(String query) {
        condition = condition.trim();
        if (condition.equals("*"))
            return condition;
        return condition;
    }
    private boolean isValidQuery(String query) {
        if (Pattern.matches("(?i)\\s*(DELETE)\\s+(FROM)\\s+\\w+\\s+(WHERE)\\s+.+\\s*(;)?\\s*", query)) {
            query = query.trim();
            tableName = query.split("\\s+")[2];
            if (tableName.contains("(")) {
                tableName = tableName.substring(0, tableName.lastIndexOf("("));
            }
            int firstIdx = query.toLowerCase().lastIndexOf("where") + 6;
            condition = query.substring(firstIdx);
            return true;
        } else if (Pattern.matches("(?i)\\s*(DELETE)\\s+(\\*)\\s+(FROM)\\s+\\w+\\s*(;)?\\s*", query)) {

            return true;
        } else if (Pattern.matches("(?i)\\s*(DELETE)\\s+(FROM)\\s+\\w+\\s*(;)?\\s*", query)) {
            query = query.trim();
            tableName = query.split("\\s+")[2];
            if(tableName.contains(";")) {
                tableName = tableName.substring(0, tableName.lastIndexOf(";"));
            }
            condition = "*";
            return true;
        }
        return false;
    }
}
