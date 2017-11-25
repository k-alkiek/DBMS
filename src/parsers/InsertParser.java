package parsers;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class InsertParser implements IIntegerParser {
    private String tableName, columns, values;
    @Override
    public int parse(String query) throws SQLException {
        if(isValidQuery(query)) {
            return 0;
        } else {
            throw new SQLException("invalid Query");
        }
    }

    private boolean isValidQuery(String query) {
        if (Pattern.matches("(?i)\\s*(INSERT)\\s+" +
                        "(INTO)\\s+\\w+\\s*(\\()\\s*(\\w+\\s*(,)\\s*)*\\w+\\s*(\\))\\s+" +
                        "(VALUES)\\s*(\\()\\s*(.+\\s*(,)\\s*)*.+\\s*(\\))\\s*(;)",
                query)) {
            tableName = query.split("\\s+")[2];
            int firstIdx = query.lastIndexOf(tableName) + tableName.length(),
            secondIdx = query.toLowerCase().lastIndexOf("values"),
            thirdIdx = query.lastIndexOf(";");
            columns = query.substring(firstIdx, secondIdx);
            values = query.substring(secondIdx + 7, thirdIdx);
            return true;
        }
        return false;
    }
}
