package main;

import eg.edu.alexu.csd.oop.db.cs15.DatabaseImp;

import java.sql.SQLException;

public class MainTester {
    public static void main(String[] args) throws SQLException {
        DatabaseImp dp = new DatabaseImp();
        dp.executeStructureQuery("Drop database sc3");
        dp.createDatabase("sc3",false);
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name1(column_name1 varchar , column_name2 int, column_name3 varchar) "));
        System.out.println(dp.executeUpdateQuery("INSERT INTO * table_name2(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INS ERT INTO table_name3(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name4(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name4(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("UPDATE table_name4 SET column_name1=='1111111111', COLUMN_NAME2=2222222, column_name3='333333333'"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name5(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name5(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("UPDATE table_name5 SET column_name1='1111111111', COLUMN_NAME2='2222222', column_name3='333333333'"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name6(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name6(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("UPDATE table_name6 SET column_name1='1111111111', COLUMN_NAME2=2222222, column_name3='333333333"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name7(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name7(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name8(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name8(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 4, 'value2')"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name9(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO ta.ble_name9(column_NAME1, COLUMN_name3, column_name.2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeStructureQuery("Create TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INSERt INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_name1, COLUMN_NAME3, column_NAME2) VAlUES ('value2', 'value4', 5)"));
        System.out.println(dp.executeUpdateQuery("UPDATE table_namE1 SET column_name1='11111111', COLUMN_NAME2=22222222, column_name3='333333333' WHERE coLUmn_NAME3='VALUE3'"));
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
        System.out.println("delete : "+dp.executeUpdateQuery("DELETE From table_name2 WHERE coLUmn_NAME1='VAluE1'"));
        System.out.println(dp.executeUpdateQuery("UPDATE table_name2 SET column_name1='11111111', COLUMN_NAME2=22222222, column_name3='333333333' WHERE coLUmn_NAME2=4"));
        System.out.println(dp.executeStructureQuery("CREATE TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 5)"));
        System.out.println(dp.executeUpdateQuery("INSERT INTO table_name1(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 6)"));
        select(dp,"select * from  table_name1 WHERE column_name2=4");
        System.out.println("delete : "+dp.executeUpdateQuery("DELETE From table_name1 WHERE coLUmn_NAME2=4"));
        select(dp,"SELECT * FROM table_name1 WHERE coluMN_NAME2 < 6");
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
