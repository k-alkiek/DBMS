package query;

import data.IRecord;

public class EqualCondition implements ICondition {
    private String fieldName;
    private Object data;

    @Override
    public boolean validate(IRecord record) {
        try {
            Object recordData = record.getAttribute(fieldName);
            if (!data.toString().contains("'"))
                return ((Comparable)recordData).compareTo(Integer.parseInt(data.toString())) == 0;
            else
                return ((Comparable)recordData).compareTo(data.toString()) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public EqualCondition(String fieldName, Object data) {
        this.fieldName = fieldName;
        this.data = data;
    }
}