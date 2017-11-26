package parsers;

import query.ICondition;

import java.sql.SQLException;

/**
 * Created by khaled on 11/22/17.
 */
public interface IConditionParser {
    ICondition parse(String condition) throws SQLException;
}
