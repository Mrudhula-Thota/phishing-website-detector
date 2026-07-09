import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HistoryViewer {

    public static String getHistory() {

        String history = "";

        try {

            Connection con = DatabaseConnection.getConnection();

            String query = "SELECT * FROM website_history";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                history += "URL : " + rs.getString("url") + "\n";

                history += "Prediction : " + rs.getString("prediction") + "\n";

                history += "Date : " + rs.getTimestamp("date") + "\n";

                history += "---------------------------------\n";

            }

        } catch (Exception e) {

            history = "Error loading history";

        }

        return history;

    }

}
