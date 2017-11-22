package operations;

import data.IDatabase;
import data.IField;

/**
 * Created by khaled on 11/20/17.
 */
public interface ICreateTable extends IBooleanOperation {
    void setName(String name);
    void setFields(IField[] fields);
    void setDatabase(IDatabase database);
}
