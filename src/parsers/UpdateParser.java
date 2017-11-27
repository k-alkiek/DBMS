package parsers;

import operations.IIntegerOperation;
import operations.Update;
import query.ICondition;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class UpdateParser implements IIntegerParser {
    private String condition, inputs, fieldName, value;
    private List<String> fieldNames, valuesArgs;
    @Override
    public int parse(String query) throws SQLException {
        if(isValidQuery(query)) {
            String tableName = getTableName(query);
            inputs = getInputs();
            condition = getCondition();
            IConditionParser conditionParser = new ConditionParser();
            ICondition cond = conditionParser.parse(condition);
            getAttr();
            IIntegerOperation update = new Update(tableName, fieldNames, valuesArgs, cond);
            return update.execute();
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName(String query) {
        String tableName = query.trim().split("\\s+")[1];
        return tableName;
    }

    public String getCondition() {
        condition = condition.trim();
        if (condition.equals("*"))
            return condition;
        return condition;
    }

    public String getInputs() {
        inputs.replaceAll("(\\()", "");
        inputs.replaceAll("(\\))", "");
        return inputs.trim();
    }

    private boolean isValidQuery(String query) {
        query = query.trim();
        if(Pattern.matches("(?i)\\s*(UPDATE)\\s+\\w+\\s+(SET)\\s+.+\\s+(WHERE)\\s+.+\\s*(;)?\\s*", query)) {
            int secondIdx = query.toLowerCase().lastIndexOf("where") + 6;
            calculateArgs(query, secondIdx - 7);
            condition = query.substring(secondIdx, query.length());
            return true;
        } else if(Pattern.matches("(?i)\\s*(UPDATE)\\s+\\w+\\s+(SET)\\s+.+(;)?\\s*", query)) {
            calculateArgs(query, query.length() - 1);
            condition = "*";
            return true;
        }
        return false;
    }

    private void calculateArgs(String query, int secondIdx) {
        if (query.charAt(secondIdx) == ';') {
            secondIdx--;
        }
        int firstIdx = query.toLowerCase().lastIndexOf("set") + 4;
        inputs = query.substring(firstIdx, secondIdx);
    }

    private void getAttr() {
        fieldNames = new ArrayList<>();
        valuesArgs = new ArrayList<>();
        String[] attr = inputs.split(",");
        for (int i = 0; i < attr.length; i ++) {
            String[] attributes = condition.split("=");
            fieldNames.add(attributes[0]);
            valuesArgs.add(attributes[1]);
        }
    }
}
