package query;

import data.IRecord;

public class AndConditonLinker implements ICondition {
    ICondition condition1;
    ICondition condition2;
    @Override
    public boolean validate(IRecord record) {
        return condition1.validate(record) && condition2.validate(record);
    }

    public AndConditonLinker(ICondition condition1, ICondition condition2) {
        this.condition1 = condition1;
        this.condition2 = condition2;
    }
}
