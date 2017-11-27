package query;

import data.ICell;
import data.IField;
import data.IRecord;

public class BiggerThanCondition implements ICondition {
    private String fieldName;
    private Object data;

    @Override
    public boolean validate(IRecord record) {
        try {
            Object recordData = record.getAttribute(fieldName).getData();
            return ((Comparable) recordData).compareTo(data) == 1;
        } catch (Exception e) {
            return false;
        }
    }

    public BiggerThanCondition(String fieldName, Object data) {
        this.fieldName = fieldName;
        this.data = data;
    }
}
