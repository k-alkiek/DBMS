package parsers;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class CreateTableParser implements IBooleanParser {
    String tableName;
    @Override
    public boolean parse(String query) throws SQLException {
        if (isValidQuery(query)) {
            return false;
        } else {
            throw new SQLException("invalid Query");
        }
    }

    private boolean isValidQuery(String query) {
        if (Pattern.matches("(?!)\\s*(CREATE)\\s+(TABLE)\\s+\\w+\\s*(\\()\\s*(\\w+\\s+(varchar|int)(,)\\s*)*" +
                        "(\\w+\\s+(varchar|int)\\s*)(\\))(;)\\s*",
                query)) {
            tableName = query.split("\\s+")[2];
            return true;
        }
        return false;
    }
}
