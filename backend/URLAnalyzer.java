public class URLAnalyzer {

    public String analyze(String url) {

        String result = "";

        result += "URL : " + url + "\n";

        int length = url.length();

        result += "Length : " + length + "\n";

        // HTTPS feature
        int https = 0;

        if (url.startsWith("https://")) {

            result += "Secure URL\n";
            https = 1;

        } else {

            result += "Not Secure\n";
        }

        // Numbers feature
        int numbers = 0;

        if (url.matches(".*\\d+.*")) {

            result += "Contains Numbers\n";
            numbers = 1;
        }

        // @ symbol feature
        int atSymbol = 0;

        if (url.contains("@")) {

            result += "@ Symbol Found\n";
            atSymbol = 1;
        }

        // Hyphen feature
        int hyphen = 0;

        if (url.contains("-")) {

            result += "Hyphen Symbol Found\n";
            hyphen = 1;
        }

        // Keyword feature
        int keyword = 0;

        if (url.contains("login")
                || url.contains("verify")
                || url.contains("update")
                || url.contains("bank")) {

            result += "Suspicious Keyword Found\n";
            keyword = 1;
        }

        // Machine Learning Prediction
        String prediction = MLModel.predict(
                length,
                https,
                numbers,
                atSymbol,
                hyphen,
                keyword
        );

        result += "\nAI Prediction : " + prediction + "\n";

        if (prediction.equalsIgnoreCase("Phishing")) {

            result += "WARNING : PHISHING WEBSITE DETECTED\n";

            SaveResult.save(url, "Phishing");

        } else {

            result += "Website Appears Safe\n";

            SaveResult.save(url, "Safe");
        }

        return result;
    }
}