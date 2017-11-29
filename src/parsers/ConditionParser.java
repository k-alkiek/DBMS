package parsers;

import query.*;

import java.sql.SQLException;

public class ConditionParser implements IConditionParser {
    private String fieldName;
    private Object value;
    @Override
    public ICondition parse(String condition) throws SQLException {
        if (condition.contains("*")) {
            return new TrueCondition();
        } else {
            setAttributes(condition);
            if (condition.contains(">=")) {
                return new BiggerThanOrEqualCondition(fieldName, value);
            } else if (condition.contains("<=")) {
                return new SamllerThanCondition(fieldName, value);
            } else if (condition.contains("=")) {
                return new EqualCondition(fieldName, value);
            } else if (condition.contains(">")) {
                return new BiggerThanCondition(fieldName, value);
            } else if (condition.contains("<")) {
                return new SamllerThanCondition(fieldName, value);
            }
        }
        return null;
    }

    private void setAttributes(String condition) {
        String[] attributes = condition.split("(<=|>=|=|>|<)");
        fieldName = attributes[0].trim().toLowerCase();
        value = attributes[1].trim();
        if (!value.toString().contains("'")) {
            value = Integer.parseInt(value.toString());
        } else {
            value = value.toString().toString();
        }
    }
}
