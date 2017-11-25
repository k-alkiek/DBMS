package data;

import data.Exceptions.InvalidDataTypeException;

/**
 * Created by khaled on 11/22/17.
 */
public interface IRecord {
    ICell getAttribute(String fieldName);
    void setAttribute(String fieldName, ICell data) throws InvalidDataTypeException;
}
