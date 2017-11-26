package query;

import data.IRecord;

public class TrueCondition implements ICondition {
    @Override
    public boolean validate(IRecord record) {
        return true;
    }
}
