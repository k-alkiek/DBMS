package parsers;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class InsertParser implements IIntegerParser {
    private String columns, values;
    private int firstIdx, secondIdx;
    @Override
    public int parse(String query) throws SQLException {
        if(isValidQuery(query)) {
            return 0;
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName(String query) {
        query = query.trim();
        String tableName = query.split("\\s+")[2];
        firstIdx = query.lastIndexOf(tableName) + tableName.length() + 2;
        return tableName;
    }

    public String getColumns(String query) {
        secondIdx = query.toLowerCase().lastIndexOf("values");
        String columns = query.substring(firstIdx, secondIdx);
        columns = columns.trim();
        return columns;
    }

    public String getValues(String query) {
        return query.substring(secondIdx + 7, query.lastIndexOf(";")).trim();
    }

    private boolean isValidQuery(String query) {
        if (Pattern.matches("(?i)\\s*(INSERT)\\s+" +
                        "(INTO)\\s+\\w+\\s*(\\()\\s*(\\w+\\s*(,)\\s*)*\\w+\\s*(\\))\\s+" +
                        "(VALUES)\\s*(\\()\\s*(.+\\s*(,)\\s*)*.+\\s*(\\))\\s*(;)\\s*",
                query)) {
            return true;
        }
        return false;
    }
}
