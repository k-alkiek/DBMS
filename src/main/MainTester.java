package main;

import eg.edu.alexu.csd.oop.db.cs15.DatabaseImp;

import java.sql.SQLException;

public class MainTester {
    public static void main(String[] args) throws SQLException {
        DatabaseImp dp = new DatabaseImp();
        dp.createDatabase("sc1",false);
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name1(column_name1 varchar , column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO  table_name2(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        //System.out.println(dp.executeUpdateQuery("INSERT INTO * table_name2(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeStructureQuery("Create TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INSERt INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_name1, COLUMN_NAME3, column_NAME2) VAlUES ('value2', 'value4', 5)"));
        System.out.println(dp.executeUpdateQuery("UPDATE table_namE1 SET column_name1='11111111', COLUMN_NAME2=22222222, column_name3='333333333' WHERE coLUmn_NAME3='VALUE3'"));
//        select(dp, "SELECT * FROM table_name1");
        System.out.println(dp.executeStructureQuery("CREATE DATABASE TestDB"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 5)"));
        System.out.println(dp.executeStructureQuery("DROP TABLE table_name1"));
        System.out.println(dp.executeUpdateQuery("UPDATE table_name1 SET column_name1='11111111', COLUMN_NAME2=22222222, column_name3='333333333' WHERE coLUmn_NAME3='VALUE3'"));
        System.out.println(dp.executeStructureQuery("CREATE DATABASE TestDB"));
        System.out.println(dp.executeStructureQuery("DROP DATABASE TestDB"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeStructureQuery("CREATE DATABASE TestDB"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name2(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name2(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name2(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 5)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name2(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 6)"));
        System.out.println(dp.executeUpdateQuery("DELETE From table_name2 WHERE coLUmn_NAME1='VAluE1'"));
        System.out.println(dp.executeUpdateQuery("UPDATE table_name2 SET column_name1='11111111', COLUMN_NAME2=22222222, column_name3='333333333' WHERE coLUmn_NAME2=4"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 5)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 6)"));
        System.out.println(dp.executeUpdateQuery("DELETE From table_name1 WHERE coLUmn_NAME2=4"));
        System.out.println(dp.executeQuery("SELECT * FROM table_name1 WHERE coluMN_NAME2 < 6").length + " " + dp.executeQuery("SELECT * FROM table_name1 WHERE coluMN_NAME2 < 6")[0].length);

//        System.out.println(dp.executeStructureQuery("CREate Table t2 (id int,name varchar)"));
//        System.out.println(dp.executeUpdateQuery("insert into t2 values (1,'Ayman')"));
//        System.out.println(dp.executeUpdateQuery("insert into t2 (name) values ('Kaled')"));
//        System.out.println(dp.executeUpdateQuery("insert into t2 (id) values (-1)"));
//        System.out.println();
//        select(dp,"SElect * From t2");
//        System.out.println();
//        select(dp,"SElect name From t2");
//        System.out.println();
//        select(dp,"SElect id From t2");
//        System.out.println();
//        select(dp,"SElect * From t2 where id = 0");
//        System.out.println();
//        select(dp,"SElect * From t2 where id > 0");
//        System.out.println();
//        select(dp,"SElect * From t2 where id <= 0");    // Error Here
//        System.out.println();
//        System.out.println(dp.executeUpdateQuery("DElete * From t2"));
//        System.out.println();
//        select(dp,"SElect * From t2");
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
