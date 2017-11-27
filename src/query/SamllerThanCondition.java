package query;

import data.ICell;
import data.IField;
import data.IRecord;

public class SamllerThanCondition implements ICondition {
    private String fieldName;
    private Object data;
    @Override
    public boolean validate(IRecord record) {
        try {
            Object recordData = record.getAttribute(fieldName).getData();
            return ((Comparable)recordData).compareTo(data) == -1;
        }
        catch (Exception e) {
            return false;
        }
    }

    public SamllerThanCondition(String fieldName, Object data) {
        this.fieldName = fieldName;
        this.data = data;
    }

    public void setField(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setData(Object data) {
        this.data = data;
    }
}