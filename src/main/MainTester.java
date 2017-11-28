package main;

import eg.edu.alexu.csd.oop.db.cs15.DatabaseImp;

import java.sql.SQLException;

public class MainTester {
    public static void main(String[] args) throws SQLException {
        DatabaseImp dp = new DatabaseImp();
        dp.createDatabase("DB1",false);
        System.out.println(dp.executeStructureQuery("CREate Table t (id int,name varchar)"));
        //System.out.println(dp.executeUpdateQuery("insert into t values (1,'Ayman')"));
        //System.out.println(dp.executeUpdateQuery("insert into t (name) values ('Ayman0')"));
        //System.out.println(dp.executeUpdateQuery("insert into t (id) values (-1)"));
        select(dp,"SElect * From t");
        select(dp,"SElect name From t");
        select(dp,"SElect id From t");
        select(dp,"SElect * From t where id = 0");
        select(dp,"SElect * From t where id > 0");
        select(dp,"SElect * From t where id <= 0");

    }

    public static void select(DatabaseImp db, String query) throws SQLException {
        Object[][] values = db.executeQuery(query);
        for (int i = 0; i < values.length; i ++) {
            for (int j = 0; j < values[i].length; j ++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }
    }
}
