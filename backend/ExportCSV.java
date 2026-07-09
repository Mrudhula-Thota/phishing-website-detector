import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExportCSV {

    public static void exportHistory() {

        try {

            Connection con = DatabaseConnection.getConnection();

            String query = "SELECT * FROM website_history";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            FileWriter writer = new FileWriter(
"C:\\Users\\koppu\\Desktop\\PhishingWebsiteDetectionSystem\\history.csv");

            writer.append("URL,Prediction,Date\n");

            while(rs.next())
            {
                writer.append(rs.getString("url"));
                writer.append(",");

                writer.append(rs.getString("prediction"));
                writer.append(",");

                writer.append(rs.getString("date"));
                writer.append("\n");
            }

            writer.flush();
            writer.close();

            System.out.println("CSV File Created Successfully");

        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}