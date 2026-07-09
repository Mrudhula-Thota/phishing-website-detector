import java.sql.Connection;
import java.sql.PreparedStatement;

public class SaveResult {

    public static void save(String url, String prediction) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String query =
                    "INSERT INTO website_history(url, prediction) VALUES(?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, url);
            ps.setString(2, prediction);

            ps.executeUpdate();

            System.out.println("Data Saved Successfully");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

}
