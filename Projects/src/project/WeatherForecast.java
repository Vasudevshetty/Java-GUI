package Projects.src.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class WeatherForecast extends JFrame {
    private JTextField cityLabel;
    private JLabel weatherLabel;
    private JButton fetchButton;
    private final String apiKey = "2b44e3e637d30c72e17468da9689fc76";
    private final String placeholder = "Enter city name";
    private final String weather = "<html>Weather data will be displayed here</html>";

    public WeatherForecast() {
        this.setTitle("Weather Forecast");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        cityLabel = new JTextField(placeholder);
        weatherLabel = new JLabel(weather, JLabel.CENTER);
        fetchButton = new JButton("Fetch Weather");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(cityLabel, BorderLayout.CENTER);
        topPanel.add(fetchButton, BorderLayout.EAST);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(weatherLabel, BorderLayout.CENTER);

        cityLabel.addActionListener(e -> cityLabel.setText(""));

        fetchButton.addActionListener(e -> fetchWeatherData());

        cityLabel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cityLabel.getText().equals(placeholder))
                    cityLabel.setText("");
                weatherLabel.setText(weather);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cityLabel.getText().isEmpty()) {
                    cityLabel.setText(placeholder);

                }
            }
        });

        cityLabel.addActionListener((e) -> fetchWeatherData());
    }

    private void fetchWeatherData() {
        String city = cityLabel.getText().trim();

        String api = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city,
                this.apiKey);

        new Thread(() -> {
            try {

                @SuppressWarnings("deprecation")
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

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONObject main = jsonResponse.getJSONObject("main");
                double temp = main.getDouble("temp") - 273.15;
                int humidity = main.getInt("humidity");
                String description = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");

                String weatherData = String.format(
                        "<html>Temperature: %.1f°C<br>Humidity:%d%%<br>Description: %s</html>",
                        temp, humidity, description);
                SwingUtilities.invokeLater(() -> weatherLabel.setText(weatherData.toString()));

            } catch (Exception e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> weatherLabel.setText("Error fetching data"));

            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WeatherForecast app = new WeatherForecast();
            app.setVisible(true);
            app.requestFocusInWindow();
        });
    }
}