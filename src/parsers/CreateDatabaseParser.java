package parsers;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class CreateDatabaseParser implements IBooleanParser {
    private String dataBaseName;
    @Override
    public boolean parse(String query) throws SQLException {
        if (isValidateQuery(query)) {
            return false;
        } else {
            throw new SQLException("invalid query");
        }
    }

    private boolean isValidateQuery (String query) {
        if (Pattern.matches("(?i)\\s*(CREATE)\\s+(DATABASE)\\s+\\w+\\s*(;)\\s*", query)) {
            dataBaseName = query.split("\\s+")[2];
            if(dataBaseName.contains(";")) {
                dataBaseName = dataBaseName.substring(0, dataBaseName.lastIndexOf(";"));
            }
            return true;
        }
        return false;
    }
}
