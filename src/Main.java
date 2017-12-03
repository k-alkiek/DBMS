import data.DatabaseManager;
import data.IField;
import data.TableCachedXml;
import eg.edu.alexu.csd.oop.db.Database;
import eg.edu.alexu.csd.oop.db.cs15.DatabaseImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by khaledabdelfattah on 11/28/17.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = new DatabaseImp();
        String query, databaseInUse = null;
        Scanner input = new Scanner(System.in);
        while (true) {
            query = input.nextLine();
            query = query.trim();
            if (query.toLowerCase().contains("create database")) {
                databaseInUse = query.trim().split("\\s+")[2].toLowerCase();
                System.out.println(database.createDatabase(databaseInUse.toLowerCase().trim(), false));
            } else if (query.toLowerCase().startsWith("create") || query.toLowerCase().startsWith("drop")) {
                try {
                    System.out.println(database.executeStructureQuery(query));
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
            } else if (query.toLowerCase().startsWith("select")) {
                try {
                    List<IField> fields = (new TableCachedXml(databaseInUse, query.trim().split("\\s+")[3])).getFields();
                    Object[][] values = database.executeQuery(query);
                    Object[][] table = new Object[values.length + 1][values[0].length];
                    for (int i = 0; i < fields.size(); i++) {
                        table[0][i] = fields.get(i).getName();
                    }
                    for (int i = 0; i < values.length; i++) {
                        for (int j = 0; j < values[i].length; j++) {
                            table[i + 1][j] = values[i][j];
                        }
                    }
                    drawTable(table);
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
            } else {
                try {
                    System.out.println("You have made changes to the database. Rows affected: "
                            + database.executeUpdateQuery(query));
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
            }
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
