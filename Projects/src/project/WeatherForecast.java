package Projects.src.project;

import javax.swing.*;
import java.awt.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class WeatherForecast extends JFrame {
    private JTextField cityLabel;
    private JLabel weatherLabel;
    private JButton fetchButton;
    private final String apiKey = "2b44e3e637d30c72e17468da9689fc76";

    public WeatherForecast() {
        this.setTitle("Weather Forecast");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        cityLabel = new JTextField("Enter city name");
        weatherLabel = new JLabel("Weather data will be displayed here", JLabel.CENTER);
        fetchButton = new JButton("Fetch Weather");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(cityLabel, BorderLayout.CENTER);
        topPanel.add(fetchButton, BorderLayout.EAST);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(weatherLabel, BorderLayout.CENTER);

        fetchButton.addActionListener(e -> fetchWeatherData());
    }

    private void fetchWeatherData() {
        String city = cityLabel.getText().trim();

        String api = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%sunits=metric", city,
                this.apiKey);

        new Thread(() -> {
            try {

                URL url = new URL(api);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null)
                    response.append(line);

                reader.close();
                connection.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> weatherLabel.setText("Error fetching data"));

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WeatherForecast app = new WeatherForecast();
            app.setVisible(true);
        });
    }
}