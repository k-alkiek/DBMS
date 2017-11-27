package parsers;

import query.ICondition;
import query.TrueCondition;

import java.sql.SQLException;

public class ConditionParser implements IConditionParser {

    @Override
    public ICondition parse(String condition) throws SQLException {
        if (condition.equals('*')) {
            return new TrueCondition();
        }
        return null;
    }
}
