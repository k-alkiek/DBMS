package main;

import eg.edu.alexu.csd.oop.db.cs15.DriverImp;
import eg.edu.alexu.csd.oop.db.cs15.Log;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class CommandLineInterface {


    public static void main(String[] args) {
        Logger log = Log.getLogger();
        log.info("Start The Program");
        Driver driver = new DriverImp();
        Properties info = new Properties();
        File dbDir = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Databases"+ System.getProperty("file.separator"));
        info.put("path", dbDir.getAbsoluteFile());
        Connection connection = null;
        try {
            connection = driver.connect("jdbc:xmldb://localhost", info);
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            String query = null;
            while (true) {
                System.out.println("Enter Your SQL Query or Exit to exit");
                query = scanner.nextLine();
                log.info("User Entered : "+query);
                query = query.trim();
                if(query.toLowerCase().equals("exit"))
                {
                    log.info("End The Program");
                    break;
                }
                if (query.toLowerCase().startsWith("create") || query.toLowerCase().startsWith("drop")) {
                    try {
                        if(statement.execute(query)) {
                            System.out.println("Done");
                        }
                        else {
                            System.out.println("Can't execute that");
                        }
                    } catch (Exception e) {
                        log.error("Error");
                        System.out.println("ERROR");
                    }
                } else if (query.toLowerCase().startsWith("select")) {
                    try {
                        ResultSet resultSet = statement.executeQuery(query);
                        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                        System.out.println(resultSetMetaData.getTableName(0) + " :");
                        int columnNumber = resultSetMetaData.getColumnCount();
                        int rowNumber = 0;
                        List<Object[]> table = new ArrayList<>();
                        Object[] firstColumn = new Object[columnNumber];
                        for (int i = 0; i < columnNumber; i++) {
                            firstColumn[i] = resultSetMetaData.getColumnName(i+1);
                        }
                        table.add(firstColumn);
                        rowNumber++;
                        resultSet.first();
                        while (!resultSet.isAfterLast())
                        {
                            Object[] column = new Object[columnNumber];
                            for (int i = 0; i < columnNumber; i++) {
                                column[i] = resultSet.getObject(i+1);
                            }
                            table.add(column);
                            rowNumber++;
                            resultSet.next();
                        }
                        Object[][] newTable = new Object[columnNumber][rowNumber];
                        for(int i = 0;i < rowNumber;i++) {
                            for(int j = 0;j < columnNumber;j++) {
                                newTable[i][j] = table.get(i)[j];
                            }
                        }
                        drawTable(newTable);
                    } catch (Exception e) {
                        log.error("Error");
                        System.out.println("ERROR");
                    }
                } else {
                    try {
                        System.out.println("You have made changes to the database. Rows affected: "
                                + statement.executeUpdate(query));
                    } catch (Exception e) {
                        log.error("Error");
                        System.out.println("ERROR");
                    }
                }
            }
        } catch (SQLException e) {
            log.error("ERROR");
            System.out.println("Error Connecting to the Driver");
        }


    }

    public static void drawTable(Object[][] values) {
        List<Integer> lengths = new ArrayList<>();
        for (int i = 0; i < values[0].length; i ++) {
            int maxLen = -1;
            for (int j = 0; j < values.length; j ++) {
                maxLen = Math.max(maxLen, values[j][i].toString().length());
            }
            lengths.add(maxLen + 4);
        }
        for (int i = 0; i < values.length; i ++) {
            System.out.print("+");
            for (int j = 0; j < values[i].length; j++) {
                for(int k = 0; k < lengths.get(j) - 2; k ++)
                    System.out.print("-");
                System.out.print("+");
            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < values[i].length; j++) {
                System.out.print(values[i][j].toString());
                int length = values[i][j].toString().length();
                for(int k = 0; k < lengths.get(j) - length - 2; k ++)
                    System.out.print(" ");
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.print("+");
        for (int j = 0; j < values[0].length; j++) {
            for(int k = 0; k < lengths.get(j) - 2; k ++)
                System.out.print("-");
            System.out.print("+");
        }
        System.out.println();
    }


}
