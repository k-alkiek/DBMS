package data;

import data.Exceptions.InvalidDataTypeException;

import java.util.List;
import java.util.Map;

/**
 * Created by khaled on 11/25/17.
 */
public class Record implements IRecord {
    Map<String, ICell> fields;

    public Record(List<String> fieldNames, List<ICell> cells) {
        if (fieldNames.size() != cells.size()) {
            throw new RuntimeException();
        }

        for (int i = 0; i < fieldNames.size(); i++) {
            setAttribute(fieldNames.get(i), cells.get(i));
        }
    }

    @Override
    public ICell getAttribute(String fieldName) {
        return fields.get(fieldName);
    }

    @Override
    public void setAttribute(String fieldName, ICell cell) {
        fields.put(fieldName, cell);
    }

}
