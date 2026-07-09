import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;

public class MLModel {

    public static String predict(int length,
                                 int https,
                                 int numbers,
                                 int atSymbol,
                                 int hyphen,
                                 int keyword) {

        String prediction = "";

        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "python",
                    "predict.py",
                    String.valueOf(length),
                    String.valueOf(https),
                    String.valueOf(numbers),
                    String.valueOf(atSymbol),
                    String.valueOf(hyphen),
                    String.valueOf(keyword)
            );

            // Set working directory to ml folder
            pb.directory(new File(
                    "C:\\Users\\koppu\\Desktop\\PhishingWebsiteDetectionSystem\\ml"));

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println("Python Output : " + line);

                prediction = line;
            }

            while ((line = errorReader.readLine()) != null) {

                System.out.println("Python Error : " + line);
            }

            process.waitFor();

        }

        catch (Exception e) {

            e.printStackTrace();

            prediction = "Error";
        }

        return prediction;
    }
}