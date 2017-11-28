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
        ITable table = new TableCachedXml(this.name, tableName);
        String tablePath = (DatabaseManager.getInstance().databasePath(name)) + tableName + ".xml";
        table.setFields(fields);
//        File xmlFile = new File(name + "/" + name + ".xml");
    }

    @Override
    public void deleteTable(String tableName) throws TableNotFoundException {
        String databasePath = DatabaseManager.getInstance().databasePath(getName());
        File XMLFile = new File(databasePath + "/" + tableName + ".xml");
        File XSCFile = new File(databasePath + "/" + tableName + ".xsc");
        if(!XMLFile.exists()) {
            throw new TableNotFoundException();
        }
        XMLFile.delete();
        XSCFile.delete();

    }

    @Override
    public String getName() {
        return name;
    }
}
