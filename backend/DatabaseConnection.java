import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/phishing_detection",
                    "root",
                    "");

            System.out.println("Database Connected Successfully");

            return con;

        } catch (Exception e) {

            System.out.println("Connection Error");
            e.printStackTrace();

            return null;
        }
    }
}