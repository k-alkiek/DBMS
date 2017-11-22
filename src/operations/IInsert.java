package operations;

import data.IRecord;
import data.ITable;

/**
 * Created by khaled on 11/20/17.
 */
public interface IInsert extends IBooleanOperation {
    void setRecord(IRecord record);
    void setTable(ITable table);
}
