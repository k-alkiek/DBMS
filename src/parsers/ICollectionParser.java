package parsers;

import java.sql.SQLException;

/**
 * Created by khaled on 11/22/17.
 */
public interface ICollectionParser {
    Object[][] parse(String query) throws SQLException;
}
