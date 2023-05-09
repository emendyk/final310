package edu.guilford;

public class WeatherCondition {
    private final double temperature;
    private final String description;

    public static final WeatherCondition SUNNY = new WeatherCondition(75, "sunny");
    public static final WeatherCondition RAINING = new WeatherCondition(65, "raining");
    public static final WeatherCondition CLOUDY = new WeatherCondition(70, "cloudy");
    public static final WeatherCondition WINDY = new WeatherCondition(72, "windy");

    public WeatherCondition(double temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    public static WeatherCondition valueOf(String upperCase) {
        return null;
    }
}
