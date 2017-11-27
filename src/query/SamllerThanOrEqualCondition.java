package query;

import data.IRecord;

public class SamllerThanOrEqualCondition implements ICondition {
    private ICondition equalCondition;
    private ICondition smallerCondition;
    private ICondition orCondition;

    @Override
    public boolean validate(IRecord record) {
        return orCondition.validate(record);
    }

    public SamllerThanOrEqualCondition(String fieldName, Object data) {
        equalCondition = new EqualCondition(fieldName, data);
        smallerCondition = new SamllerThanCondition(fieldName, data);
        orCondition = new OrConditonLinker(equalCondition, smallerCondition);
    }
}
