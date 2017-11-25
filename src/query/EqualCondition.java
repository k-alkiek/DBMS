package query;

import data.ICell;
import data.IField;
import data.IRecord;

public class EqualCondition implements ICondition {
    private IField field;
    private ICell data;
    @Override
    public boolean validate(IRecord record) {
        // ToDo
        return false;
    }

    public EqualCondition(IField field, ICell data) {
        this.field = field;
        this.data = data;
    }

    public void setField(IField field) {
        this.field = field;
    }

    public void setData(ICell data) {
        this.data = data;
    }
}
