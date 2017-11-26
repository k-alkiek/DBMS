package query;

import data.IRecord;

public class FalseCondition implements ICondition {
    @Override
    public boolean validate(IRecord record) {
        return false;
    }
}
