package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainJdbc {
    public static void main(String[] args) {

        try {
            Class.forName("myDriver.ClassName");
        } catch (java.lang.ClassNotFoundException e) {

            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
            System.exit(1);
        }
// Contains Database name.
        String url = "jdbc:mySubprotocol:myDataSource";
        Connection con;
        Statement stmt;
        String createString = "create table COFFEES "
                + "(COF_NAME VARCHAR, " + "SUP_ID INTEGER, "
                + "PRICE INTEGER, " + "SALES INTEGER, " + "TOTAL INTEGER)";
        try {
            con = DriverManager.getConnection(url, "myLogin", "myPassword");
            stmt = con.createStatement();
            stmt.executeUpdate(createString); // Execute SQL queries.
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }


}

