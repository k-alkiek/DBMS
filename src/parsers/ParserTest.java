package parsers;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by khaledabdelfattah on 11/25/17.
 */
public class ParserTest {

    @Test
    public void createTable() {
        CreateTableParser create = new CreateTableParser();
        String query = "CREATE TABLE Persons ( PersonID int, LastName varchar, FirstName varchar, Address varchar, City varchar) ;";
        try {
            create.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("Persons", create.getTableName(query));
        assertEquals("PersonID int, LastName varchar, FirstName varchar, Address varchar, City varchar",
                create.getFields(query));
    }

    @Test
    public void createDatabase() {
        CreateDatabaseParser create = new CreateDatabaseParser();
        String query = " CREATE DaTaBaSe Persons ;";
        try {
            create.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("Persons", create.getDataBaseName(query));
    }

    @Test
    public void delete() {
        DeleteParser delete = new DeleteParser();
        String query = "DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste' ; ";
        try {
            delete.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("Customers", delete.getTableName(query));
        assertEquals("CustomerName='Alfreds Futterkiste'", delete.getCondition(query));
        query = "  DELETE *  FROM   table_name;";
        try {
            delete.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("table_name", delete.getTableName(query));
        assertEquals("*", delete.getCondition(query));
    }

    @Test
    public void dropDatabase() {
        DropDatabaseParser drop = new DropDatabaseParser();
        String query = " DroP   DataBAse DB;";
        try {
            drop.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("DB", drop.getDataBaseName(query));
    }

    @Test
    public void dropTable() {
        DropTableParser drop = new DropTableParser();
        String query = "DROP TABLE Shippers ; ";
        try {
            drop.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("Shippers", drop.getTableName(query));
    }
    @Test
    public void insert() {
        InsertParser insert = new InsertParser();
        String query = " iNSERT INTO Customers (CustomerName, City, Country) VaLUES ('Cardinal', 'Stavanger', 'Norway')  ";
        try {
            insert.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("Customers", insert.getTableName(query));
        assertEquals("CustomerName, City, Country", insert.getColumns(query));
        assertEquals("'Cardinal', 'Stavanger', 'Norway'", insert.getValues(query));
        query = " iNSERT InTO Customers VaLUES ('Cardinal', 'Stavanger', 'Norway')  ";
        try {
            insert.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("Customers", insert.getTableName(query));
        assertEquals("*", insert.getColumns(query));
        assertEquals("'Cardinal', 'Stavanger', 'Norway'", insert.getValues(query));
    }

    @Test
    public void select() {
        SelectParser select = new SelectParser();
        String query = " SELECT CustomerName , City FROM Customers  ";
        try {
            select.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("Customers", select.getTableName(query));
        assertEquals("CustomerName , City", select.getColumns(query));
        query = " SelecT * From DB  ";
        try {
            select.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("DB", select.getTableName(query));
        assertEquals("*", select.getColumns(query));
    }

    @Test
    public void update() {
        UpdateParser update = new UpdateParser();
        String query = " uPDATE Customers SET ContactName='Juan' WHERE Country='Mexico'  ";
        try {
            update.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("Customers", update.getTableName(query));
        assertEquals("Country='Mexico'", update.getCondition());
        assertEquals("ContactName='Juan'", update.getInputs());
        query = " uPDATE  Customers SET ContactName='Juan' ; ";
        try {
            update.parse(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("Customers", update.getTableName(query));
        assertEquals("*", update.getCondition());
        assertEquals("ContactName='Juan'", update.getInputs());
    }
}
