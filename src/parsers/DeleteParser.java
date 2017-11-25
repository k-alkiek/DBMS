package parsers;

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
            return 0;
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName(String query) {
        return tableName;
    }

    public String getCondition(String query) {
        return condition.trim();
    }
    private boolean isValidQuery(String query) {
        if (Pattern.matches("(?i)\\s*(DELETE)\\s+(FROM)\\s+\\w+\\s+(WHERE)\\s+.+\\s*(;)\\s*", query)) {
            query = query.trim();
            tableName = query.split("\\s+")[2];
            int firstIdx = query.toLowerCase().lastIndexOf("where") + 6;
            condition = query.substring(firstIdx, query.lastIndexOf(";"));
            return true;
        } else if (Pattern.matches("(?i)\\s*(DELETE)\\s+(\\*)\\s+(FROM)\\s+\\w+\\s*(;)\\s*", query)) {
            query = query.trim();
            tableName = query.split("\\s+")[3];
            if(tableName.contains(";")) {
                tableName = tableName.substring(0, tableName.lastIndexOf(";"));
            }
            condition = "*";
            return true;
        }
        return false;
    }
}
