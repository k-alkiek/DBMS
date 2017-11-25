package parsers;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class UpdateParser implements IIntegerParser {
    private String condition, inputs;
    @Override
    public int parse(String query) throws SQLException {
        if(isValidQuery(query)) {
            return 0;
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName(String query) {
        String tableName = query.trim().split("\\s+")[1];
        return tableName;
    }

    public String getCondition() {
        return condition.trim();
    }

    public String getInputs() {
        return inputs.trim();
    }

    private boolean isValidQuery(String query) {
        if(Pattern.matches("(?i)\\s*(UPDATE)\\s+\\w+\\s+(SET)\\s+.+\\s+(WHERE)\\s+.+\\s*(;)\\s*", query)) {
            int secondIdx = query.toLowerCase().lastIndexOf("where") + 6;
            calculateArgs(query, secondIdx - 7);
            condition = query.substring(secondIdx, query.lastIndexOf(";"));
            return true;
        } else if(Pattern.matches("(?i)\\s*(UPDATE)\\s+\\w+\\s+(SET)\\s+.+(;)\\s*", query)) {
            calculateArgs(query, query.lastIndexOf(";"));
            condition = "*";
            return true;
        }
        return false;
    }

    private void calculateArgs(String query, int secondIdx) {
        int firstIdx = query.toLowerCase().lastIndexOf("set") + 4;
        inputs = query.substring(firstIdx, secondIdx);
    }
}
