package data;

import data.Exceptions.InvalidDataTypeException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by khaled on 11/25/17.
 */
public class Record implements IRecord {
    private Map<String, Object> fields;
    private ITable table;

    public Record(ITable table, List<String> fieldNames, List<Object> values) throws SQLException {
        fields = new HashMap<>();
        this.table = table;
        if (fieldNames.size() != values.size()) {
            throw new SQLException();
        }

        for (int i = 0; i < fieldNames.size(); i++) {
            setAttribute(fieldNames.get(i), values.get(i));
        }

        for (IField field : table.getFields()) {
            if (!fields.containsKey(field.getName())) {
                setAttribute(field.getName(), field.getDefault());
            }
        }
    }

    @Override
    public Object getAttribute(String fieldName) {
        return fields.get(fieldName);
    }

    @Override
    public void setAttribute(String fieldName, Object value) {
        fields.put(fieldName, value);
    }

}
