package main;

import eg.edu.alexu.csd.oop.db.cs15.DatabaseImp;

import java.sql.SQLException;

public class MainTester {
    public static void main(String[] args) throws SQLException {
        DatabaseImp dp = new DatabaseImp();
        dp.createDatabase("DB1",false);
        System.out.println(dp.executeStructureQuery("CREate Table table1 (id int,name varchar,empty int)"));
    }
}
