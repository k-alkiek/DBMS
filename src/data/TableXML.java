package data;

import java.util.List;

/**
 * Created by khaled on 11/25/17.
 */
public class TableXML implements ITable {
    String name;
    String databaseName;

    public TableXML(String databaseName, String name) {
        this.databaseName = databaseName;
        this.name = name;
    }

    @Override
    public boolean insert(IRecord record) {
        return false;
    }

    @Override
    public List<IRecord> select(ICondition condition) {
        return null;
    }

    @Override
    public int delete(ICondition condition) {
        return 0;
    }

    @Override
    public int update(ICondition condition, IRecord record) {
        return 0;
    }

    @Override
    public void addField(IField field) {

    }

    @Override
    public List<IField> getFields() {
        return null;
    }

    @Override
    public void setFields(List<IField> fields) {

    }

    @Override
    public boolean fieldExists(IField field) {
        return false;
    }
}
