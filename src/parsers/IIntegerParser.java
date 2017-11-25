package parsers;

import java.sql.SQLException;

/**
 * Created by khaled on 11/22/17.
 */
public interface IIntegerParser {
    int parse(String query) throws SQLException;
}
