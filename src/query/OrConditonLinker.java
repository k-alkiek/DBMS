package query;

import data.IRecord;

public class OrConditonLinker implements ICondition {
    ICondition condition1;
    ICondition condition2;
    @Override
    public boolean validate(IRecord record) {
        return condition1.validate(record) || condition2.validate(record);
    }

    public OrConditonLinker(ICondition condition1, ICondition condition2) {
        this.condition1 = condition1;
        this.condition2 = condition2;
    }
}
