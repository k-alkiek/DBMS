package data;

import data.Exceptions.InvalidDataTypeException;

/**
 * Created by khaled on 11/25/17.
 */
public class Cell implements ICell {
    IField field;
    Object data;

    public Cell(IField field, Object data) {
        this.field = field;
        this.data = data;
    }

    public Cell(IField field) {
        this.field = field;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) throws InvalidDataTypeException {
        this.data = data;
    }
}
