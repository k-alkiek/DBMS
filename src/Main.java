import eg.edu.alexu.csd.oop.db.Database;
import eg.edu.alexu.csd.oop.db.cs15.DatabaseImp;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by khaledabdelfattah on 11/28/17.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = new DatabaseImp();
        String query;
        Scanner input = new Scanner(System.in);
        while (true) {
            query = input.nextLine();
            query = query.trim();
            if (query.toLowerCase().startsWith("create (\\s+) database")) {
                database.createDatabase(query, false);
            } else if (query.toLowerCase().startsWith("create") || query.toLowerCase().startsWith("drop")) {
                System.out.println(database.executeStructureQuery(query));
            } else if (query.toLowerCase().startsWith("select")) {
                Object[][] values = database.executeQuery(query);
                for (int i = 0; i < values.length; i ++) {
                    for (int j = 0; j < values[i].length; j ++) {
                        System.out.print(values[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println(database.executeUpdateQuery(query));
            }
        }
    }

    public void execute(String query) {
        query = query.toLowerCase();
        if (query.startsWith("create")) {

        }
    }
}
