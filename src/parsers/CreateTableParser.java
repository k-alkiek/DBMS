package parsers;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class CreateTableParser implements IBooleanParser {
    private String fields;
    @Override
    public boolean parse(String query) throws SQLException {
        if (isValidQuery(query)) {
            return true;
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName(String query) {
        query = query.trim();
        String tableName = query.split("\\s+")[2];
        return tableName;
    }

    public String getFields(String query) {
        fields = query.substring(query.lastIndexOf("(") + 1, query.lastIndexOf(")"));
        return fields.trim();
    }

    private boolean isValidQuery(String query) {
        if (Pattern.matches("(?i)\\s*(CREATE)\\s+(TABLE)\\s+\\w+\\s*(\\()\\s*(\\w+\\s+(varchar|int)\\s*(,)\\s*)*" +
                "(\\w+\\s+(varchar|int)\\s*)(\\))\\s*(;)?\\s*", query)) {
            return true;
        }
        return false;
    }
}
