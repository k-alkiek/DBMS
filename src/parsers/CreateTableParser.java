package parsers;

import operations.CreateTable;
import operations.IBooleanOperation;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class CreateTableParser implements IBooleanParser {
    private String fields;
    private String[] fieldNames, dataTypes;
    @Override
    public boolean parse(String query) throws SQLException, IllegalAccessException, InstantiationException {
        if (isValidQuery(query)) {
            fields = getFields(query);
            getAtrributes();
            IBooleanOperation create = new CreateTable(getTableName(query), "",
                    fieldNames, dataTypes);
            return create.execute();
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName(String query) {
        query = query.trim();
        String tableName = query.split("\\s+")[2];
        return tableName;
    }

    public String getFields(String query) {
        fields = query.substring(query.lastIndexOf("(") + 1, query.lastIndexOf(")"));
        return fields.trim();
    }

    private boolean isValidQuery(String query) {
        if (Pattern.matches("(?i)\\s*(CREATE)\\s+(TABLE)\\s+\\w+\\s*(\\()\\s*(\\w+\\s+(varchar|int)\\s*(,)\\s*)*" +
                "(\\w+\\s+(varchar|int)\\s*)(\\))\\s*(;)?\\s*", query)) {
            return true;
        }
        return false;
    }

    private void getAtrributes() {
        String[] columns = fields.split(",");
        fieldNames = new String[columns.length];
        dataTypes = new String[columns.length];
        for (int i = 0; i < columns.length; i++) {
            String[] attr = columns[i].trim().split("\\s+");
            fieldNames[i] = attr[0].trim();
            dataTypes[i] = attr[1].trim();
//            System.out.println(fieldNames[i] + " " + dataTypes[i]);
        }
    }
}
