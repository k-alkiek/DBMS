package query;

import data.IRecord;

public class EqualCondition implements ICondition {
    private String fieldName;
    private Object data;

    @Override
    public boolean validate(IRecord record) {
        Object recordData;
        try {
            return data.equals(record.getAttribute(fieldName));
        } catch (Exception e) {
            return false;
        }
    }

    public EqualCondition(String fieldName, Object data) {
        this.fieldName = fieldName;
        this.data = data;
    }
}