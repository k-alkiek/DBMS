package main;

import parsers.*;

import java.sql.SQLException;

public class QueryCommiter {

    public static boolean executeStructureQuery(String query) throws SQLException {
        String modifiedQuery = query.trim().toLowerCase();
        IBooleanParser booleanParser = null;
        if(modifiedQuery.startsWith("create table")) {
            booleanParser = new CreateTableParser();
        }
        else if(modifiedQuery.startsWith("create")) {
            booleanParser = new CreateDatabaseParser();
        }
        else if(modifiedQuery.startsWith("drop table")) {
            booleanParser = new DropTableParser();
        }else if(modifiedQuery.startsWith("create")) {
            booleanParser = new DropDatabaseParser();
        }
        else {
            throw new SQLException();
        }
        try {
            return booleanParser.parse(query);
        }catch (Exception e) {
            throw new SQLException();
        }
    }

    public static Object[][] executeQuery(String query) throws SQLException {
        ICollectionParser collectionParser = null;
        String modifiedQuery = query.trim().toLowerCase();
        if(modifiedQuery.startsWith("select"))
            collectionParser = new SelectParser();
        else
            throw new SQLException();
        return collectionParser.parse(query);
    }

    public static int executeUpdateQuery(String query) throws SQLException {
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
