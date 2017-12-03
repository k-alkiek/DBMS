package main;

import eg.edu.alexu.csd.oop.db.cs15.DriverImp;
import eg.edu.alexu.csd.oop.db.cs15.Log;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.*;
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
                        // Todo
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


}
