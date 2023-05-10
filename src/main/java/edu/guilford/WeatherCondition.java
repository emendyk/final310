package edu.guilford;

/**
 * The WeatherCondition class represents different weather conditions.
 */
public class WeatherCondition {

    private final String description;

    /**
     * Represents a sunny weather condition.
     */
    public static final WeatherCondition SUNNY = new WeatherCondition("sunny");

    /**
     * Represents a raining weather condition.
     */
    public static final WeatherCondition RAINING = new WeatherCondition("raining");

    /**
     * Represents a cloudy weather condition.
     */
    public static final WeatherCondition CLOUDY = new WeatherCondition("cloudy");

    /**
     * Represents a windy weather condition.
     */
    public static final WeatherCondition WINDY = new WeatherCondition("windy");

    /**
     * Constructs a new instance of the WeatherCondition class with the specified description.
     *
     * @param description the description of the weather condition
     */
    public WeatherCondition(String description) {
        this.description = description;
    }

    /**
     * Retrieves the description of the weather condition.
     *
     * @return the description of the weather condition
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the WeatherCondition constant with the specified uppercase name.
     * This method always returns null in the current implementation.
     *
     * @param upperCase the uppercase name of the weather condition
     * @return the WeatherCondition constant with the specified uppercase name, or null
     */
    public static WeatherCondition valueOf(String upperCase) {
        return null;
    }
}
