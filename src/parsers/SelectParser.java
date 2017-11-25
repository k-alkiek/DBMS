package parsers;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class SelectParser implements ICollectionParser {
    private String tableName, columns;
    @Override
    public Object[][] parse(String query) throws SQLException {
        if (isValidQuery(query)) {
            return new Object[0][];
        } else {
            throw new SQLException("invalid Query");
        }
    }

    private boolean isValidQuery(String query) {
        if(Pattern.matches("(?i)\\s*(SELECT)\\s+.+\\s+(FROM)\\s+\\w+\\s*(;)\\s*", query)) {
            calculateArgs(query);
            int firstIdx = query.toLowerCase().lastIndexOf("select") + 7,
            secondIdx = query.toLowerCase().lastIndexOf("from") - 5;
            columns = query.substring(firstIdx, secondIdx);
            return true;
        } else if (Pattern.matches("(?i)\\s*(SELECT)\\s+(\\*)\\s+(FROM)\\s+\\w+\\s*(;)\\s*", query)) {
            calculateArgs(query);
            columns = "ALL";
            return true;
        }
        return false;
    }

    private void calculateArgs(String query) {
        tableName = query.split("\\s+")[query.split("\\s+").length - 1];
        if(tableName.contains(";")) {
            tableName = tableName.substring(0, tableName.lastIndexOf(";"));
        }
    }
}
