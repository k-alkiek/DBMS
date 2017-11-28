package parsers;

import operations.DropTable;
import operations.IBooleanOperation;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class DropTableParser implements IBooleanParser {

    @Override
    public boolean parse(String query) throws SQLException {
        if (isValidateQuery(query)) {
            IBooleanOperation drop = new DropTable(getTableName(query), "");
            return drop.execute();
        } else {
            throw new SQLException("invalid query");
        }
    }

    public String getTableName(String query) {
        query = query.trim();
        String tableName = query.split("\\s+")[2].toLowerCase();
        if(tableName.contains(";")) {
            tableName = tableName.substring(0, tableName.lastIndexOf(";"));
        }
        return tableName;
    }
    private boolean isValidateQuery (String query) {
        if (Pattern.matches("(?i)\\s*(DROP)\\s+(TABLE)\\s+\\w+\\s*(;)?\\s*", query)) {
            return true;
        }
        return false;
    }
}
