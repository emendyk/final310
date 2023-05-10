package edu.guilford;

import javafx.scene.image.Image;

import java.io.File;

/**
 * The Shorts class represents shorts as a type of clothing.
 * It extends the abstract class Clothes.
 */
public class Shorts extends Clothes {

    private final String imageName = "Shorts.png";

    /**
     * Constructs a new instance of the Shorts class.
     * It sets the image name to "Shorts" using the superclass constructor.
     */
    public Shorts() {
        super("Shorts");
    }

    /**
     * Retrieves the URL of the shorts image.
     *
     * @return the URL of the shorts image
     */
    @Override
    protected String getImageUrl() {
        File file = new File("resources/edu/guilford/" + imageName);
        return file.toURI().toString();
    }

    /**
     * Generates an outfit image based on the temperature and weather condition.
     * If the temperature is less than 60 degrees Fahrenheit or the weather condition is raining,
     * null is returned; otherwise, a shorts image is returned.
     *
     * @param temperature      the temperature in degrees Fahrenheit
     * @param weatherCondition the weather condition
     * @return the generated outfit image or null
     */
    @Override
    public Image getOutfit(double temperature, WeatherCondition weatherCondition) {
        if (temperature < 60 || weatherCondition == WeatherCondition.RAINING) {
            return null;
        }
        return new Image(getImageUrl());
    }
}
