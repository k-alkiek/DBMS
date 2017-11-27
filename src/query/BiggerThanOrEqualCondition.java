package query;

import data.IRecord;

public class BiggerThanOrEqualCondition implements ICondition {
    private ICondition equalCondition;
    private ICondition biggerCondition;
    private ICondition orCondition;

    @Override
    public boolean validate(IRecord record) {
        return orCondition.validate(record);
    }

    public BiggerThanOrEqualCondition(String fieldName, Object data) {
        equalCondition = new EqualCondition(fieldName, data);
        biggerCondition = new BiggerThanCondition(fieldName, data);
        orCondition = new OrConditonLinker(equalCondition, biggerCondition);
    }
}
