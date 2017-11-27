package parsers;

import operations.IIntegerOperation;
import operations.Insert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by khaled on 11/22/17.
 */
public class InsertParser implements IIntegerParser {
    private String columns, values;
    private int firstIdx, secondIdx;
    @Override
    public int parse(String query) throws SQLException {
        if(isValidQuery(query)) {
            columns = getColumns(query);
            values = getValues(query);
            IIntegerOperation insert = new Insert(getTableName(query),
                    getFieldNames(), getRealValues());
            return insert.execute();
        } else {
            throw new SQLException("invalid Query");
        }
    }

    public String getTableName(String query) {
        query = query.trim();
        String tableName = query.split("\\s+")[2];
        firstIdx = query.lastIndexOf(tableName) + tableName.length() + 2;
        return tableName;
    }

    public String getColumns(String query) {
        secondIdx = query.toLowerCase().lastIndexOf("values");
        if (columns.equals("*"))
            return columns;
        columns = query.substring(firstIdx, secondIdx);
        columns = columns.replaceAll("(\\()", "");
        columns = columns.replaceAll("(\\))", "");
        columns = columns.trim();
        return columns;
    }

    public String getValues(String query) {
        query = query.trim();
        values = query.substring(secondIdx + 7);
        values = values.replaceAll("(\\()", "");
        values = values.replaceAll("(\\))", "");
        values = values.trim();
        return values;
    }

    private boolean isValidQuery(String query) {
        if (Pattern.matches("(?i)\\s*(INSERT)\\s+" +
                        "(INTO)\\s+\\w+\\s*(\\()\\s*(\\w+\\s*(,)\\s*)*\\w+\\s*(\\))\\s+" +
                        "(VALUES)\\s*(\\()\\s*(.+\\s*(,)\\s*)*.+\\s*(\\))\\s*(;)?\\s*",
                query)) {
            columns = "";
            return true;
        } else if (Pattern.matches("(?i)\\s*(INSERT)\\s+" +
                        "(INTO)\\s+\\w+\\s+" +
                        "(VALUES)\\s*(\\()\\s*(.+\\s*(,)\\s*)*.+\\s*(\\))\\s*(;)?\\s*",
                query)) {
            columns = "*";
            return true;
        }
        return false;
    }

    private List<String> getFieldNames() {
        List<String> value = new ArrayList<>();
        String[] fields = columns.split(",");
        for (int i = 0; i < fields.length; i++) {
            value.add(fields[i].trim());
        }
        return value;
    }

    private List<String> getRealValues() {
        List<String> value = new ArrayList<>();
        String[] inputs = values.split(",");
        for (int i = 0; i < inputs.length; i++) {
            value.add(inputs[i].trim());
        }
        return value;
    }
}
