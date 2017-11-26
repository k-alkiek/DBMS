package parsers;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class SelectParser implements ICollectionParser {
    private String columns;
    @Override
    public Object[][] parse(String query) throws SQLException {
        if (isValidQuery(query)) {
            return new Object[0][];
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName(String query) {
        String tableName = query.substring(query.toLowerCase().lastIndexOf("from ") + 5,
                query.lastIndexOf(";"));
        tableName = tableName.trim();
        return tableName;
    }

    public String getColumns(String query) {
        return columns.trim();
    }
    private boolean isValidQuery(String query) {
        if(Pattern.matches("(?i)\\s*(SELECT)\\s+.+\\s+(FROM)\\s+\\w+\\s*(;)\\s*", query)) {
            query = query.trim();
            int firstIdx = query.toLowerCase().lastIndexOf("select") + 7,
                    secondIdx = query.toLowerCase().lastIndexOf("from");
            columns = query.substring(firstIdx, secondIdx);
            return true;
        }
        return false;
    }
}
