import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

    JTextField urlField;
    JButton analyzeButton, clearButton, historyButton, exportButton, exitButton;
    JTextArea resultArea;
    JLabel statusLabel;

    public GUI() {

        setTitle("Phishing Website Detection System");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Background Image
        Image bgImage = new ImageIcon(
                "C:\\Users\\koppu\\Desktop\\PhishingWebsiteDetectionSystem\\images\\ai_background.jpg")
                .getImage()
                .getScaledInstance(950, 700, Image.SCALE_SMOOTH);

        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));

        setContentPane(background);

        // Title
        JLabel title = new JLabel("PHISHING WEBSITE DETECTION SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(Color.WHITE);

        // URL Label
        JLabel label = new JLabel("Enter Website URL");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.CYAN);

        // URL Text Field
        urlField = new JTextField(45);
        urlField.setFont(new Font("Arial", Font.PLAIN, 16));
        urlField.setBackground(Color.GRAY);
        urlField.setForeground(Color.BLACK);

        // Buttons
        analyzeButton = new JButton("Analyze");
        clearButton = new JButton("Clear");
        historyButton = new JButton("History");
        exportButton = new JButton("Export CSV");
        exitButton = new JButton("Exit");

        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        analyzeButton.setFont(buttonFont);
        clearButton.setFont(buttonFont);
        historyButton.setFont(buttonFont);
        exportButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        analyzeButton.setBackground(Color.GREEN);
        clearButton.setBackground(Color.ORANGE);
        historyButton.setBackground(Color.YELLOW);
        exportButton.setBackground(new Color(138, 43, 226));
        exportButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);

        // Status Label
        statusLabel = new JLabel("Status : Ready");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel.setForeground(Color.WHITE);

        // Result Area
        resultArea = new JTextArea(18, 55);
        resultArea.setEditable(false);
        resultArea.setBackground(Color.BLACK);
        resultArea.setForeground(Color.GREEN);
        resultArea.setFont(new Font("Consolas", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Button actions
        analyzeButton.addActionListener(this);
        clearButton.addActionListener(this);
        historyButton.addActionListener(this);
        exportButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Add Components
        add(title);
        add(label);
        add(urlField);

        add(analyzeButton);
        add(clearButton);
        add(historyButton);
        add(exportButton);
        add(exitButton);

        add(statusLabel);
        add(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == analyzeButton) {

            String url = urlField.getText();

            URLAnalyzer analyzer = new URLAnalyzer();

            String result = analyzer.analyze(url);

            resultArea.setText(result);

            if (result.contains("PHISHING")) {

                resultArea.setForeground(Color.RED);
                statusLabel.setForeground(Color.RED);
                statusLabel.setText("🔴 PHISHING WEBSITE DETECTED");

            } else {

                resultArea.setForeground(Color.GREEN);
                statusLabel.setForeground(Color.GREEN);
                statusLabel.setText("🟢 SAFE WEBSITE");
            }
        }

        if (e.getSource() == clearButton) {

            urlField.setText("");
            resultArea.setText("");

            statusLabel.setText("Status : Ready");
            statusLabel.setForeground(Color.WHITE);
        }

        if (e.getSource() == historyButton) {

            resultArea.setForeground(Color.GREEN);
            resultArea.setText(HistoryViewer.getHistory());
        }

        if (e.getSource() == exportButton) {

            ExportCSV.exportHistory();

            resultArea.setForeground(Color.GREEN);
            resultArea.setText("History exported successfully to history.csv");
        }

        if (e.getSource() == exitButton) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new GUI();

    }
}
