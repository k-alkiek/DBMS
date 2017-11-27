package query;

import data.IRecord;

public class BiggerThanOrEqualCondition implements ICondition {
    private String fieldName;
    private Object data;
    @Override
    public boolean validate(IRecord record) {
        try {
            Object recordData = record.getAttribute(fieldName).getData();
            return ((Comparable)recordData).compareTo(data) >= 0;
        }
        catch (Exception e) {
            return false;
        }
    }

    public BiggerThanOrEqualCondition(String fieldName, Object data) {
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