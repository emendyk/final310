package edu.guilford;

public class WeatherCondition {
    
    private final String description;

    public static final WeatherCondition SUNNY = new WeatherCondition("sunny");
    public static final WeatherCondition RAINING = new WeatherCondition("raining");
    public static final WeatherCondition CLOUDY = new WeatherCondition("cloudy");
    public static final WeatherCondition WINDY = new WeatherCondition("windy");

    public WeatherCondition( String description) {
        
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public static WeatherCondition valueOf(String upperCase) {
        return null;
    }
}
