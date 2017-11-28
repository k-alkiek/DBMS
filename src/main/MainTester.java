package main;

import eg.edu.alexu.csd.oop.db.cs15.DatabaseImp;

import java.sql.SQLException;

public class MainTester {
    public static void main(String[] args) throws SQLException {
        DatabaseImp dp = new DatabaseImp();
        dp.createDatabase("DB1",false);
        System.out.println(dp.executeStructureQuery("CREate Table t2 (id int,name varchar)"));
        /*System.out.println(dp.executeUpdateQuery("insert into t2 values (1,'Ayman')"));
        System.out.println(dp.executeUpdateQuery("insert into t2 (name) values ('Kaled')"));
        System.out.println(dp.executeUpdateQuery("insert into t2 (id) values (-1)"));*/
        select(dp,"SElect * From t2");
        select(dp,"SElect name From t2");
        select(dp,"SElect id From t2");
        select(dp,"SElect * From t2 where id = 0");
        select(dp,"SElect * From t2 where id > 0");
        select(dp,"SElect * From t2 where id <= 0");    // Error Here
        System.out.println(dp.executeUpdateQuery("DElete * From t2"));
        select(dp,"SElect * From t2");
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
