package data;

import data.Exceptions.InvalidDataTypeException;

/**
 * Created by khaled on 11/22/17.
 */
public interface ICell {
    Object getData();
    void setData(Object data) throws InvalidDataTypeException;
}
