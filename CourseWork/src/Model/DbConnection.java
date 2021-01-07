package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static Connection conn = connect();

    public static Connection connect() {

        try {
            Class.forName("java.sql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/election_voting_system", "root", "5051Cent");
            System.out.println("Database Connected");

        } catch (Exception e) {
            System.out.println("Database not Connected");
        }

        return conn;
    }
}
