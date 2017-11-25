package parsers;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class DropTableParser implements IBooleanParser {
    private String tableName;
    @Override
    public boolean parse(String query) throws SQLException {
        if (isValidateQuery(query)) {
            return false;
        } else {
            throw new SQLException("invalid query");
        }
    }

    private boolean isValidateQuery (String query) {
        if (Pattern.matches("(?i)\\s*(DROP)\\s+(TABLE)\\s+\\w+\\s*(;)\\s*", query)) {
            tableName = query.split("\\s+")[2];
            if(tableName.contains(";")) {
                tableName = tableName.substring(0, tableName.lastIndexOf(";"));
            }
            return true;
        }
        return false;
    }
}
