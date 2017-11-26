package data;

import data.Exceptions.TableNotFoundException;

import java.util.List;
import java.io.*;
/**
 * Created by khaled on 11/25/17.
 */
public class Database implements IDatabase {
    private String name;

    public Database(String name) {
        this.name = name;
    }

    @Override
    public void createTable(String tableName, List<IField> fields) {
        ITable table = new TableXML(this.name, tableName);
        table.setFields(fields);
    }

    @Override
    public void deleteTable(String tableName) throws TableNotFoundException {

        File file = new File(this.getName()+"/"+tableName+".xml");
        if(!file.exists()) {
            throw new TableNotFoundException();
        }
        file.delete();

    }

    public String getName() {
        return name;
    }
}
