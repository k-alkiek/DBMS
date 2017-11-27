package query;

import data.IRecord;

public class EqualCondition implements ICondition {
    private String fieldName;
    private Object data;
    @Override
    public boolean validate(IRecord record) {
        Object recordData;
        try {
            recordData = record.getAttribute(fieldName);
            return data.equals(recordData);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public EqualCondition(String fieldName, Object data) {
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