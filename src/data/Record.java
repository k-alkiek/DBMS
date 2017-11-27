package data;

import data.Exceptions.InvalidDataTypeException;

import java.util.List;
import java.util.Map;

/**
 * Created by khaled on 11/25/17.
 */
public class Record implements IRecord {
    private Map<String, Object> fields;
    private ITable table;

    public Record(ITable table, List<String> fieldNames, List<Object> values) {
        this.table = table;
        if (fieldNames.size() != values.size()) {
            throw new RuntimeException();
        }

        for (int i = 0; i < fieldNames.size(); i++) {
            setAttribute(fieldNames.get(i), values.get(i));
        }
    }

    @Override
    public Object getAttribute(String fieldName) {
        return fields.get(fieldName).toString();
    }

    @Override
    public void setAttribute(String fieldName, Object value) {
        fields.put(fieldName, value);
    }

}
