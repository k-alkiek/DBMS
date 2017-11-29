package eg.edu.alexu.csd.oop.db.cs15;

import data.DatabaseManager;
import data.IDatabaseManager;
import eg.edu.alexu.csd.oop.db.Database;
import parsers.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class DatabaseImp implements Database {
    DatabaseManager databaseManager;
    public DatabaseImp(){
        databaseManager = DatabaseManager.getInstance();
    }
    @Override
    public String createDatabase(String databaseName, boolean dropIfExists) {
      databaseName = databaseName.toLowerCase();
        if(dropIfExists){
            try {
                executeStructureQuery("DROP DATABASE " + databaseName);
            } catch (SQLException e) {
            }
            finally {
                try {
                    executeStructureQuery("CREATE DATABASE " + databaseName);
                } catch (SQLException e) {
                }
            }
        }
        else {
            try {
                executeStructureQuery("CREATE DATABASE " + databaseName);
            } catch (SQLException e) {}
        }
        return databaseManager.databasePath(databaseName);
    }

    @Override
    public boolean executeStructureQuery(String query) throws SQLException {
        String modifiedQuery = query.trim().toLowerCase();
        IBooleanParser booleanParser = null;
        if(modifiedQuery.startsWith("create table")) {
            if (databaseManager.getDatabaseInUse() == null) {
                return false;
            }
            booleanParser = new CreateTableParser();
        }
        else if(modifiedQuery.startsWith("create database")) {
            booleanParser = new CreateDatabaseParser();
        }
        else if(modifiedQuery.startsWith("drop table")) {
            booleanParser = new DropTableParser();
        }else if(modifiedQuery.startsWith("drop database")) {
            booleanParser = new DropDatabaseParser();
        }
        else {
            return false;
        }
        try {
            return booleanParser.parse(query);
        }
        catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public Object[][] executeQuery(String query) throws SQLException {
        ICollectionParser collectionParser = null;
        String modifiedQuery = query.trim().toLowerCase();
        if(modifiedQuery.startsWith("select"))
            collectionParser = new SelectParser();
        else
            throw new SQLException();

        try {
            return collectionParser.parse(query);
        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public int executeUpdateQuery(String query) throws SQLException {
        IIntegerParser integerParser = null;
        String modifiedQuery = query.trim().toLowerCase();
        if(modifiedQuery.startsWith("insert")) {
            integerParser = new InsertParser();
        }
        else if(modifiedQuery.startsWith("update")) {
            integerParser = new UpdateParser();
        }
        else if(modifiedQuery.startsWith("delete")) {
            integerParser = new DeleteParser();
        }
        else
            throw new SQLException();
        return integerParser.parse(query);
    }
}
